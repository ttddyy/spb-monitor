package net.ttddyy.monitor.core.metric;

/**
 * @author Tadaya Tsuyukubo
 */
public interface ValueMetric<I, O> extends Metric {

    void setValue(I value);

    O getValue();

}
