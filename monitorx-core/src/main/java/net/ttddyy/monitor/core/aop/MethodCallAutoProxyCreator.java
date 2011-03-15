package net.ttddyy.monitor.core.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
public class MethodCallAutoProxyCreator extends AbstractAdvisorAutoProxyCreator {

    @Override
    protected List<Advisor> findCandidateAdvisors() {
        DefaultPointcutAdvisor advisor  = new DefaultPointcutAdvisor();
        advisor.setAdvice(new MethodCallAdvice());

        List<Advisor> advisors = new ArrayList<Advisor>();
        advisors.add(advisor);
        return advisors;
    }
}
