package servlet.beans;

import business.entity.User;
import business.beans.UserSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userManagedBean", eager = true)
@SessionScoped

public class UserManagedBean implements Serializable {

    private String username;
    private String password;
    private boolean loggedIn;

    @EJB
    private UserSessionBeanLocal userSessionBeanLocal;

    public UserManagedBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String login() {
        User user = userSessionBeanLocal.findByUsernameAndPassword(username, password);
        //Ovdje ćemo ići na VALIDATORE koje radimo za par slajdova
        loggedIn = user != null;
        if (loggedIn) {
            return "user";
        } else {
            return "index";
        }
    }

    public String logout() {
        return "index";
    }

    public String getMessage() {
        return "Hello from UserManagedBean";
    }
}
