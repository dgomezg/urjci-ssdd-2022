package es.urjc.ssdd.dgomezg.springboot.samplemvc.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component @SessionScope
public class UserSessionScoped {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
