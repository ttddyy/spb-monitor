package net.ttddyy.monitor.core.aop;

import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallServletRequestListener implements ApplicationListener<ServletRequestHandledEvent> {

    private MethodCallManager methodCallManager;

    public void onApplicationEvent(ServletRequestHandledEvent event) {
        // called end of http request

        // TODO: may add some metrics

        methodCallManager.finalizeContext();
    }

    public void setMethodCallManager(MethodCallManager methodCallManager) {
        this.methodCallManager = methodCallManager;
    }
}
