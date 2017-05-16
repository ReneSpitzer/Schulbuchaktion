/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
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
public class FachBean {
    @ManagedProperty(value="#{schulbuchmanagerservice}")
     Schulbuchmanagerservice schulbuchmanagerservice;
        
        private Fach fach;
        
   public FachBean(){
   }     
     public List<Fach> getFlist() {
        return schulbuchmanagerservice.getFlist();
    }
       public void setFlist(List<Fach> flist) {
        this.schulbuchmanagerservice.setFlist(flist);
    }

    public Schulbuchmanagerservice getSchulbuchmanagerservice() {
        return schulbuchmanagerservice;
    }

    public void setSchulbuchmanagerservice(Schulbuchmanagerservice schulbuchmanagerservice) {
        this.schulbuchmanagerservice = schulbuchmanagerservice;
    }
       


    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }
      
}
