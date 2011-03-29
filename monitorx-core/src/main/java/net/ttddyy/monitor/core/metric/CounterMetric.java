package net.ttddyy.monitor.core.metric;

/**
 * @author Tadaya Tsuyukubo
 */
public class CounterMetric {

    private long counter;

    public long set(long value) {
        synchronized (this) {
            counter = value;
        }
        return counter;
    }

    public long increment() {
        synchronized (this) {
            counter++;
        }
        return counter;
    }

    public long increment(long toInc) {
        synchronized (this) {
            counter += toInc;
        }
        return counter;
    }
}
