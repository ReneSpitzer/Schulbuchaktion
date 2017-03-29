/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.converter;

import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author rene-_000
 */
public class DateConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Date retVal= null;
        if(string!=null){
            String[]strf =string.split(".");
           retVal=new Date(Integer.parseInt(strf[2]),Integer.parseInt(strf[1]),Integer.parseInt(strf[0]));
        }
        return retVal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String retVal=null;
        if(o!=null){
            Date d=(Date)o;
            retVal=d.getDay()+"."+d.getMonth()+"."+d.getYear();
        }
        return retVal;
    }
    
}
