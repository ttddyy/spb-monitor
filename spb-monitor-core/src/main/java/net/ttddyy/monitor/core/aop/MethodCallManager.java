package net.ttddyy.monitor.core.aop;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallManager {

    void beforeMethod(MethodInvocation invocation, String invocationId);

    void afterMethod(MethodInvocation invocation, String invocationId, long processTime);

    void afterThrow(MethodInvocation invocation, String invocationId, long processTime, Throwable throwable);

    void finalizeContext();

}
