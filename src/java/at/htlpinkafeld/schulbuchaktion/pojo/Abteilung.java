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
public class Abteilung implements Identifiable{
    private int id_abteilung;
    private String abt_name;

    private static List idxNames;
    
    public Abteilung(int id_abteilung, String abt_name) {
        this.id_abteilung = id_abteilung;
        this.abt_name = abt_name;
        
        if(idxNames==null)
        {
            idxNames=new ArrayList();
            idxNames.add("ID_ABTEILUNG");
        }
    }
    public Abteilung(){
        
    }
    public Abteilung(Abteilung abt){
        this.abt_name=abt.abt_name;
        this.id_abteilung=abt.id_abteilung;
    }

    public int getId_abteilung() {
        return id_abteilung;
    }

    public void setId_abteilung(int id_abteilung) {
        this.id_abteilung = id_abteilung;
    }

    public String getAbt_name() {
        return abt_name;
    }

    public void setAbt_name(String abt_name) {
        this.abt_name = abt_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_abteilung;
        hash = 97 * hash + Objects.hashCode(this.abt_name);
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
        final Abteilung other = (Abteilung) obj;
        if (this.id_abteilung != other.id_abteilung) {
            return false;
        }
        if (!Objects.equals(this.abt_name, other.abt_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   id_abteilung + " " + abt_name;
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(id_abteilung);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        id_abteilung=d;
    }

    @Override
    public String getIndexQry() {
        String retVal="";
        
        retVal+=idxNames.get(0)+"="+id_abteilung;
        
        return retVal;
    }
    
    
}
