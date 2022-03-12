package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    public static final String USER_INFO = "userInfo";
    private String sharedInfo;

    @PostMapping("set-session-info")
    public String setInfo(HttpSession session, @RequestParam String info) {
        session.setAttribute(USER_INFO, info);
        sharedInfo = info;

        return "session-info-saved";
    }

    @GetMapping("show-session-info")
    public String seeInfo(Model model, HttpSession session){
        model.addAttribute("sharedInfo", sharedInfo);
        model.addAttribute("userInfo", session.getAttribute(USER_INFO));

        return "session-show-info";
    }
}
