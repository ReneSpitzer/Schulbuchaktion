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
public class Bestelliste {
    private int jahr;
    private int id_bestellisten;
    private int anz;
    private int klassen_jahrgang;
    private String klasssen_bezeichnung;
    private int jaehresbuecher_jahresindex;
    private int jahresbuecher_buecher_id_buch;

    public Bestelliste(int jahr, int id_bestellisten, int anz, int klassen_jahrgang, String klasssen_bezeichnung, int jaehresbuecher_jahresindex, int jahresbuecher_buecher_id_buch) {
        this.jahr = jahr;
        this.id_bestellisten = id_bestellisten;
        this.anz = anz;
        this.klassen_jahrgang = klassen_jahrgang;
        this.klasssen_bezeichnung = klasssen_bezeichnung;
        this.jaehresbuecher_jahresindex = jaehresbuecher_jahresindex;
        this.jahresbuecher_buecher_id_buch = jahresbuecher_buecher_id_buch;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
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

    public int getKlassen_jahrgang() {
        return klassen_jahrgang;
    }

    public void setKlassen_jahrgang(int klassen_jahrgang) {
        this.klassen_jahrgang = klassen_jahrgang;
    }

    public String getKlasssen_bezeichnung() {
        return klasssen_bezeichnung;
    }

    public void setKlasssen_bezeichnung(String klasssen_bezeichnung) {
        this.klasssen_bezeichnung = klasssen_bezeichnung;
    }

    public int getJaehresbuecher_jahresindex() {
        return jaehresbuecher_jahresindex;
    }

    public void setJaehresbuecher_jahresindex(int jaehresbuecher_jahresindex) {
        this.jaehresbuecher_jahresindex = jaehresbuecher_jahresindex;
    }

    public int getJahresbuecher_buecher_id_buch() {
        return jahresbuecher_buecher_id_buch;
    }

    public void setJahresbuecher_buecher_id_buch(int jahresbuecher_buecher_id_buch) {
        this.jahresbuecher_buecher_id_buch = jahresbuecher_buecher_id_buch;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.jahr;
        hash = 71 * hash + this.id_bestellisten;
        hash = 71 * hash + this.anz;
        hash = 71 * hash + this.klassen_jahrgang;
        hash = 71 * hash + Objects.hashCode(this.klasssen_bezeichnung);
        hash = 71 * hash + this.jaehresbuecher_jahresindex;
        hash = 71 * hash + this.jahresbuecher_buecher_id_buch;
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
        if (this.jahr != other.jahr) {
            return false;
        }
        if (this.id_bestellisten != other.id_bestellisten) {
            return false;
        }
        if (this.anz != other.anz) {
            return false;
        }
        if (this.klassen_jahrgang != other.klassen_jahrgang) {
            return false;
        }
        if (this.jaehresbuecher_jahresindex != other.jaehresbuecher_jahresindex) {
            return false;
        }
        if (this.jahresbuecher_buecher_id_buch != other.jahresbuecher_buecher_id_buch) {
            return false;
        }
        if (!Objects.equals(this.klasssen_bezeichnung, other.klasssen_bezeichnung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bestelliste{" + "jahr=" + jahr + ", id_bestellisten=" + id_bestellisten + ", anz=" + anz + ", klassen_jahrgang=" + klassen_jahrgang + ", klasssen_bezeichnung=" + klasssen_bezeichnung + ", jaehresbuecher_jahresindex=" + jaehresbuecher_jahresindex + ", jahresbuecher_buecher_id_buch=" + jahresbuecher_buecher_id_buch + '}';
    }
    
    
    
}
