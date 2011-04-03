package net.ttddyy.monitor.core.aop.controller;

import net.ttddyy.monitor.core.aop.MethodCallContext;
import net.ttddyy.monitor.core.aop.MethodCallContextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
@Controller
public class MethodCallJsonController {

    private MethodCallContextRepository repository;


    @RequestMapping(value = "/json/all")
    public ModelAndView getAll() {

        final List<MethodCallContext> contexts = repository.getAll();

        final ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
        mav.addObject("contexts", contexts);
        return mav;
    }

    @Autowired
    public void setRepository(MethodCallContextRepository repository) {
        this.repository = repository;
    }
}
