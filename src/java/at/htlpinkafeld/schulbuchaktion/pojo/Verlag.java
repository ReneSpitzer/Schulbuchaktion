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
 * @author marko
 */
public class Verlag implements Identifiable{
    private int id_Verlag;
    private String verlag_Name;
    private String anschrift;
    
    private static List idxNames;

    public Verlag(int id_Verlag, String verlag_Name, String anschrift) {
        this.id_Verlag = id_Verlag;
        this.verlag_Name = verlag_Name;
        this.anschrift = anschrift;
        
        if(idxNames==null){
            
            idxNames=new ArrayList();
            idxNames.add("ID_VERLAG");
        }
    }

    public Verlag(int id_verlag, String verlag_Name) {
        this(id_verlag,verlag_Name,"");
    }

    public int getId_Verlag() {
        return id_Verlag;
    }

    public void setId_Verlag(int id_Verlag) {
        this.id_Verlag = id_Verlag;
    }

    public String getVerlag_Name() {
        return verlag_Name;
    }

    public void setVerlag_Name(String verlag_Name) {
        this.verlag_Name = verlag_Name;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id_Verlag;
        hash = 79 * hash + Objects.hashCode(this.verlag_Name);
        hash = 79 * hash + Objects.hashCode(this.anschrift);
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
        final Verlag other = (Verlag) obj;
        if (this.id_Verlag != other.id_Verlag) {
            return false;
        }
        if (!Objects.equals(this.verlag_Name, other.verlag_Name)) {
            return false;
        }
        if (!Objects.equals(this.anschrift, other.anschrift)) {
            return false;
        }
        return true;
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(id_Verlag);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        id_Verlag=d;
    }

    @Override
    public String getIndexQry() {
        return idxNames.get(0)+"="+id_Verlag;
    }
    
    
}
