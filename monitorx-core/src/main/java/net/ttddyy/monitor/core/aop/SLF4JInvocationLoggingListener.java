package net.ttddyy.monitor.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
public class SLF4JInvocationLoggingListener implements ApplicationListener<MethodCallEvent> {

    private Logger logger = LoggerFactory.getLogger(SLF4JInvocationLoggingListener.class);

    public void onApplicationEvent(MethodCallEvent event) {
        final MethodCallEntry entry = event.getEntry();
        final MethodCallType callType = entry.getCallType();

        // TODO: add switch to decide log level

        logger.debug("method=", entry.getMethodName());
    }
}
