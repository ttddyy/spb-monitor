package net.ttddyy.monitorx.core.test;

/**
 * @author Tadaya Tsuyukubo
 */
public class BarSampleEvent extends SampleEvent {
    public BarSampleEvent(Object source) {
        super(source);
        System.out.println("Bar Sample Event");
    }
}
