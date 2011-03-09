package net.ttddyy.monitorx.core;

import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextPersistEventListener implements ApplicationListener<MethodCallContextPersistEvent> {

    private MethodCallContextPersistStrategy strategy;

    public void onApplicationEvent(MethodCallContextPersistEvent event) {
        final MethodCallContext context = event.getContext();
        strategy.persist(context);  // delegate to strategy
    }

    public void setStrategy(MethodCallContextPersistStrategy strategy) {
        this.strategy = strategy;
    }
}
