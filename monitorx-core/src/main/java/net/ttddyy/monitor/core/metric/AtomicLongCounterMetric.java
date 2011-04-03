package net.ttddyy.monitor.core.metric;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Tadaya Tsuyukubo
 */
public class AtomicLongCounterMetric implements ValueMetric<Long, Long> {

    private MetricManager manager;

    private String name;
    private AtomicLong atomicLong = new AtomicLong();
    private long lastAccess;

    public void increment() {
        atomicLong.incrementAndGet();
        lastAccess = System.currentTimeMillis();
    }

    public void increment(long toInc) {
        atomicLong.addAndGet(toInc);
        lastAccess = System.currentTimeMillis();
    }

    public void decrement() {
        atomicLong.decrementAndGet();
        lastAccess = System.currentTimeMillis();
    }

    public void decrement(long toDec) {
        atomicLong.addAndGet(-toDec);
        lastAccess = System.currentTimeMillis();
    }

    public void setValue(Long value) {
        atomicLong.set(value);
    }

    public Long getValue() {
        return atomicLong.get();
    }

    public Map<String, String> getDisplayValues() {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("value", atomicLong.toString());
        map.put("last_access_mills", Long.toString(lastAccess));
        map.put("last_access", new Date(lastAccess).toString());
        return map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
