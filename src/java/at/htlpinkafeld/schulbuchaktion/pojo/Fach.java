/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Fach {
    private int id_Fach;
    private String fachbez;
    
    private Indizes idx;
   

    public Fach(int id_Fach, String fachbez) {
        this.id_Fach = id_Fach;
        this.fachbez = fachbez;
        
        idx= new Indizes();
        idx.addIndex("ID_FACH", id_Fach);
    }

    public int getId_Fach() {
        return id_Fach;
    }

    public void setId_Fach(int id_Fach) {
        this.id_Fach = id_Fach;
    }

    public String getFachbez() {
        return fachbez;
    }

    public void setFachbez(String fachbez) {
        this.fachbez = fachbez;
    }
    
    public Indizes getIndizes(){
        return idx;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_Fach;
        hash = 23 * hash + Objects.hashCode(this.fachbez);
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
        final Fach other = (Fach) obj;
        if (this.id_Fach != other.id_Fach) {
            return false;
        }
        if (!Objects.equals(this.fachbez, other.fachbez)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Faecher{" + "id_Fach=" + id_Fach + ", fachbez=" + fachbez + ", fachverantwortlicher=" + '}';
    }
    
    
}
