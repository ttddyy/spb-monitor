package net.ttddyy.monitor.core.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallContextRepositoryListImpl implements MethodCallContextRepository {

    private List<MethodCallContext> list = new ArrayList<MethodCallContext>();


    public void persist(MethodCallContext context) {
        list.add(context);
    }
}
