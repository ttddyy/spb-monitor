package net.ttddyy.monitor.core.aop;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallContextRepository {
    void persist(MethodCallContext context);
}
