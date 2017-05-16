/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.converter;

import at.htlpinkafeld.schulbuchaktion.gui.BuchBean;
import at.htlpinkafeld.schulbuchaktion.gui.FachBean;
import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
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
public class FachConverter implements Converter{
/*
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Fach retVal=null;
        if(string!=null){
             String[] strf=string.split("-");
             retVal=new Fach(Integer.parseInt(strf[0]),strf[1]);
        }  
       return retVal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String retVal=null;
       if(o!=null){
           Fach f=(Fach)o;
           retVal=f.getId_Fach()+"-"+f.getFachbez();
       }
       return retVal;
    }
    */
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Fach retVal = null;
        FacesMessage fm = null;

        if (string != null) {
            try {
                int id = Integer.parseInt(string);
                Application app = fc.getApplication();
                ELResolver elRes = app.getELResolver();
                FachBean plB = (FachBean) elRes.getValue(fc.getELContext(),
                        null,
                        "fachBean");
                List<Fach> pList = plB.getSchulbuchmanagerservice().getFlist();
                
                retVal = selectWithID(pList, id);
                if (retVal == null) {
                    fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Invalid Fach-Id.", "");
                }

            } catch (NumberFormatException e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Fach-Id is not a number.", "");
            } catch (Exception e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Fach conversion error.", "");
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
            Fach p = (Fach) o;
            id = p.getId_Fach();
            if (id > 0) {
                retVal = Integer.toString(id);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "FachId not Initialized!!!",
                        "");
                throw new ConverterException(fm);
            }

        }

        return retVal;
    }

    private Fach selectWithID(List<Fach> pList, int id) {

        for (Fach p : pList) {
            if (p.getId_Fach() == id) {
                return p;
            }
        }

        return null;
    }
}
