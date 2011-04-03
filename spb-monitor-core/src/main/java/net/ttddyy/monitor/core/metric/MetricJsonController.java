package net.ttddyy.monitor.core.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Map;

/**
 * @author Tadaya Tsuyukubo
 */
@Controller
public class MetricJsonController {

    private MetricManager manager;

    @RequestMapping(value = "/metrics/json/all")
    public ModelAndView getAll() {

        final Map<String, String> displayValues = manager.getAllMetrics();

        final ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
        mav.addObject("contexts", displayValues);
        return mav;
    }

    @Autowired
    public void setManager(MetricManager manager) {
        this.manager = manager;
    }
}
