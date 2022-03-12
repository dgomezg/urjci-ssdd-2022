package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public String greeting(Model model) {
        LOGGER.debug("Invoking Greeting controller");
        model.addAttribute("name", "David");
        return "greeting_template";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<String> strings = Arrays.asList("Karem", "John", "Katty", "Fred");
        model.addAttribute("names", strings);

        return "names";
    }

    @PostMapping("/greeting_user")
    public String greetingUser(Model model,
                               @RequestParam String nombre,
                               @RequestParam String apellido) {
        model.addAttribute("fullName", nombre + " " + apellido);
        model.addAttribute("name", nombre);
        model.addAttribute("lastname", apellido);

        return "greeting_user_template";
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
