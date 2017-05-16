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
 * @author Alex
 */

public class User implements Identifiable{
    private int id_User;
    private String bez;
    private String username;
    private String passwort;
    private boolean admin;
    private boolean abteilungsvorstand;
    private boolean schulbuchverantwortlicher;
    private boolean verwalter;
    private Fach fachverantwortlicher_fuer;
    private String email;
    
    private static List idxNames;

    public User(int id_User, String bez, String username, String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter,Fach fachverantwortlicher_fuer, String email) {
        this.id_User = id_User;
        this.bez = bez;
        this.username = username;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.fachverantwortlicher_fuer= fachverantwortlicher_fuer;
        this.verwalter = verwalter;
        this.email = email;
        
        if(idxNames==null){
            idxNames=new ArrayList();
            idxNames.add("ID_USER");
        }
    }

    public User(User s) {
      this.id_User=s.id_User;
      this.bez=s.bez;
      this.username=s.username;
      this.passwort=s.passwort;
          this.admin = s.admin;
        this.abteilungsvorstand = s.abteilungsvorstand;
        this.schulbuchverantwortlicher = s.schulbuchverantwortlicher;

        this.verwalter = s.verwalter;
        this.email = s.email;
    }

  
     


    public Fach getFachverantwortlicher_fuer() {
        return fachverantwortlicher_fuer;
    }

    public void setFachverantwortlicher_fuer(Fach fachverantwortlicher_fuer) {
        this.fachverantwortlicher_fuer = fachverantwortlicher_fuer;
    }

    public User() {
        this(0,"","","",false,false,false,false,null,"");
    }
     public User(int id_User, String bez, String username, String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter, String email) {
        this.id_User = id_User;
        this.bez = bez;
        this.username = username;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.verwalter = verwalter;
        this.email = email;
        this.fachverantwortlicher_fuer= new Fach(0,"");
        
 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public User(int id_User, String bez, String username, String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter) {
        this.id_User = id_User;
        this.bez = bez;
        this.username = username;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.verwalter = verwalter;
    }

     public User( String bez,int id_User, String username, String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter) {
        this.id_User = id_User;
        this.bez = bez;
        this.username = username;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.verwalter = verwalter;
    }
     
      public User( String bez,int id_User,String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter) {
        this.id_User = id_User;
        this.bez = bez;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.verwalter = verwalter;
    }
      
       public User(int id_User, String username, String passwort, boolean admin, boolean abteilungsvorstand, boolean schulbuchverantwortlicher, boolean verwalter) {
        this.id_User = id_User;
        this.username = username;
        this.passwort = passwort;
        this.admin = admin;
        this.abteilungsvorstand = abteilungsvorstand;
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
        this.verwalter = verwalter;
    }
      public User(String bez,int id_User, String username, String passwort) {
        this.bez=bez;
        this.id_User = id_User;
        this.username = username;
        this.passwort = passwort;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getBez() {
        return bez;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAbteilungsvorstand() {
        return abteilungsvorstand;
    }

    public void setAbteilungsvorstand(boolean abteilungsvorstand) {
        this.abteilungsvorstand = abteilungsvorstand;
    }

    public boolean isSchulbuchverantwortlicher() {
        return schulbuchverantwortlicher;
    }

    public void setSchulbuchverantwortlicher(boolean schulbuchverantwortlicher) {
        this.schulbuchverantwortlicher = schulbuchverantwortlicher;
    }

    public boolean isVerwalter() {
        return verwalter;
    }

    public void setVerwalter(boolean verwalter) {
        this.verwalter = verwalter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id_User;
        hash = 13 * hash + Objects.hashCode(this.bez);
        hash = 13 * hash + Objects.hashCode(this.username);
        hash = 13 * hash + Objects.hashCode(this.passwort);
        hash = 13 * hash + (this.admin ? 1 : 0);
        hash = 13 * hash + (this.abteilungsvorstand ? 1 : 0);
        hash = 13 * hash + (this.schulbuchverantwortlicher ? 1 : 0);
        hash = 13 * hash + (this.verwalter ? 1 : 0);
        hash = 13 * hash + Objects.hashCode(this.fachverantwortlicher_fuer);
        hash = 13 * hash + Objects.hashCode(this.email);
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
        final User other = (User) obj;
        if (this.id_User != other.id_User) {
            return false;
        }
        if (this.admin != other.admin) {
            return false;
        }
        if (this.abteilungsvorstand != other.abteilungsvorstand) {
            return false;
        }
        if (this.schulbuchverantwortlicher != other.schulbuchverantwortlicher) {
            return false;
        }
        if (this.verwalter != other.verwalter) {
            return false;
        }
        if (!Objects.equals(this.bez, other.bez)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.passwort, other.passwort)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.fachverantwortlicher_fuer, other.fachverantwortlicher_fuer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id_User  + bez +  username +  passwort  + admin  + abteilungsvorstand  + schulbuchverantwortlicher + 
                 verwalter +  fachverantwortlicher_fuer  + email;
    }

    @Override
    public List getId() {
        List retVal=new ArrayList();
        
        retVal.add(id_User);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        id_User=d;
    }

    @Override
    public String getIndexQry() {
        return ""+idxNames.get(0)+"="+id_User;
    }
}

