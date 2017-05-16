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
public class JahresBuecher implements Identifiable{
    private Buch buch;
    private Jahr jahr;
    
    private static List idxNames;

    public JahresBuecher(Buch buch, Jahr jahr) {
        this.buch = buch;
        this.jahr = jahr;
        
        if(idxNames==null)
        {
            idxNames=new ArrayList();
            idxNames.add("BUECHER_ID_BUCH");
            idxNames.add("JAHR_JAHR");
        }
    }

    public Buch getBuch() {
        return buch;
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public Jahr getJahr() {
        return jahr;
    }

    public void setJahr(Jahr jahr) {
        this.jahr = jahr;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.buch);
        hash = 29 * hash + Objects.hashCode(this.jahr);
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
        final JahresBuecher other = (JahresBuecher) obj;
        if (!Objects.equals(this.buch, other.buch)) {
            return false;
        }
        if (!Objects.equals(this.jahr, other.jahr)) {
            return false;
        }
        return true;
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(jahr);
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
        
        retVal+=idxNames.get(0)+"="+this.buch.getId_buch()+" and "+idxNames.get(1)+"="+this.jahr.getJahr();
        
        return retVal;
    }
    
}
