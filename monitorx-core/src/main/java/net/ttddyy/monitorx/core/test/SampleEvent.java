package net.ttddyy.monitorx.core.test;

import org.springframework.context.ApplicationEvent;

/**
 * @author Tadaya Tsuyukubo
 */
public class SampleEvent extends ApplicationEvent {
    public SampleEvent(Object source) {
        super(source);
        System.out.println("Sample Event");
    }
}
