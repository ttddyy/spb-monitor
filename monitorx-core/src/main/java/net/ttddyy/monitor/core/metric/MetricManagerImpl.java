package net.ttddyy.monitor.core.metric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tadaya Tsuyukubo
 */
public class MetricManagerImpl implements MetricManager {

    private static final String METRIC_DELIMITER = ".";

    // full path : metric
    private Map<String, Metric> metricMap = new HashMap<String, Metric>();

    public void addMetric(Metric metric) {
        metricMap.putAll(getMetricMap(metric));
    }

    private Map<String, Metric> getMetricMap(Metric metric) {
        final Map<String, Metric> result = new HashMap<String, Metric>();
        if (metric instanceof MetricGroup) {
            final MetricGroup metricGroup = (MetricGroup) metric;
            final String groupName = metricGroup.getName();

            final List<Metric> groupMetrics = metricGroup.getMetrics();
            for (Metric groupMetric : groupMetrics) {
                Map<String, Metric> childMetricsMap = getMetricMap(groupMetric);

                for (Map.Entry<String, Metric> entry : childMetricsMap.entrySet()) {
                    final String childMetricKey = entry.getKey();
                    final Metric childMetric = entry.getValue();

                    final String newKey = groupName + METRIC_DELIMITER + childMetricKey;
                    result.put(newKey, childMetric);
                }
            }

        } else {
            final String metricName = metric.getName();
            result.put(metricName, metric);
        }

        return result;
    }


    public Map<String, String> getAllMetrics() {
        final Map<String, String> result = new HashMap<String, String>();

        for (Map.Entry<String, Metric> entry : metricMap.entrySet()) {
            final String key = entry.getKey();
            final Metric metric = entry.getValue();

            final Map<String, String> displayValues = metric.getDisplayValues();
            for (Map.Entry<String, String> valueEntry : displayValues.entrySet()) {
                final String valueKey = valueEntry.getKey();
                final String value = valueEntry.getValue();

                final String fullKey = key + METRIC_DELIMITER + valueKey;
                result.put(fullKey, value);
            }
        }

        return result;
    }
}
