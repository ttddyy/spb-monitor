package net.ttddyy.monitorx.core.test;

import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
public class SampleEventListener implements ApplicationListener<SampleEvent> {
    public void onApplicationEvent(SampleEvent event) {
        System.out.println("SampleEventListener : " + event);
    }
}
