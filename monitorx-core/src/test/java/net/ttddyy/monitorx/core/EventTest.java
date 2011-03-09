package net.ttddyy.monitorx.core;

import net.ttddyy.monitorx.core.test.BarSampleEvent;
import net.ttddyy.monitorx.core.test.FooFooSampleEvent;
import net.ttddyy.monitorx.core.test.FooSampleEvent;
import net.ttddyy.monitorx.core.test.SampleEvent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author Tadaya Tsuyukubo
 */
@ContextConfiguration
public class EventTest extends AbstractTestNGSpringContextTests {

    @Test
    public void test() {
        System.out.println("-- fire SampleEvent");
        applicationContext.publishEvent(new SampleEvent(this));
        System.out.println("-- fire FooSampleEvent");
        applicationContext.publishEvent(new FooSampleEvent(this));
        System.out.println("-- fire BarSampleEvent");
        applicationContext.publishEvent(new BarSampleEvent(this));
        System.out.println("-- fire FooFooSampleEvent");
        applicationContext.publishEvent(new FooFooSampleEvent(this));
    }
}
