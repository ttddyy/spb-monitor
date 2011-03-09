package net.ttddyy.monitorx.core.test;

import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
public class FooSampleEventListener implements ApplicationListener<FooSampleEvent> {
    public void onApplicationEvent(FooSampleEvent event) {
        System.out.println("FooSampleEventListener : " + event);
    }
}
