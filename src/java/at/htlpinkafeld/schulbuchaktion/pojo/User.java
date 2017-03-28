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
public class User {
    private int id_User;
    private String bez;
    private String username;
    private String passwort;
    private boolean admin;
    private boolean abteilungsvorstand;
    private boolean schulbuchverantwortlicher;
    private boolean verwalter;
    //Fachverantwortlicher für? int/String/Faecher

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
        int hash = 5;
        hash = 89 * hash + this.id_User;
        hash = 89 * hash + Objects.hashCode(this.bez);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.passwort);
        hash = 89 * hash + (this.admin ? 1 : 0);
        hash = 89 * hash + (this.abteilungsvorstand ? 1 : 0);
        hash = 89 * hash + (this.schulbuchverantwortlicher ? 1 : 0);
        hash = 89 * hash + (this.verwalter ? 1 : 0);
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
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id_User=" + id_User + ", bez=" + bez + ", username=" + username + ", passwort=" + passwort + ", admin=" + admin + ", abteilungsvorstand=" + abteilungsvorstand + ", schulbuchverantwortlicher=" + schulbuchverantwortlicher + ", verwalter=" + verwalter + '}';
    }
    
    
}
