package net.ttddyy.monitor.core.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
public class InMemoryMethodCallContextRepository implements MethodCallContextRepository {

    private List<MethodCallContext> list = new ArrayList<MethodCallContext>();

    private int maxSize = -1;

    public void persist(MethodCallContext context) {
        resize();
        list.add(context);
    }

    public List<MethodCallContext> getAll() {
        // TODO: should it be Collections.unmodifiableList() ??
        return new ArrayList<MethodCallContext>(list);
    }

    private void resize() {
        if (maxSize < 0) {
            return;
        }

        while (list.size() > maxSize) {
            list.remove(0);
        }

    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
