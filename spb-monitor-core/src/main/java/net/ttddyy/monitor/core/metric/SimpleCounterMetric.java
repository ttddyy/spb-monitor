package net.ttddyy.monitor.core.metric;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Tadaya Tsuyukubo
 */
public class SimpleCounterMetric implements ValueMetric<Long, Long> {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private long counter;
    private long lastAccess;

    private String name;


    public void increment() {
        lock.writeLock().lock();
        try {
            counter++;
            lastAccess = System.currentTimeMillis();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void increment(long delta) {
        lock.writeLock().lock();
        try {
            counter += delta;
            lastAccess = System.currentTimeMillis();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void decrement() {
        lock.writeLock().lock();
        try {
            counter--;
            lastAccess = System.currentTimeMillis();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void decrement(long delta) {
        lock.writeLock().lock();
        try {
            counter -= delta;
            lastAccess = System.currentTimeMillis();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setValue(Long value) {
        lock.writeLock().lock();
        try {
            counter = value;
            lastAccess = System.currentTimeMillis();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Long getValue() {
        lock.readLock().lock();
        try {
            return counter;
        } finally {
            lock.readLock().unlock();
        }
    }

    public Map<String, String> getDisplayValues() {
        final Map<String, String> map = new HashMap<String, String>();
        map.put("value", getValue().toString());
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
