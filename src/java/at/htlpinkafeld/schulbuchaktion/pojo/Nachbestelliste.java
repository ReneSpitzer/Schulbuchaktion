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
public class Nachbestelliste {
    private int jahr_jahr;
    private int nachbestell_id;
    private int anz;
    private int klassen_jahrgang;
    private String klassen_bez;
    private int jahresBuecher_Buecher_id_Buch;

    public Nachbestelliste(int jahr_jahr, int nachbestell_id, int anz, int klassen_jahrgang, String klassen_bez, int jahresBuecher_Buecher_id_Buch) {
        this.jahr_jahr = jahr_jahr;
        this.nachbestell_id = nachbestell_id;
        this.anz = anz;
        this.klassen_jahrgang = klassen_jahrgang;
        this.klassen_bez = klassen_bez;
        this.jahresBuecher_Buecher_id_Buch = jahresBuecher_Buecher_id_Buch;
    }

    public int getJahr_jahr() {
        return jahr_jahr;
    }

    public void setJahr_jahr(int jahr_jahr) {
        this.jahr_jahr = jahr_jahr;
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

    public int getKlassen_jahrgang() {
        return klassen_jahrgang;
    }

    public void setKlassen_jahrgang(int klassen_jahrgang) {
        this.klassen_jahrgang = klassen_jahrgang;
    }

    public String getKlassen_bez() {
        return klassen_bez;
    }

    public void setKlassen_bez(String klassen_bez) {
        this.klassen_bez = klassen_bez;
    }

    public int getJahresBuecher_Buecher_id_Buch() {
        return jahresBuecher_Buecher_id_Buch;
    }

    public void setJahresBuecher_Buecher_id_Buch(int jahresBuecher_Buecher_id_Buch) {
        this.jahresBuecher_Buecher_id_Buch = jahresBuecher_Buecher_id_Buch;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.jahr_jahr;
        hash = 83 * hash + this.nachbestell_id;
        hash = 83 * hash + this.anz;
        hash = 83 * hash + this.klassen_jahrgang;
        hash = 83 * hash + Objects.hashCode(this.klassen_bez);
        hash = 83 * hash + this.jahresBuecher_Buecher_id_Buch;
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
        if (this.jahr_jahr != other.jahr_jahr) {
            return false;
        }
        if (this.nachbestell_id != other.nachbestell_id) {
            return false;
        }
        if (this.anz != other.anz) {
            return false;
        }
        if (this.klassen_jahrgang != other.klassen_jahrgang) {
            return false;
        }
        if (this.jahresBuecher_Buecher_id_Buch != other.jahresBuecher_Buecher_id_Buch) {
            return false;
        }
        if (!Objects.equals(this.klassen_bez, other.klassen_bez)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nachbestelliste{" + "jahr_jahr=" + jahr_jahr + ", nachbestell_id=" + nachbestell_id + ", anz=" + anz + ", klassen_jahrgang=" + klassen_jahrgang + ", klassen_bez=" + klassen_bez + ", jahresBuecher_Buecher_id_Buch=" + jahresBuecher_Buecher_id_Buch + '}';
    }
    
    
}
