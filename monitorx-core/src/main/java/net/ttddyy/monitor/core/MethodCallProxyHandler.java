package net.ttddyy.monitor.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallProxyHandler implements InvocationHandler {

    private MethodCallManager manager;

    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        // dispatcher servlet' ServletRequestHandledEvent

        final long startTime = System.currentTimeMillis();

        // TODO: context marker

//        TODO: notify - before, after, error
//        manager.notifyBeforeMethod(method);

        // TODO: check exception handling, exception types
        final Object retVal;
        try {
            retVal = method.invoke(target, args);
        } catch (InvocationTargetException ex) {
            final long processTime = startTime - System.currentTimeMillis();

            throw ex.getTargetException();
        }
        final long processTime = startTime - System.currentTimeMillis();
        return retVal;
    }
}
