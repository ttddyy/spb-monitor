package net.ttddyy.monitor.core.metric;

import java.util.Map;

/**
 * @author Tadaya Tsuyukubo
 */
public interface Metric {

    String getName();

    Map<String, String> getDisplayValues();
}
