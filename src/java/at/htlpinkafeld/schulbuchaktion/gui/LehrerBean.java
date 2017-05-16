/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.User;
import at.htlpinkafeld.schulbuchaktion.pojo.Zuteilung;
import at.htlpinkafeld.schulbuchaktion.service.Schulbuchmanagerservice;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.catalina.tribes.tipis.AbstractReplicatedMap.MapEntry;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class LehrerBean {
    
       @ManagedProperty(value="#{schulbuchmanagerservice}")
        Schulbuchmanagerservice schulbuchmanagerservice;
       private User user;
      //Map mit User und Fach 
      
     public LehrerBean(){
       user= new User();
      
     }  

    public User getUser() {
        return user;
    }

/*
    public Zuteilung getZut() {
    return zut;
    }
    public void setZut(Zuteilung zut) {
    this.zut = zut;
    }
    public User getUser() {
    return zut.getUser();
    }
    public void setUser(User user) {
    zut.setUser(user);
    }
    public Fach getFach() {
    return zut.getFach();
    }
    public void setFach(Fach fach) {
    zut.setFach(fach);
    }
     */
    public void setUser(User user) {
        this.user = user;
    }

    public Object add() {
        this.schulbuchmanagerservice.getUlist().remove(user);
         this.schulbuchmanagerservice.getUlist().add(user);
        user= new User();
        return "/zuteilungsliste.xhtml";
    }
    public Object delete(){
           this.schulbuchmanagerservice.getUlist().remove(user);
        
        
        return "/zuteilungsliste.xhtml";
    }
       
      
    public Schulbuchmanagerservice getSchulbuchmanagerservice() {
        return schulbuchmanagerservice;
    }

    public void setSchulbuchmanagerservice(Schulbuchmanagerservice schulbuchmanagerservice) {
        this.schulbuchmanagerservice = schulbuchmanagerservice;
    }
       
       
       
}
