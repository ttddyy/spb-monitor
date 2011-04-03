package net.ttddyy.monitor.core.metric;

import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MetricGroup extends Metric {

    List<Metric> getMetrics();

}
