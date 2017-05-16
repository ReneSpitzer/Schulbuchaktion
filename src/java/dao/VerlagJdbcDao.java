/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Verlag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marko
 */
public class VerlagJdbcDao extends BaseJdbcDao<Verlag> implements VerlagDAO{
    private static final String UPDATE_QRY="UPDATE VERLAG SET ID_VERLAG=?, VERLAG_NAME=?, ANSCHRIFT=? WHERE " ;
    private static final String INSERT_QRY="INSERT INTO VERLAG (VERLAG_NAME,ANSCHRIFT) VALUES (?,?);";
    
    public VerlagJdbcDao() {
        super("VERLAG");
    }

    @Override
    protected Verlag getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            if(result.getString("ANSCHRIFT")!=null)
                return new Verlag(result.getInt("ID_VERLAG"),result.getString("VERLAG_NAME"),result.getString("ANSCHRIFT"));
            
            return new Verlag(result.getInt("ID_VERLAG"),result.getString("VERLAG_NAME")); 
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Verlag t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry());

            stmt.setInt(1, t.getId_Verlag());
            stmt.setString(2, "\""+t.getVerlag_Name()+"\"");
            stmt.setString(3, "\""+t.getAnschrift()+"\"");
            stmt.setInt(4, t.getId_Verlag());
            
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Verlag t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);

            stmt.setString(1, "\""+t.getVerlag_Name()+"\"");
            stmt.setString(2, "\""+t.getAnschrift()+"\"");
            
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }
    
}
