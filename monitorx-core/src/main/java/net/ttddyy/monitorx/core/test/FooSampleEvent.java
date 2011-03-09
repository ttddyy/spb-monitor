package net.ttddyy.monitorx.core.test;

/**
 * @author Tadaya Tsuyukubo
 */
public class FooSampleEvent extends SampleEvent{
    public FooSampleEvent(Object source) {
        super(source);
        System.out.println("FOO Sample Event");
    }
}
