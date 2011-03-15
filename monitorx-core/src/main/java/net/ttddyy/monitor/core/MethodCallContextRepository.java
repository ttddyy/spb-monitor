package net.ttddyy.monitor.core;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallContextRepository {
    void persist(MethodCallContext context);
}
