package net.ttddyy.monitor.core.metric;

import java.util.Map;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MetricManager {

    void addMetric(Metric metric);

    Map<String, String> getAllMetrics();

}
