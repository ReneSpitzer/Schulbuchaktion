/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.dao.BaseJdbcDao;
import at.htlpinkafeld.dao.ConnectionManager;
import at.htlpinkafeld.dao.FachDAO;
import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.Identifiable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class FachJdbcDao extends BaseJdbcDao<Fach> implements FachDAO{
    private final static String UPDATE_QRY = "UPDATE FAECHER SET ID_FACH=?, FACHBEZ=? where ";
    private final static String INSERT_QRY = "INSERT INTO FAECHER (FACHBEZ) values (?)";
    
    public FachJdbcDao() {
        super("FAECHER");
    }

    @Override
    protected Fach getPojoFromResultSet(ResultSet rs) throws SQLException {
        try{
            return new Fach(rs.getInt("ID_FACH"),rs.getString("FACHBEZ"));
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Fach t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry()+";");
            
            stmt.setInt(1, t.getId_Fach());
            stmt.setString(2, "\""+t.getFachbez()+"\"");
            stmt.setInt(3, t.getId_Fach());
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Fach t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);
            
            stmt.setString(2, "\""+t.getFachbez()+"\"");
            
            return stmt;
        }catch(Exception e){
            
        }
        return null;
    }
}

