/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import at.htlpinkafeld.schulbuchaktion.pojo.Identifiable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marko
 */
public class AbteilungJdbcDao extends BaseJdbcDao<Abteilung> implements AbteilungDAO{
    private static final String UPDATE_QRY="UPDATE ABTEILUNG SET ID_ABTEILUNG=?, ABT_NAME=? WHERE ";
    private static final String INSERT_QRY="INSERT INTO ABTEILUNG (ABT_NAME) VALUES(?);";
    
    public AbteilungJdbcDao() {
        super("ABTEILUNG");
    }

    @Override
    protected Abteilung getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            return new Abteilung(result.getInt("ID_ABTEILUNG"),result.getString("ABT_NAME"));
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Abteilung t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(UPDATE_QRY+t.getIndexQry()+";");
            
            stmt.setInt(0, t.getId_abteilung());
            stmt.setString(1, "\""+t.getAbt_name()+"\"");
            stmt.setInt(2, t.getId_abteilung());
            
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Abteilung t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(INSERT_QRY);
            
            stmt.setString(1, "\""+t.getAbt_name()+"\"");
            
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
