package net.ttddyy.monitor.core.aop;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallManager {

    void beforeMethod(MethodInvocation invocation);

    void afterMethod(MethodInvocation invocation, long processTime);

    void afterThrow(MethodInvocation invocation, long processTime, Throwable throwable);

    void finalizeContext();

}
