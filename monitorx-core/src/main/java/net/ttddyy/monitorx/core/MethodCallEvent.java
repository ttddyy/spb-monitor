package net.ttddyy.monitorx.core;


import org.springframework.context.ApplicationEvent;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallEvent extends ApplicationEvent {
    private MethodCallEntry entry;

    public MethodCallEvent(Object source, MethodCallEntry entry) {
        super(source);
        this.entry = entry;
    }

    public MethodCallEntry getEntry() {
        return entry;
    }
}
