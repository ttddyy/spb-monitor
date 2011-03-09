package net.ttddyy.monitorx.core;

/**
 * @author Tadaya Tsuyukubo
 */
public class ThreadLocalContextHolderStrategy implements MethodCallContextHolderStrategy {

    private static ThreadLocal<MethodCallContext> contextHolder = new ThreadLocal<MethodCallContext>();

    public MethodCallContext getContext() {
        if (contextHolder.get() == null) {
            contextHolder.set(new MethodCallContext());
        }

        return contextHolder.get();
    }

    public void setContext(MethodCallContext context) {
        contextHolder.set(context);
    }

    public void clearContext() {
        contextHolder.set(null);
    }
}
