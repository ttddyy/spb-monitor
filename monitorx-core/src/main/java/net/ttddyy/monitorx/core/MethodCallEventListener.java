package net.ttddyy.monitorx.core;

import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
@ExcludeMonitoring
public class MethodCallEventListener implements ApplicationListener<MethodCallEvent> {
    public void onApplicationEvent(MethodCallEvent event) {
        MethodCallEntry entry = event.getEntry();
        System.out.println("LISTENER: " + entry.getCallType() + "  : " + entry.getMethodName());
    }
}
