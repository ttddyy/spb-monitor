package net.ttddyy.monitorx.core.test;

/**
 * @author Tadaya Tsuyukubo
 */
public class FooFooSampleEvent extends FooSampleEvent {
    public FooFooSampleEvent(Object source) {
        super(source);
        System.out.println("FOO FOO Sample Event");
    }
}
