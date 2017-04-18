/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.gui;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class FachverantwortlicherBean {
    
    private List<Buch> buchListeFachv;
    private List<Buch> buchListeKompl;
    private int SBNr;

    /**
     * Creates a new instance of FachverantwortlicherBean
     */
    public FachverantwortlicherBean(){
        buchListeFachv = new ArrayList<>();
        buchListeKompl = new ArrayList<>();
        
    }
    
    public void hinzufuegen(Buch b){
        buchListeFachv.add(b);
    }
    
    public void suchen(){
        Buch b=new Buch();
        
        hinzufuegen(b);
    }

    public int getSBNr() {
        return SBNr;
    }

    public void setSBNr(int SBNr) {
        this.SBNr = SBNr;
    }
    
    public void removeBuch(Buch b){
        buchListeFachv.remove(b);
    }

    public List<Buch> getBuchListeFachv() {
        return buchListeFachv;
    }

    public void setBuchListeFachv(List<Buch> buchListeFachv) {
        this.buchListeFachv = buchListeFachv;
    }

    public List<Buch> getBuchListeKompl() {
        return buchListeKompl;
    }

    public void setBuchListeKompl(List<Buch> buchListeKompl) {
        this.buchListeKompl = buchListeKompl;
    }
    
    
    
    
}
