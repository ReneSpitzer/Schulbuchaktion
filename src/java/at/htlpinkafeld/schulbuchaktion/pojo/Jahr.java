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
public class Jahr {
    private int jahr;

    public Jahr(int jahr) {
        this.jahr = jahr;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    @Override
    public String toString() {
        return "Jahr{" + "jahr=" + jahr + '}';
    }
    
    
}
