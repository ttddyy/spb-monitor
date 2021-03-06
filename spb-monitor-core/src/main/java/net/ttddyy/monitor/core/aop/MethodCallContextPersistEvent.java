package net.ttddyy.monitor.core.aop;

import org.springframework.context.ApplicationEvent;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextPersistEvent extends ApplicationEvent {
    private MethodCallContext context;

    public MethodCallContextPersistEvent(Object source, MethodCallContext context) {
        super(source);
        this.context = context;
    }

    public MethodCallContext getContext() {
        return context;
    }
}
