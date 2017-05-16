package at.htlpinkafeld.schulbuchaktion.service;

import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.Klasse;
import at.htlpinkafeld.schulbuchaktion.pojo.User;
import at.htlpinkafeld.schulbuchaktion.pojo.Zuteilung;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rene-_000
 */
@ManagedBean
@SessionScoped
public class Schulbuchmanagerservice {
         private  List<Klasse> klist = new ArrayList();
        private List<Buch> blist= new ArrayList();
        private List<Fach> flist=new ArrayList();
        private List<Abteilung> alist=new ArrayList();
        private List<User> ulist= new ArrayList();
        
     public Schulbuchmanagerservice(){
             ulist.add(new User(1," Hobe ","Hochwarter Bernd","hallo",false,false,true,false,"Hobe@gmail.com"));
               ulist.add(new User(2," Karb ","Karner Brigitte","hali",false,false,false,false,"Karb@gmail.com"));
               ulist.add(new User("bez",1,"name","111"));
             flist.add(new Fach(1,"Mathe"));
         flist.add(new Fach(2,"English"));
         alist.add(new Abteilung(1,"Informatik"));
         alist.add(new Abteilung(2,"Bautechnik"));
         alist.add(new Abteilung(3,"Gebäudetechnik"));
         alist.add(new Abteilung(4,"Elektronik"));
      
     }

    public List<User> getUlist() {
        return ulist;
    }
    public void setUlist(List<User> ulist) {
        this.ulist = ulist;
    }


 
     
    public List<Klasse> getKlist() {
        return klist;
    }

    public void setKlist(List<Klasse> klist) {
        this.klist = klist;
    }
      public List<Abteilung> getAlist() {
        return alist;
    }

    public void setAlist(List<Abteilung> alist) {
        this.alist = alist;
    }

    public List<Buch> getBlist() {
        return blist;
    }

    public void setBlist(List<Buch> blist) {
        this.blist = blist;
    }

    public List<Fach> getFlist() {
        return flist;
    }

    public void setFlist(List<Fach> flist) {
        this.flist = flist;
    }
       public void add(Klasse k)
    {
        klist.add(k);
    }
    
    public void remove(Klasse k)
    {
        klist.remove(k);
    }
 

    
   
    public void add(Buch b)
    {
        blist.add(b);
    }
    
    public void remove(Buch b)
    {
        blist.remove(b);
    }
     public void add(Fach b)
    {
        flist.add(b);
    }
    
    public void remove(Fach b)
    {
        flist.remove(b);
    }
 
     public void remove(User user){
        ulist.remove(user);
    }
      public void remove(Abteilung abt){
        alist.remove(abt);
    }
        
        
}
