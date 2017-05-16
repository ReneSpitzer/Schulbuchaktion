/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Jahr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marko
 */
public class JahrJdbcDao extends BaseJdbcDao<Jahr> implements JahrDAO{
    private final static String UPDATE_QRY="UPDATE Jahr SET Jahr=? where ";
    private final static String INSERT_QRY="INSERT INTO Jahr (Jahr) values (?);";
    
    public JahrJdbcDao() {
        super("JAHR");
    }

    @Override
    protected Jahr getPojoFromResultSet(ResultSet result) throws SQLException {
        Jahr retVal=null;
        
        try{
            retVal= new Jahr(result.getInt("JAHR"));
        }catch(Exception e){
            
        }
        return retVal;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Jahr t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry()+";");
            
            stmt.setInt(1, t.getJahr());
            stmt.setInt(3, t.getJahr());
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Jahr t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);
            
            stmt.setInt(1, t.getJahr());
            
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }
    
}
