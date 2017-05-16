/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.User;
import at.htlpinkafeld.schulbuchaktion.service.Schulbuchmanagerservice;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class UserBean {
    
     @ManagedProperty(value="#{schulbuchmanagerservice}")
     Schulbuchmanagerservice schulbuchmanagerservice;
      
    private User user = new User();
 
    
    public UserBean(){
     
    }
    
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schulbuchmanagerservice getSchulbuchmanagerservice() {
        return schulbuchmanagerservice;
    }

    public void setSchulbuchmanagerservice(Schulbuchmanagerservice schulbuchmanagerservice) {
        this.schulbuchmanagerservice = schulbuchmanagerservice;
    }

    

   
   public String login(){
      for(User u:this.schulbuchmanagerservice.getUlist()){
          if(u.getUsername().equals(user.getUsername())&&u.getPasswort().equals(user.getPasswort())){
              return "/index.xhtml";
          }
      }
        
            return null;
    }
    
    
}
