/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Jahr implements Identifiable{
    private int jahr;
    
    private static List idx;

    public Jahr(int jahr) {
        this.jahr = jahr;
        if(idx==null)
        {
            idx= new ArrayList();
            idx.add("JAHR");
        }
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

    @Override
    public List getId() {
        List retVal = new ArrayList();
        
        retVal.add(jahr);
        
        return retVal;
    }

    @Override
    public void setId(int d) {
        jahr=d;
    }

    @Override
    public String getIndexQry() {
        String retVal="";
        
        retVal+=idx.get(0)+"="+jahr+" ";
        
        return retVal;
    }
    
    
}
