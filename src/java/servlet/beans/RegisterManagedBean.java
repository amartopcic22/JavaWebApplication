/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.beans;

import business.beans.RegisterSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registerManagedBean", eager = true)
@SessionScoped
public class RegisterManagedBean implements Serializable{

    @EJB
    private RegisterSessionBeanLocal registerSessionBeanLocal;
    
    private String message="";
    private String username;
    private String password;
    private String name;
    private String surname;
    
    
    public RegisterManagedBean() {
    }
    
    public String register(){
    
        boolean userCreated = registerSessionBeanLocal.register(username, password, name, surname);
        if(userCreated){
            return "index";
        }
        message = "Unijeto korisničko ime je zauzeto";
        return "registration";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
  
    
}
