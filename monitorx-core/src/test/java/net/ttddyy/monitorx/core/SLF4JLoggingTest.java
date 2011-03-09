package net.ttddyy.monitorx.core;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author Tadaya Tsuyukubo
 */
@ContextConfiguration
public class SLF4JLoggingTest extends AbstractTestNGSpringContextTests {

    @Resource
    private Sample sample;

    @Test
    public void test() {
        System.out.println("============");
        String foo = sample.foo();
        System.out.println(foo);
    }

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SampleImpl());
//        factory.addInterface(Sample.class);
        factory.addAdvice(new MethodCallAdvice());
        Sample proxy = (Sample)factory.getProxy();

        Advised advised = (Advised)proxy;
        Advisor[] advisors = advised.getAdvisors();
        System.out.println(advisors.length);

        String result = proxy.foo();
        System.out.println(result);
    }
}
