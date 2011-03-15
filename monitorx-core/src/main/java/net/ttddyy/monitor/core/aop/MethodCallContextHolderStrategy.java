package net.ttddyy.monitor.core.aop;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallContextHolderStrategy {

    MethodCallContext getContext();

    void setContext(MethodCallContext context);

    void clearContext();

    boolean hasContext();

}
