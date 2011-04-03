package net.ttddyy.monitor.core.metric;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Tadaya Tsuyukubo
 */
public class MetricRegistrationBeanPostProcessor implements BeanPostProcessor {
    private MetricManager metricManager;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Metric) {
            metricManager.addMetric((Metric) bean);
        }
        return bean;
    }

    @Required
    public void setMetricManager(MetricManager metricManager) {
        this.metricManager = metricManager;
    }
}
