package net.ttddyy.monitor.core.aop;

import java.io.Serializable;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallEntry implements Serializable {

    private Serializable pairId;
    private MethodCallType callType;
    private String className;
    private String methodName;
    private long proceeTime;
    private long timestamp;

    private String note;

    public Serializable getPariId() {
        return pairId;
    }

    public void setPairId(Serializable pairId) {
        this.pairId = pairId;
    }

    public MethodCallType getCallType() {
        return callType;
    }

    public void setCallType(MethodCallType callType) {
        this.callType = callType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getProceeTime() {
        return proceeTime;
    }

    public void setProceeTime(long proceeTime) {
        this.proceeTime = proceeTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
