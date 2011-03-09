package net.ttddyy.monitorx.core;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallServletRequestListener implements ApplicationListener<ServletRequestHandledEvent> {

    private MonitorxManager monitorxManager;

    public void onApplicationEvent(ServletRequestHandledEvent event) {
        // called end of http request

        // TODO: may add some metrics

        monitorxManager.finalizeContext();
    }

    public void setMonitorxManager(MonitorxManager monitorxManager) {
        this.monitorxManager = monitorxManager;
    }
}
