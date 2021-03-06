package net.ttddyy.monitor.core.aop;

import org.springframework.context.ApplicationListener;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextPersistEventListener implements ApplicationListener<MethodCallContextPersistEvent> {

    private MethodCallContextRepository repository;

    public void onApplicationEvent(MethodCallContextPersistEvent event) {
        final MethodCallContext context = event.getContext();

        if (context.hasEntry()) {
            repository.persist(context);  // delegate to repository
        }
    }

    public void setRepository(MethodCallContextRepository repository) {
        this.repository = repository;
    }
}
