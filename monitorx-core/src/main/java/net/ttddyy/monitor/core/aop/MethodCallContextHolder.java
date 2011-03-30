package net.ttddyy.monitor.core.aop;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextHolder {
    private static MethodCallContextHolderStrategy strategy = new ThreadLocalContextHolderStrategy();

    @SuppressWarnings("unchecked")
    public static <T extends MethodCallContext> T getContext() {
        return (T)strategy.getContext();
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
