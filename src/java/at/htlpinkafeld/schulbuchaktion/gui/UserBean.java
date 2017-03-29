/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class UserBean {
    private User user = new User();
   private List <User> userlist = new ArrayList();
    
    public UserBean(){
       userlist.add(new User("bez",1,"name","111"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
   public String login(){
      for(User u:userlist){
          if(u.getUsername().equals(user.getUsername())&&u.getPasswort().equals(user.getPasswort())){
              return "/index.xhtml";
          }
      }
        
            return null;
    }
    
    
}
