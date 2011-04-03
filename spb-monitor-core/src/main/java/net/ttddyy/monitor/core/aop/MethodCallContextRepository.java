package net.ttddyy.monitor.core.aop;

import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
public interface MethodCallContextRepository {

    void persist(MethodCallContext context);

    List<MethodCallContext> getAll();

}
