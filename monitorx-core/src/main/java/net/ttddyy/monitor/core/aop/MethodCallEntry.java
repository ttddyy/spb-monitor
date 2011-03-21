package net.ttddyy.monitor.core.aop;

import java.io.Serializable;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallEntry implements Serializable {

    private MethodCallType callType;
    private String className;
    private String methodName;

    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
