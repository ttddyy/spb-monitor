package net.ttddyy.monitor.core.aop;

/**
 * @author Tadaya Tsuyukubo
 */
public class ThreadLocalContextHolderStrategy implements MethodCallContextHolderStrategy {

    private static ThreadLocal<MethodCallContext> contextHolder = new ThreadLocal<MethodCallContext>();

    private MethodCallContextPolicy contextPolicy = MethodCallContextPolicy.ALWAYS_CREATE;

    @SuppressWarnings("unchecked")
    public <T extends MethodCallContext> T getContext() {
        if (MethodCallContextPolicy.ALWAYS_CREATE == contextPolicy && contextHolder.get() == null) {
            contextHolder.set(new MethodCallContext());
        }

        return (T) contextHolder.get();
    }

    public void setContext(MethodCallContext context) {
        contextHolder.set(context);
    }

    public void clearContext() {
        contextHolder.set(null);
    }

    public boolean hasContext() {
        if (MethodCallContextPolicy.ALWAYS_CREATE == contextPolicy) {
            return true;
        } else {
            return contextHolder.get() != null;
        }
    }
}
