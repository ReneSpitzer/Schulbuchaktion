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
public class Klasse {
    private int jahrgang;
    private String schueler_bez;
    private int schueler_anz;
    private Abteilungen abt;
    private int rep_anz;

    public Klasse(int jahrgang, String schueler_bez, int schueler_anz, Abteilungen abt, int rep_anz) {
        this.jahrgang = jahrgang;
        this.schueler_bez = schueler_bez;
        this.schueler_anz = schueler_anz;
        this.abt = abt;
        this.rep_anz = rep_anz;
    }

    public int getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    public String getSchueler_bez() {
        return schueler_bez;
    }

    public void setSchueler_bez(String schueler_bez) {
        this.schueler_bez = schueler_bez;
    }

    public int getSchueler_anz() {
        return schueler_anz;
    }

    public void setSchueler_anz(int schueler_anz) {
        this.schueler_anz = schueler_anz;
    }

    public Abteilungen getAbt() {
        return abt;
    }

    public void setAbt(Abteilungen abt) {
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
        hash = 29 * hash + Objects.hashCode(this.schueler_bez);
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
        if (!Objects.equals(this.schueler_bez, other.schueler_bez)) {
            return false;
        }
        if (!Objects.equals(this.abt, other.abt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Klasse{" + "jahrgang=" + jahrgang + ", schueler_bez=" + schueler_bez + ", schueler_anz=" + schueler_anz + ", abt=" + abt + ", rep_anz=" + rep_anz + '}';
    }
    
    
}
