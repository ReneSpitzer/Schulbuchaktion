/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.converter;

import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author rene-_000
 */
public class AbtConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Abteilung retVal=null;
        if(string!=null){
            String[] strf=string.split("-");
            retVal=new Abteilung(Integer.parseInt(strf[0]),strf[1]);
        }
        return retVal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String retVal=null;
        if(o!=null){
            Abteilung abt=(Abteilung)o;
            retVal=abt.getId_abteilung()+" "+abt.getAbt_name();
        }
        return retVal;
        
    }
    
    
    
    
    
}

