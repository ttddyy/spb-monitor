package net.ttddyy.monitor.core.aop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */

// TODO: should this to be Serializable
public class MethodCallContext implements Serializable {

    private List<MethodCallEntry> entries = new ArrayList<MethodCallEntry>();

    public boolean addEvent(MethodCallEntry entry) {
        return entries.add(entry);
    }
}
