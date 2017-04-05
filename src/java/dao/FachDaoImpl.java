/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.Indizes;
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
public class FachDaoImpl implements FachDAO{
    private final static String SELALL_QRY = "SELECT * FROM FAECHER";
    private final static String SELBYID_QRY = SELALL_QRY + " WHERE FACH_ID = ";
    private final static String DELETE_QRY = "DELETE FROM FAECHER WHERE FACH_ID = ";
    private final static String UPDATE_QRY = "UPDATE FAECHER SET ID_FACH=?, FACHBEZ=? where ID_FACH=?";
    private final static String INSERT_QRY = "INSERT INTO FAECHER (ID_FACH, FACHBEZ) values (?,?)";
 

    @Override
    public List find(String selectStatement) {
        List<Fach> retVal = new LinkedList<>();
        Fach d;
        try ( Statement stmt = ConnectionManager.getInst().getConnection().createStatement();
              ResultSet rs = stmt.executeQuery(selectStatement) ) {

            while (rs.next()) {
                d = new Fach(rs.getInt("ID_FACH"),rs.getString("FACHBEZ"));
                retVal.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FachDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } //rs.close(); stmt.close(); 

        return retVal;
    }

    public List findAll() {
        return this.find(SELALL_QRY);
    }

    public Fach findByID(Indizes idx) {
        if(idx.getIndizesMap().containsKey(Fach.INDEX_KEYS[0])){
            List l=this.find("Select * from FAECHER where ID_FACH="+idx.getIndizesMap().get(Fach.INDEX_KEYS[0]));
            if(l.get(0)!=null){
            return (Fach) l.get(0);
            }

        }
        return null;
    }

    public void delete(Fach obj) {
        try (Statement stmt = ConnectionManager.getInst().getConnection().createStatement()) {
            stmt.executeUpdate(DELETE_QRY + obj.getId_Fach());
        } catch (SQLException ex) {
            Logger.getLogger(FachDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public PreparedStatement getInsertStatement(Fach obj) {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);

            stmt.setString(1, Integer.toString(obj.getId_Fach()));
            stmt.setString(2, obj.getFachbez());

            return stmt;
        }catch(SQLException ex){
            Logger.getLogger(FachDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Fach obj) {
        try (PreparedStatement stmt = this.getInsertStatement(obj)) { 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FachDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Fach obj) {
        try (PreparedStatement stmt = this.getInsertStatement(obj)) { 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FachDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

