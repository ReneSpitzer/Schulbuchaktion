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
public class Verlag {
    private int VerlagNr;
    private String VerlagBez;

    public Verlag(int VerlagNr, String VerlagBez) {
        this.VerlagNr = VerlagNr;
        this.VerlagBez = VerlagBez;
    }

    public int getVerlagNr() {
        return VerlagNr;
    }

    public void setVerlagNr(int VerlagNr) {
        this.VerlagNr = VerlagNr;
    }

    public String getVerlagBez() {
        return VerlagBez;
    }

    public void setVerlagBez(String VerlagBez) {
        this.VerlagBez = VerlagBez;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.VerlagNr;
        hash = 37 * hash + Objects.hashCode(this.VerlagBez);
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
        if (this.VerlagNr != other.VerlagNr) {
            return false;
        }
        if (!Objects.equals(this.VerlagBez, other.VerlagBez)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Verlag{" + "VerlagNr=" + VerlagNr + ", VerlagBez=" + VerlagBez + '}';
    }
    
    
}
