/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

/**
 *
 * @author Alex
 */
public class JahresBuecher {
    private int buecher_id_buch;
    private int jahr_jahr;

    public JahresBuecher(int buecher_id_buch, int jahr_jahr) {
        this.buecher_id_buch = buecher_id_buch;
        this.jahr_jahr = jahr_jahr;
    }

    public int getBuecher_id_buch() {
        return buecher_id_buch;
    }

    public void setBuecher_id_buch(int buecher_id_buch) {
        this.buecher_id_buch = buecher_id_buch;
    }

    public int getJahr_jahr() {
        return jahr_jahr;
    }

    public void setJahr_jahr(int jahr_jahr) {
        this.jahr_jahr = jahr_jahr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.buecher_id_buch;
        hash = 97 * hash + this.jahr_jahr;
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
        if (this.buecher_id_buch != other.buecher_id_buch) {
            return false;
        }
        if (this.jahr_jahr != other.jahr_jahr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JahresBuecher{" + "buecher_id_buch=" + buecher_id_buch + ", jahr_jahr=" + jahr_jahr + '}';
    }
    
    
}
