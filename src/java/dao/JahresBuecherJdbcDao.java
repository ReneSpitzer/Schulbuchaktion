/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Jahr;
import at.htlpinkafeld.schulbuchaktion.pojo.JahresBuecher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marko
 */
public class JahresBuecherJdbcDao extends BaseJdbcDao<JahresBuecher> implements JahresBuecherDAO{
    public static final String UPDATE_QRY="UPDATE JAHRESBUECHER SET JAHR_JAHR=?, BUECHER_ID_BUCH=? WHERE JAHR_JAHR=? AND BUECHER_ID_BUCH=?;";
    public static final String INSERT_QRY="INSERT INTO JAHRESBUEHCER (JAHR_JAHR,BUECHER_ID_BUCH) VALUES(?,?);";

    public JahresBuecherJdbcDao() {
        super("JAHRESBUECHER");
    }

    @Override
    protected JahresBuecher getPojoFromResultSet(ResultSet result) throws SQLException {
        JahresBuecher retVal=null;
        try{
            retVal=
                    new JahresBuecher(
                        new Buch(result.getInt("BUECHER_ID_BUCH")),
                        new Jahr(result.getInt("JAHR_JAHR")));
        }catch(Exception e){
            
        }
        return retVal;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, JahresBuecher t) throws SQLException {
        System.out.println("NOTHING TO BE UPDATED");
        return null;
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, JahresBuecher t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);
            
            stmt.setInt(1, t.getJahr().getJahr());
            stmt.setInt(2, t.getBuch().getId_buch());
            
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }  
}
