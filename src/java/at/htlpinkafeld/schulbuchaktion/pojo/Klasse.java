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
public class Klasse implements Identifiable{
    private Jahr jahr;
    private int jahrgang;
    private String klassen_bez;
    private int schueler_anz;
    private Abteilung abt;
    private int rep_anz;
    
    private static List idxNames;

    public Klasse(Jahr jahr, int jahrgang, String klassenbez, int schueler_anz, Abteilung abt, int rep_anz) {
        this.jahr=jahr;
        this.jahrgang = jahrgang;
        this.klassen_bez = klassenbez;
        this.schueler_anz = schueler_anz;
        this.abt = abt;
        this.rep_anz = rep_anz;
        
        if(idxNames==null)
        {
            idxNames=new ArrayList();
            idxNames.add("JAHRIDX");
            idxNames.add("JAHRGANG");
            idxNames.add("BEZEICHNUNG");
        }
    }
    
     public Klasse(Klasse k) {
        this.jahr=k.jahr;
        this.jahrgang = k.jahrgang;
        this.klassen_bez = k.klassen_bez;
        this.schueler_anz = k.schueler_anz;
        this.abt = k.abt;
        this.rep_anz = k.rep_anz;
        
        
    }
     public Klasse(){
         
     }

    public Klasse(Jahr jahr, int jahrgang, String bez) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Jahr getJahrIdx() {
        return jahr;
    }

    public void setJahrIdx(Jahr jahrIdx) {
        this.jahr = jahrIdx;
    }
    
    public int getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    public String getKlassen_Bez() {
        return klassen_bez;
    }

    public void setKlassen_Bez(String klassenBez) {
        this.klassen_bez = klassenBez;
    }

    public int getSchueler_anz() {
        return schueler_anz;
    }

    public void setSchueler_anz(int schueler_anz) {
        this.schueler_anz = schueler_anz;
    }

    public Abteilung getAbt() {
        return abt;
    }

    public void setAbt(Abteilung abt) {
        this.abt = abt;
    }

    public int getRep_anz() {
        return rep_anz;
    }

    public void setRep_anz(int rep_anz) {
        this.rep_anz = rep_anz;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.jahrgang;
        hash = 29 * hash + Objects.hashCode(this.klassen_bez);
        hash = 29 * hash + this.schueler_anz;
        hash = 29 * hash + Objects.hashCode(this.abt);
        hash = 29 * hash + this.rep_anz;
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
        final Klasse other = (Klasse) obj;
        if (this.jahrgang != other.jahrgang) {
            return false;
        }
        if (this.schueler_anz != other.schueler_anz) {
            return false;
        }
        if (this.rep_anz != other.rep_anz) {
            return false;
        }
        if (!Objects.equals(this.klassen_bez, other.klassen_bez)) {
            return false;
        }
        if (!Objects.equals(this.abt, other.abt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Klasse{" + "jahrgang=" + jahrgang + ", schueler_bez=" + klassen_bez + ", schueler_anz=" + schueler_anz + ", abt=" + abt + ", rep_anz=" + rep_anz + '}';
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(0,jahr);
        retVal.add(1,jahrgang);
        retVal.add(2,klassen_bez);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        System.out.println("NO GENERIC KEYS");
    }

    @Override
    public String getIndexQry() {
        String retVal="";
        
        retVal+=idxNames.get(0)+"="+jahr.getId().get(0)+" and "+
                idxNames.get(1)+"="+jahrgang+" and "+
                idxNames.get(2)+"="+"\""+klassen_bez+"\"";
        
        return retVal;
    }
    
    
}
