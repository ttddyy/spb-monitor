package net.ttddyy.monitor.core;

import java.io.Serializable;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallEntry implements Serializable {

    private MethodCallType callType;
    private String methodName;

    private String note;

    public MethodCallType getCallType() {
        return callType;
    }

    public void setCallType(MethodCallType callType) {
        this.callType = callType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
