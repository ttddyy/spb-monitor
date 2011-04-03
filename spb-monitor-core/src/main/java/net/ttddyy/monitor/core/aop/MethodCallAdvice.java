package net.ttddyy.monitor.core.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopInfrastructureBean;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallAdvice implements MethodInterceptor, AopInfrastructureBean {

    private MethodCallManager manager;

    public Object invoke(MethodInvocation invocation) throws Throwable {

        // call manager only when context exists.
        if (!MethodCallContextHolder.hasContext()) {
            return invocation.proceed();
        }

        // TODO: change to use @ExcludeMonitoring annotation
        final Object target = invocation.getThis();
        if (target.equals(manager) || target instanceof MethodCallEventListener) {
            return invocation.proceed();
        }

        /////////
        // internally use this id to keep truck of before & after method call
        final String invocationId = UUID.randomUUID().toString();


        final long currentTime = System.currentTimeMillis();

        manager.beforeMethod(invocation, invocationId);

        final Object retVal;
        try {
            retVal = invocation.proceed();
        } catch (Throwable e) {
            final long processTime = currentTime - System.currentTimeMillis();
            manager.afterThrow(invocation, invocationId, processTime, e);
            throw e;
        }
        final long processTime = currentTime - System.currentTimeMillis();
        manager.afterMethod(invocation, invocationId, processTime);

        return retVal;
    }

    @Resource
    public void setManager(MethodCallManager manager) {
        this.manager = manager;
    }
}
