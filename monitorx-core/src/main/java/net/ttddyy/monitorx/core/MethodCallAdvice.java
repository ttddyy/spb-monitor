package net.ttddyy.monitorx.core;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Resource;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallAdvice implements MethodInterceptor {

    private MonitorxManager manager;

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
        ////////

        final long currentTime = System.currentTimeMillis();

        manager.beforeMethod(invocation);

        final Object retVal;
        try {
            retVal = invocation.proceed();
        } catch (Throwable e) {
            final long processTime = currentTime - System.currentTimeMillis();
            manager.afterThrow(invocation, processTime, e);
            throw e;
        }
        final long processTime = currentTime - System.currentTimeMillis();
        manager.afterMethod(invocation, processTime);

        return retVal;
    }

    @Resource
    public void setManager(MonitorxManager manager) {
        this.manager = manager;
    }
}
