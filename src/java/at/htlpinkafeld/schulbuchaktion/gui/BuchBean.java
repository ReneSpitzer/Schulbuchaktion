/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.service.Schulbuchmanagerservice;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class BuchBean {

     @ManagedProperty(value="#{schulbuchmanagerservice}")
    Schulbuchmanagerservice schulbuchmanagerservice;
    private Buch buch;
    boolean but=true;
    
    public BuchBean(){
       buch=new Buch();
     
    }

    public List<Buch> getBlist() {
        return schulbuchmanagerservice.getBlist();
    }

    public void setBlist(List<Buch> blist) {
        this.schulbuchmanagerservice.setBlist(blist);
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public boolean isBut() {
        return but;
    }

    public void setBut(boolean but) {
        this.but = but;
    }
    
    public Object add(){
        this.but=true;
        this.schulbuchmanagerservice.add(buch);
        this.buch=new Buch();
        return "buecher.xhtml";
    }
    public Object delete(Buch b){
         this.schulbuchmanagerservice.getBlist().remove(b);
        return null;
    }
    public Object save(){
         List<Buch> bl=schulbuchmanagerservice.getBlist();
        this.but=true;
         bl.remove(buch);
        bl.add(new Buch(buch));
        this.buch=new Buch();
        return "buecher.xhtml";
    }
    public Object edit(Buch p)
    {
        this.but=false;
        this.buch=p;
        return "buecherconfig.xhtml";
    }    

   public boolean opposit(){
       if(this.but==true){
        return false;
       }
       else
           return true;
       
   }

    public Schulbuchmanagerservice getSchulbuchmanagerservice() {
        return schulbuchmanagerservice;
    }

    public void setSchulbuchmanagerservice(Schulbuchmanagerservice schulbuchmanagerservice) {
        this.schulbuchmanagerservice = schulbuchmanagerservice;
    }
   

}
