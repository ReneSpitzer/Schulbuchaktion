/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.converter;

import at.htlpinkafeld.schulbuchaktion.gui.BuchBean;
import at.htlpinkafeld.schulbuchaktion.gui.LehrerBean;
import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import at.htlpinkafeld.schulbuchaktion.pojo.User;
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
public class UserConverter implements Converter{
 @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        User retVal = null;
        FacesMessage fm = null;
     System.out.println(string);
        if (string != null) {
            try {
                int id = Integer.parseInt(string.substring(0,1));
                Application app = fc.getApplication();
                ELResolver elRes = app.getELResolver();
               LehrerBean plB = (LehrerBean) elRes.getValue(fc.getELContext(),
                        null,
                        "lehrerBean");
                List<User> uList = plB.getSchulbuchmanagerservice().getUlist();

                retVal = selectWithID(uList, id);
                if (retVal == null) {
                    fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Invalid User-Id.", "");
                }

            } catch (NumberFormatException e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "User-Id is not a number.", "");
            } catch (Exception e) {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "User conversion error.", "");
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
            User p = (User) o;
            id = p.getId_User();
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

    private User selectWithID(List<User> pList, int id) {

        for (User p : pList) {
            if (p.getId_User()== id) {
                return p;
            }
        }

        return null;
    }
    
}
