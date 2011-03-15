package net.ttddyy.monitor.core;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextHolder {
    private static MethodCallContextHolderStrategy strategy = new ThreadLocalContextHolderStrategy();

    public static MethodCallContext getContext() {
        return strategy.getContext();
    }

    public static void setContext(MethodCallContext context) {
        strategy.setContext(context);
    }

    public static void clearContext() {
        strategy.clearContext();
    }

    public static boolean hasContext() {
        return strategy.hasContext();
    }
}
