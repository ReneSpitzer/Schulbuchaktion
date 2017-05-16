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
public class Bestelliste implements Identifiable{
    private Jahr jahr;
    private int id_bestellisten;
    private int anz;
    private Klasse klasse;
    private JahresBuecher jahresBuch;
    
    private static List idxNames;

    public Bestelliste(Jahr jahr, int id_bestellisten, int anz, Klasse klasse, JahresBuecher jahresBuch) {
        this.jahr = jahr;
        this.id_bestellisten = id_bestellisten;
        this.anz = anz;
        this.klasse = klasse;
        this.jahresBuch = jahresBuch;
        
        if(idxNames==null)
        {
            idxNames=new ArrayList();
            idxNames.add("JAHR_JAHR");
            idxNames.add("ID_BESTELLISTE");
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

    public int getId_bestellisten() {
        return id_bestellisten;
    }

    public void setId_bestellisten(int id_bestellisten) {
        this.id_bestellisten = id_bestellisten;
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

    public JahresBuecher getJahresBuch() {
        return jahresBuch;
    }

    public void setJahresBuch(JahresBuecher jahresBuch) {
        this.jahresBuch = jahresBuch;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.jahr);
        hash = 53 * hash + this.id_bestellisten;
        hash = 53 * hash + this.anz;
        hash = 53 * hash + Objects.hashCode(this.klasse);
        hash = 53 * hash + Objects.hashCode(this.jahresBuch);
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
        final Bestelliste other = (Bestelliste) obj;
        if (this.id_bestellisten != other.id_bestellisten) {
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
        if (!Objects.equals(this.jahresBuch, other.jahresBuch)) {
            return false;
        }
        return true;
    }

    @Override
    public List getId() {
        List retVal= new ArrayList();
        
        retVal.add(jahr);
        retVal.add(this.id_bestellisten);
        retVal.add(this.klasse);
        retVal.add(this.jahresBuch);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIndexQry() {
        String retVal="";
        
        retVal+=idxNames.get(0)+"="+jahr.getId().get(0)+" and "+
                idxNames.get(1)+"="+this.id_bestellisten+" and "+
                idxNames.get(2)+"="+klasse.getJahrIdx().getJahr()+" and "+
                idxNames.get(3)+"="+klasse.getJahrgang()+" and "+
                idxNames.get(4)+"="+"\""+klasse.getKlassen_Bez()+"\""+" and "+
                idxNames.get(5)+"="+jahresBuch.getBuch().getId_buch()+" and "+
                idxNames.get(6)+"="+jahresBuch.getJahr().getJahr()+" ";
        
        return retVal;
    }

    
}
