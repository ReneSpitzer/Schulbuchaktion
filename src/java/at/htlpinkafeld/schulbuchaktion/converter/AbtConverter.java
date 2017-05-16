/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.converter;

import at.htlpinkafeld.schulbuchaktion.gui.BuchBean;
import at.htlpinkafeld.schulbuchaktion.gui.FachBean;
import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import java.util.List;
import javax.el.ELResolver;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author rene-_000
 */
public class AbtConverter implements Converter{
/*
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
            retVal=abt.getId_abteilung()+"-"+abt.getAbt_name();
        }
        return retVal;
      */
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Abteilung retVal = null;
        FacesMessage fm = null;

        if (string != null) {
            System.out.println(string);
            try {
                int id = Integer.parseInt(string.substring(0,1));
                Application app = fc.getApplication();
                ELResolver elRes = app.getELResolver();
               BuchBean plB = (BuchBean) elRes.getValue(fc.getELContext(),
                        null,
                        "buchBean");
                List<Abteilung> pList = plB.getSchulbuchmanagerservice().getAlist();

                retVal = selectWithID(pList, id);
                if (retVal == null) {
                    fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Invalid Fach-Id.", "");
                }

            } catch (NumberFormatException e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Abteilung-Id is not a number.", "");
            } catch (Exception e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Abteilung conversion error.", "");
            }
            finally {
                if( fm != null )
                    throw new ConverterException(fm);
            }
        }

        return retVal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String retVal = null;

        if (o != null) {
            int id;
            Abteilung p = (Abteilung) o;
            id = p.getId_abteilung();
            if (id > 0) {
                retVal = p.toString();
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "AbteilungId not Initialized!!!",
                        "");
                throw new ConverterException(fm);
            }

        }

        return retVal;
    }

    private Abteilung selectWithID(List<Abteilung> pList, int id) {

        for (Abteilung p : pList) {
            if (p.getId_abteilung()== id) {
                return p;
            }
        }

        return null;
    }
    }
    
    
    
    
    


