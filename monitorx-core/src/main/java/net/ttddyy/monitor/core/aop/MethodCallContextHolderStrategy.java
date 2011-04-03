package net.ttddyy.monitor.core.aop;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallContextHolderStrategy {

    <T extends MethodCallContext> T getContext();

    void setContext(MethodCallContext context);

    void clearContext();

    boolean hasContext();

}
