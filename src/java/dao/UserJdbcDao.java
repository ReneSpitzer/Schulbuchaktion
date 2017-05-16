/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public class UserJdbcDao extends BaseJdbcDao<User> implements UserDAO{
    private FachDAO fd;
    
    
    private static final String UPDATE_QRY="UPDATE USER SET BEZ=?, USERNAME=?, PASSWORT=?, ADMIN=?, ABTEILUNGSVORSTAND=?, SCHULBUCHVERANTWORTLICHER=?, VERWALTER=?, FACHVERANTWORTLICHER_FUER=?, EMAIL=? WHERE ";
    private static final String INSERT_QRY="INSERT INTO USER (BEZ,USERNAME,PASSWORT,ADMIN,ABTEILUNGSVORSTAND"
            + ",SCHULBUCHVERANTWORTLICHER,VERWALTER,FACHVERANTWORTLICHER_FUER,EMAIL) VALUES (?,?,?,?,?,?,?,?)";
    
    public UserJdbcDao(FachDAO fd) {
        super("USER");
        this.fd=fd;
    }

    @Override
    protected User getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            List fach_idx=new ArrayList();
            fach_idx.add(result.getInt("FACHVERANTWORTLICHER_FUER"));
                return new User(
                result.getInt("ID_USER"),
                result.getString("BEZ"),
                result.getString("USERNAME"),
                result.getString("PASSWORT"),
                result.getBoolean("ADMIN"),
                result.getBoolean("ABTEILUNGSVORSTAND"),
                result.getBoolean("SCHULBUCHVERANTWORTLICHER"), 
                result.getBoolean("VERWALTER"),
                fd.read(fach_idx),
                result.getString("EMAIL"));
            
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, User t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry());

            stmt.setString(1, "\""+t.getBez()+"\"");
            stmt.setString(2, "\""+t.getUsername()+"\"");
            stmt.setString(3, "\""+t.getPasswort()+"\"");
            stmt.setBoolean(4, t.isAdmin());
            stmt.setBoolean(5, t.isAbteilungsvorstand());
            stmt.setBoolean(6, t.isSchulbuchverantwortlicher());
            stmt.setBoolean(7, t.isVerwalter());
            stmt.setInt(8, t.getFachverantwortlicher_fuer().getId_Fach());
            stmt.setString(9, "\""+t.getEmail()+"\"");
            
            stmt.setInt(10, t.getId_User());
            
            return stmt;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, User t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry());

            stmt.setString(1, "\""+t.getBez()+"\"");
            stmt.setString(2, "\""+t.getUsername()+"\"");
            stmt.setString(3, "\""+t.getPasswort()+"\"");
            stmt.setBoolean(4, t.isAdmin());
            stmt.setBoolean(5, t.isAbteilungsvorstand());
            stmt.setBoolean(6, t.isSchulbuchverantwortlicher());
            stmt.setBoolean(7, t.isVerwalter());
            stmt.setInt(8, t.getFachverantwortlicher_fuer().getId_Fach());
            stmt.setString(9, "\""+t.getEmail()+"\"");
            
            return stmt;
        }catch(Exception e){
            return null;
        }
    }
    
}
