/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Buch implements Identifiable{
    private int id_buch;
    private int sb_nr;
    private String sb_titel_lang;
    private String sb_titel_kurz;
    private int isbn;
    private String anmerkung;
    private Date erstelldatum;
    private String ersteller;
    private double preis;
    private int verlag;
    private Fach fach;
    private Abteilung abt;
    private String jahrgang;
    private boolean lehrerexample;
    private boolean status_aktiv;
    
    public static List idxNames;

    
    public Buch(int id_buch, int sb_nr, String sb_titel_lang, String sb_titel_kurz, int isbn, String anmerkung, Date erstelldatum, String ersteller, double preis, int verlag, Fach fach, Abteilung abt, String jahrgang, boolean lehrerexample, boolean status_aktiv){
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
        this.jahrgang = jahrgang;
        this.lehrerexample = lehrerexample;
        this.status_aktiv = status_aktiv;
        
        if(idxNames==null){
            idxNames=new ArrayList();
            idxNames.add("ID_BUCH");
        }
    }
    public Buch(){
        
    }
     public Buch(Buch b){
        this.id_buch = b.id_buch;
        this.sb_nr = b.sb_nr;
        this.sb_titel_lang = b.sb_titel_lang;
        this.sb_titel_kurz = b.sb_titel_kurz;
        this.isbn = b.isbn;
        this.anmerkung = b.anmerkung;
        this.erstelldatum = b.erstelldatum;
        this.ersteller = b.ersteller;
        this.preis = b.preis;
        this.verlag = b.verlag;
        this.fach = b.fach;
        this.abt = b.abt;
        this.jahrgang = b.jahrgang;
        this.lehrerexample = b.lehrerexample;
        this.status_aktiv = b.status_aktiv;

    }

    public Buch(int aInt) {
        
    }
    
  
    public int getId_buch() {
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

    public Date getErstelldatum() {
        return erstelldatum;
    }

    public void setErstelldatum(Date erstelldatum) {
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

  


    public String getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(String jahrgang) {
        this.jahrgang = jahrgang;
    }

    public boolean isLehrerexample() {
        return lehrerexample;
    }

    public void setLehrerexample(boolean lehrerexample) {
        this.lehrerexample = lehrerexample;
    }

    public boolean isStatus_aktiv() {
        return status_aktiv;
    }

    public void setStatus_aktiv(boolean status_aktiv) {
        this.status_aktiv = status_aktiv;
    }

    public List getIdxNames() {
        return idxNames;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_buch;
        hash = 41 * hash + this.sb_nr;
        hash = 41 * hash + Objects.hashCode(this.sb_titel_lang);
        hash = 41 * hash + Objects.hashCode(this.sb_titel_kurz);
        hash = 41 * hash + this.isbn;
        hash = 41 * hash + Objects.hashCode(this.anmerkung);
        hash = 41 * hash + Objects.hashCode(this.erstelldatum);
        hash = 41 * hash + Objects.hashCode(this.ersteller);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.preis) ^ (Double.doubleToLongBits(this.preis) >>> 32));
        hash = 41 * hash + this.verlag;
     
        hash = 41 * hash + Objects.hashCode(this.jahrgang);
        hash = 41 * hash + (this.lehrerexample ? 1 : 0);
        hash = 41 * hash + (this.status_aktiv ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.idxNames);
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
        if (this.isbn != other.isbn) {
            return false;
        }
        if (Double.doubleToLongBits(this.preis) != Double.doubleToLongBits(other.preis)) {
            return false;
        }
        if (this.verlag != other.verlag) {
            return false;
        }
        if (this.fach != other.fach) {
            return false;
        }
        if (this.abt != other.abt) {
            return false;
        }
        if (this.lehrerexample != other.lehrerexample) {
            return false;
        }
        if (this.status_aktiv != other.status_aktiv) {
            return false;
        }
        if (!Objects.equals(this.sb_titel_lang, other.sb_titel_lang)) {
            return false;
        }
        if (!Objects.equals(this.sb_titel_kurz, other.sb_titel_kurz)) {
            return false;
        }
        if (!Objects.equals(this.anmerkung, other.anmerkung)) {
            return false;
        }
        if (!Objects.equals(this.erstelldatum, other.erstelldatum)) {
            return false;
        }
        if (!Objects.equals(this.ersteller, other.ersteller)) {
            return false;
        }
        if (!Objects.equals(this.jahrgang, other.jahrgang)) {
            return false;
        }
        if (!Objects.equals(this.idxNames, other.idxNames)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Buch{" + "id_buch=" + id_buch + ", sb_nr=" + sb_nr + ", sb_titel_lang=" + sb_titel_lang + ", sb_titel_kurz=" + sb_titel_kurz + ", isbn=" + isbn + ", anmerkung=" + anmerkung + ", erstelldatum=" + erstelldatum + ", ersteller=" + ersteller + ", preis=" + preis + ", verlag=" + verlag + ", fach=" + fach + ", abt=" + abt + ", jahrgang=" + jahrgang + ", lehrerexample=" + lehrerexample + ", status_aktiv=" + status_aktiv + '}';
    }


    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(id_buch);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        id_buch=d;
    }

    @Override
    public String getIndexQry(){
        String retVal="";
        
        retVal+=idxNames.get(0)+"="+this.id_buch+" ";
        
        return retVal;
    }
}