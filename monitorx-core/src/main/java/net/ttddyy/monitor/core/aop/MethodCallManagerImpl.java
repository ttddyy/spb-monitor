package net.ttddyy.monitor.core.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tadaya Tsuyukubo
 */
@ExcludeMonitoring
public class MethodCallManagerImpl implements MethodCallManager, ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    private Map<String, Integer> invocationIdToPairId = new HashMap<String, Integer>();

    private Integer getNewPairId() {
        final MethodCallContext context = MethodCallContextHolder.getContext();
        final List<MethodCallEntry> entries = context.getEntries();
        int methodPairId = 0;
        for (MethodCallEntry entry : entries) {
            if (entry.getCallType() == MethodCallType.BEFORE_METHOD) {
                methodPairId++;
            }
        }
        return methodPairId;
    }

    public void beforeMethod(MethodInvocation invocation, String invocationId) {
        final Integer pairId = getNewPairId();
        invocationIdToPairId.put(invocationId, pairId); // keep invocationId for afterMethod & afterThrow
        onCall(MethodCallType.BEFORE_METHOD, invocation, pairId, 0);
    }

    public void afterMethod(MethodInvocation invocation, String invocationId, long processTime) {
        final Integer pairId = invocationIdToPairId.remove(invocationId);
        onCall(MethodCallType.AFTER_METHOD, invocation, pairId, processTime);
    }

    public void afterThrow(MethodInvocation invocation, String invocationId, long processTime, Throwable throwable) {
        final Integer pairId = invocationIdToPairId.remove(invocationId);
        onCall(MethodCallType.AFTER_THROW, invocation, pairId, processTime);
    }

    private void onCall(MethodCallType callType, MethodInvocation invocation, Integer pairId, long processTime) {
        final MethodCallContext context = MethodCallContextHolder.getContext();

        // create entry
        // translator to transform arguments

        final MethodCallEntry entry = getNewEntry(callType, invocation, pairId, processTime);
        context.addEntry(entry);

        // fire event
        final MethodCallEvent event = new MethodCallEvent(this, entry);
        eventPublisher.publishEvent(event);
    }

    private MethodCallEntry getNewEntry(MethodCallType callType, MethodInvocation invocation, Integer pairId, long processTime) {
        final Method method = invocation.getMethod();
        final String className = method.getDeclaringClass().getName();
        final String methodName = method.getName();


        final MethodCallEntry entry = new MethodCallEntry();
        entry.setCallType(callType);
        entry.setPairId(pairId);
        entry.setClassName(className);
        entry.setMethodName(methodName);
        entry.setTimestamp(System.currentTimeMillis());
        entry.setProceeTime(processTime);

        return entry;
    }

    public void finalizeContext() {
        // TODO: persist context (if not empty??)
        persistContext();

        // clear the context
        MethodCallContextHolder.clearContext();
    }

    private void persistContext() {
        final MethodCallContext context = MethodCallContextHolder.getContext();
        final MethodCallContextPersistEvent event = new MethodCallContextPersistEvent(this, context);
        eventPublisher.publishEvent(event);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
