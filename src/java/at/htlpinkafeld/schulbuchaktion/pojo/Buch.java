/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Buch {
    private int id_buch;
    private int sb_nr;
    private String sb_titel_lang;
    private String sb_titel_kurz;
    private int isbn;
    private String anmerkung;
    private String erstelldatum;
    private String ersteller;
    private double preis;
    private int verlag;
    private Fach fach;
    private Abteilung abt;
    private boolean lehrerexample;
    private boolean status_aktiv;
    
    private Indizes idx;

    public Buch(){
        
    }
    
    
    public Buch(int id_buch, int sb_nr, String sb_titel_lang, String sb_titel_kurz, int isbn, String anmerkung, String erstelldatum, String ersteller, double preis, int verlag, Fach fach, Abteilung abt, boolean lehrerexample, boolean status_aktiv) {
        this.id_buch = id_buch;
        this.sb_nr = sb_nr;
        this.sb_titel_lang = sb_titel_lang;
        this.sb_titel_kurz = sb_titel_kurz;
        this.isbn = isbn;
        this.anmerkung = anmerkung;
        this.erstelldatum = erstelldatum;
        this.ersteller = ersteller;
        this.preis = preis;
        this.verlag = verlag;
        this.fach = fach;
        this.abt = abt;
        this.lehrerexample = lehrerexample;
        this.status_aktiv = status_aktiv;
        
        idx=new Indizes();
        idx.addIndex("ID_BUCH", id_buch); //wegen dieser Variable muss ein eine jede klasse Immutable sein
    }



    public int getId_Buch() {
        return id_buch;
    }

    public void setId_buch(int id_buch) {
        this.id_buch = id_buch;
    }

    public int getSb_nr() {
        return sb_nr;
    }

    public void setSb_nr(int sb_nr) {
        this.sb_nr = sb_nr;
    }

    public String getSb_titel_lang() {
        return sb_titel_lang;
    }

    public void setSb_titel_lang(String sb_titel_lang) {
        this.sb_titel_lang = sb_titel_lang;
    }

    public String getSb_titel_kurz() {
        return sb_titel_kurz;
    }

    public void setSb_titel_kurz(String sb_titel_kurz) {
        this.sb_titel_kurz = sb_titel_kurz;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAnmerkung() {
        return anmerkung;
    }

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    public String getErstelldatum() {
        return erstelldatum;
    }

    public void setErstelldatum(String erstelldatum) {
        this.erstelldatum = erstelldatum;
    }

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getVerlag() {
        return verlag;
    }

    public void setVerlag(int verlag) {
        this.verlag = verlag;
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

    public Abteilung getAbt() {
        return abt;
    }

    public void setAbt(Abteilung abt) {
        this.abt = abt;
    }

    public boolean isLehrerexample() {
        return lehrerexample;
    }

    public void setLehrerexample(boolean lehrerexample) {
        this.lehrerexample = lehrerexample;
    }

    public boolean getBuechercol() {
        return status_aktiv;
    }

    public void setBuechercol(boolean buechercol) {
        this.status_aktiv = buechercol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id_buch;
        hash = 41 * hash + this.sb_nr;
        hash = 41 * hash + Objects.hashCode(this.sb_titel_lang);
        hash = 41 * hash + Objects.hashCode(this.sb_titel_kurz);
        hash = 41 * hash + Objects.hashCode(this.isbn);
        hash = 41 * hash + Objects.hashCode(this.anmerkung);
        hash = 41 * hash + Objects.hashCode(this.erstelldatum);
        hash = 41 * hash + Objects.hashCode(this.ersteller);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.preis) ^ (Double.doubleToLongBits(this.preis) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.verlag);
        hash = 41 * hash + Objects.hashCode(this.fach);
        hash = 41 * hash + Objects.hashCode(this.abt);
        hash = 41 * hash + (this.lehrerexample ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.status_aktiv);
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
        final Buch other = (Buch) obj;

        if (this.id_buch != other.id_buch) {
            return false;
        }
        if (this.sb_nr != other.sb_nr) {
            return false;
        }
        if (Double.doubleToLongBits(this.preis) != Double.doubleToLongBits(other.preis)) {
            return false;
        }
        if (this.lehrerexample != other.lehrerexample) {
            return false;
        }
        if (!Objects.equals(this.sb_titel_lang, other.sb_titel_lang)) {
            return false;
        }
        if (!Objects.equals(this.sb_titel_kurz, other.sb_titel_kurz)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.anmerkung, other.anmerkung)) {
            return false;
        }
        if (!Objects.equals(this.ersteller, other.ersteller)) {
            return false;
        }
        if (!Objects.equals(this.verlag, other.verlag)) {
            return false;
        }
        if (!Objects.equals(this.status_aktiv, other.status_aktiv)) {
            return false;
        }
        if (!Objects.equals(this.erstelldatum, other.erstelldatum)) {
            return false;
        }
        if (!Objects.equals(this.fach, other.fach)) {
            return false;
        }
        if (!Objects.equals(this.abt, other.abt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Buecher{" + ", id_buch=" + id_buch + ", sb_nr=" + sb_nr + ", sb_titel_lang=" + sb_titel_lang + ", sb_titel_kurz=" + sb_titel_kurz + ", isbn=" + isbn + ", anmerkung=" + anmerkung + ", erstelldatum=" + erstelldatum + ", ersteller=" + ersteller + ", preis=" + preis + ", verlag=" + verlag + ", "
                + "fach=" + fach + ", abt=" + abt + ", lehrerexample=" + lehrerexample + ", buechercol=" + status_aktiv + '}';
    }
    
    
}
