/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Nachbestelliste implements Identifiable{
    private Jahr jahr;
    private int nachbestell_id;
    private int anz;
    private Klasse klasse;
    private JahresBuecher buch;
    
    private static List idxNames;

    public Nachbestelliste(Jahr jahr, int nachbestell_id, int anz, Klasse klasse,JahresBuecher buch) {
        this.jahr = jahr;
        this.nachbestell_id = nachbestell_id;
        this.anz = anz;
        this.klasse=klasse;
        this.buch = buch;
        
        if(idxNames==null)
        {
            idxNames=new ArrayList();
            idxNames.add("JAHR_JAHR");
            idxNames.add("ID_NACHBESTELLLISTE");
            idxNames.add("KLASSEN_JAHR");
            idxNames.add("KLASSEN_JAHRGANG");
            idxNames.add("KLASSEN_BEZEICHNUNG");
            idxNames.add("JAHRESBUCH_BUCHID");
            idxNames.add("JAHRESBUCH_JAHR");
        }
    }

    public Jahr getJahr() {
        return jahr;
    }

    public void setJahr(Jahr jahr) {
        this.jahr = jahr;
    }

    public int getNachbestell_id() {
        return nachbestell_id;
    }

    public void setNachbestell_id(int nachbestell_id) {
        this.nachbestell_id = nachbestell_id;
    }

    public int getAnz() {
        return anz;
    }

    public void setAnz(int anz) {
        this.anz = anz;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public JahresBuecher getBuch() {
        return buch;
    }

    public void setBuch(JahresBuecher buch) {
        this.buch = buch;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.jahr);
        hash = 29 * hash + this.nachbestell_id;
        hash = 29 * hash + this.anz;
        hash = 29 * hash + Objects.hashCode(this.klasse);
        hash = 29 * hash + Objects.hashCode(this.buch);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nachbestelliste other = (Nachbestelliste) obj;
        if (this.nachbestell_id != other.nachbestell_id) {
            return false;
        }
        if (this.anz != other.anz) {
            return false;
        }
        if (!Objects.equals(this.jahr, other.jahr)) {
            return false;
        }
        if (!Objects.equals(this.klasse, other.klasse)) {
            return false;
        }
        if (!Objects.equals(this.buch, other.buch)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nachbestelliste{" + "jahr=" + jahr + ", nachbestell_id=" + nachbestell_id + ", anz=" + anz + ", klasse=" + klasse + ", buch=" + buch + '}';
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(jahr);
        retVal.add(nachbestell_id);
        retVal.add(klasse);
        retVal.add(buch);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        System.out.println("NO GENERIC KEYS");
    }

    @Override
    public String getIndexQry() {
             String retVal="";
        
        retVal+=idxNames.get(0)+"="+jahr.getJahr()+" and "+
                idxNames.get(1)+"="+this.nachbestell_id+" and "+
                idxNames.get(2)+"="+klasse.getJahrIdx().getJahr()+" and "+
                idxNames.get(3)+"="+klasse.getJahrgang()+" and "+
                idxNames.get(4)+"="+"\""+klasse.getKlassen_Bez()+"\""+" and "+
                idxNames.get(5)+"="+buch.getBuch().getId_buch()+" and "+
                idxNames.get(6)+"="+buch.getJahr().getJahr()+" ";
        
        return retVal;
    }
 
    
}
