package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import es.urjc.ssdd.dgomezg.springboot.samplemvc.model.UserSessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserSessionScoped user;

    @PostMapping("set-session-info")
    public String setInfo(HttpSession session,
                          @RequestParam String info,
                          @RequestParam String userName) {
        session.setAttribute(USER_INFO, info);
        sharedInfo = info;
        user.setUserName(userName);

        return "session-info-saved";
    }

    @GetMapping("show-session-info")
    public String seeInfo(Model model, HttpSession session){
        model.addAttribute("sharedInfo", sharedInfo);
        model.addAttribute("userInfo", session.getAttribute(USER_INFO));
        model.addAttribute("userName", user.getUserName());

        return "session-show-info";
    }
}
