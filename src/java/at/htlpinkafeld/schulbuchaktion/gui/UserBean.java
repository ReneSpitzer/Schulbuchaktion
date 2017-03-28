/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rene-_000
 */
public class UserBean {
    private User user;
    private String pwd;
   private List <User> userlist = new ArrayList();
    
    public UserBean(){
       userlist.add(new User("bez",1,"name","HHH"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
   public String login(){
      for(User u:userlist){
          if(u.getId_User()==user.getId_User()&&u.getPasswort().equals(user.getPasswort())){
              return "/index.xhtml";
          }
      }
        
            return null;
    }
    
    
}
