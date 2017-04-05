/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
    private List<Buch> blist= new ArrayList();
    private Buch buch;
    
    public BuchBean(){
       buch=new Buch();
    }

    public List<Buch> getBlist() {
        return blist;
    }

    public void setBlist(List<Buch> blist) {
        this.blist = blist;
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }
    
    public void add(){
        this.blist.add(buch);
        buch=new Buch();
    }
    /*
    public Object save(Buch b){
        
    }
    */
    
     public void assign(ValueChangeEvent ev)
    {
        Boolean assign = (Boolean)ev.getNewValue();
        
        if(assign != null)
        {
            this.buch.setLehrerexample(assign);
        }
        
        FacesContext.getCurrentInstance().renderResponse();
    }
}
