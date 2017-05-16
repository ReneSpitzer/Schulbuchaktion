/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Klasse;
import at.htlpinkafeld.schulbuchaktion.service.Schulbuchmanagerservice;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/*
 *
 * @author rene-_000
 */

@ManagedBean
@SessionScoped
public class KlassenBean {
    @ManagedProperty(value="#{schulbuchmanagerservice}")
     Schulbuchmanagerservice schulbuchmanagerservice;
    private Klasse klasse;
   
    private boolean but= true;

    public KlassenBean(){
        this.klasse= new Klasse();
    }
    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public List<Klasse> getKlist() {
        return schulbuchmanagerservice.getKlist();
    }

    public boolean isBut() {
        return but;
    }

    public void setBut(boolean but) {
        this.but = but;
    }
    
    public void setKlist(List<Klasse> klist) {
        this.schulbuchmanagerservice.setKlist(klist);
    }
       public Object add(){
           this.but=true;
        this.schulbuchmanagerservice.getKlist().add(new Klasse(klasse));
        this.klasse=new Klasse();
        return "klassen.xhtml";
    }
    public Object delete(Klasse b){
        this.schulbuchmanagerservice.getKlist().remove(b);
        return "klassen.xhtml";
    }
    public Object save(){
         List<Klasse> kl=schulbuchmanagerservice.getKlist();
         kl.remove(klasse);
        kl.add(new Klasse(klasse));
        this.klasse=new Klasse();
        return "klassen.xhtml";
    }

    public Schulbuchmanagerservice getSchulbuchmanagerservice() {
        return schulbuchmanagerservice;
    }

    public void setSchulbuchmanagerservice(Schulbuchmanagerservice schulbuchmanagerservice) {
        this.schulbuchmanagerservice = schulbuchmanagerservice;
    }

  
        public Object edit(Klasse p)
    {
       this.but=false;
        this.klasse=p;
        return "klassenconfig.xhtml";
    }  
         public boolean opposit(){
       if(this.but==true){
        return false;
       }
       else
           return true;
       
   }
}
