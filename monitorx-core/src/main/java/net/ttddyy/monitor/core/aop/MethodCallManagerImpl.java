package net.ttddyy.monitor.core.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.lang.reflect.Method;

/**
 * @author Tadaya Tsuyukubo
 */
@ExcludeMonitoring
public class MethodCallManagerImpl implements MethodCallManager, ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    public void beforeMethod(MethodInvocation invocation) {
        onCall(MethodCallType.BEFORE_METHOD, invocation);
    }

    public void afterMethod(MethodInvocation invocation, long processTime) {
        onCall(MethodCallType.AFTER_METHOD, invocation);
    }

    public void afterThrow(MethodInvocation invocation, long processTime, Throwable throwable) {
        onCall(MethodCallType.AFTER_THROW, invocation);
    }

    private void onCall(MethodCallType callType, MethodInvocation invocation) {
        final MethodCallContext context = MethodCallContextHolder.getContext();

        // create entry
        // translator to transform arguments

        final MethodCallEntry entry = getEntry(callType, invocation);
        context.addEntry(entry);

        // fire event
        final MethodCallEvent event = new MethodCallEvent(this, entry);
        eventPublisher.publishEvent(event);
    }

    private MethodCallEntry getEntry(MethodCallType callType, MethodInvocation invocation) {
        final Method method = invocation.getMethod();
        final String className = method.getDeclaringClass().getName();
        final String methodName = method.getName();


        final MethodCallEntry entry = new MethodCallEntry();
        entry.setCallType(callType);
        entry.setClassName(className);
        entry.setMethodName(methodName);

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