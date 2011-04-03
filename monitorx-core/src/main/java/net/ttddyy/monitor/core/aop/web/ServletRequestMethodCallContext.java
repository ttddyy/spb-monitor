package net.ttddyy.monitor.core.aop.web;

import net.ttddyy.monitor.core.aop.MethodCallContext;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tadaya Tsuyukubo
 */
public class ServletRequestMethodCallContext extends MethodCallContext {

    private String method;
    private RequestMethod requestMethod;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
        this.requestMethod = RequestMethod.valueOf(method);
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
        this.method = requestMethod.name();
    }
}
