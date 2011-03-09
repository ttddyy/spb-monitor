package net.ttddyy.monitorx.core;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MonitorxManager {

    void beforeMethod(MethodInvocation invocation);

    void afterMethod(MethodInvocation invocation, long processTime);

    void afterThrow(MethodInvocation invocation, long processTime, Throwable throwable);

    void finalizeContext();

}
