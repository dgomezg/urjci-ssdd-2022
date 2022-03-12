package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public String greeting(Model model) {
        LOGGER.debug("Invoking Greeting controller");
        model.addAttribute("name", "David");
        return "greeting_template";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "David");
        model.addAttribute("hello", true);

        return "basic_template";
    }

    @GetMapping("/bye")
    public String farewell(Model model) {
        model.addAttribute("name", "David");
        model.addAttribute("hello", false);

        return "basic_template";
    }

}
