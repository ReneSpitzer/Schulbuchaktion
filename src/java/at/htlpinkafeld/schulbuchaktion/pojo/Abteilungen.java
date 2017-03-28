/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Abteilungen {
    private int id_abteilung;
    private String abt_name;

    public Abteilungen(int id_abteilung, String abt_name) {
        this.id_abteilung = id_abteilung;
        this.abt_name = abt_name;
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
        final Abteilungen other = (Abteilungen) obj;
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
        return "Abteilungen{" + "id_abteilung=" + id_abteilung + ", abt_name=" + abt_name + '}';
    }
    
    
}
