/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import java.util.Date;

/**
 *
 * @author marko
 */
public class NewMain {
        private static FachDAO fachDao;
    /**
     * @param args the command line arguments
     */
        
        
    public static void main(String[] args) {
        fachDao= new FachDaoImpl();
        
        fachDao.insert(new Fach(1,"MAtmatik"));
   }
    
}
