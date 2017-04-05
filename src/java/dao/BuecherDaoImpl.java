/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Indizes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class BuecherDaoImpl implements BuecherDAO {
    private final static String SELALL_QRY = "SELECT * FROM BUECHER";
    private final static String SELBYID_QRY = SELALL_QRY + " WHERE ID_BUCH = ";
    private final static String DELETE_QRY = "DELETE FROM BUECHER WHERE ID_BUCH = ";
    private final static String UPDATE_QRY = "UPDATE BUECHER SET ID_BUCH=?, SB_NR=?, SB_TITEL_LANG=?, SB_TITEL_KURZ=?, ISBN=?, ANMERKUNG=?, ERSTELLDATUM=?, ERSTELLER=?, PREIS=?, VERLAG=?, FAECHER_ID_FACH=?, ABTEILUNG_ID_ABTEILUNG=?, LEHREXEMPLAR=?, JAHRGANG=?, STATUS_AKTIV=? where ID_BUCH=?";
    private final static String INSERT_QRY = "INSERT INTO BUECHER (ID_BUCH, SB_Nr,SB_TITEL_LANG,SB_TITEL_KURZ,ISBN,ANMERKUNG,ERSTELLDATUM,ERSTELLER,PREIS,VERLAG,FAECHER_ID_FAECHER,ABTEILUNG_ID_ABTEILUNG,LEHREXEMPLAR,JAHRGANG,STATUS_AKTIV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String DEACTIVATE_QRY="UPDATE BUECHER SET STATUS_AKTIV=? WHERE ID_BUCH=?";
 

    @Override
    public List find(String selectStatement) {
        List<Buch> retVal = new LinkedList<>();
        Buch d;
        try ( Statement stmt = ConnectionManager.getInst().getConnection().createStatement();
              ResultSet rs = stmt.executeQuery(selectStatement) ) {

            while (rs.next()) {
                d = new Buch(rs.getInt("ID_BUCH"), rs.getInt("SB_Nr"), rs.getString("SB_TITEL_LANG"), rs.getString("SB_TITEL_KURZ"), rs.getInt("ISBN"), rs.getString("Anmerkung")
                , rs.getDate("ERSTELLDATUM"), rs.getString("ERSTELLER"), rs.getDouble("PREIS"), rs.getInt("VERLAG"),rs.getInt("FAECHER_ID_FACH"), rs.getInt("ABTEILUNG_ID_ABTEILUNG")
                , rs.getString("Jahrgang"), rs.getBoolean("LEHREXEMPLAR"), rs.getBoolean("STATUS_AKTIV"));  //REFERNEZIMPLEMENTIERUNG IN DEN POJOS FEHLT
                retVal.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } //rs.close(); stmt.close(); 

        return retVal;
    }

    public List findAll() {
        return this.find(SELALL_QRY);
    }

    public Buch findByID(Indizes idx) {
        if(idx.getIndizesMap().containsKey(Buch.INDEX_KEYS[0])){
            List l=this.find("Select * from BUECHER where ID_BUCH="+idx.getIndizesMap().get(Buch.INDEX_KEYS[0]));
            if(l.get(0)!=null){
            return (Buch) l.get(0);
            }

        }
        return null;
    }

    public void delete(Buch obj) {
        try (Statement stmt = ConnectionManager.getInst().getConnection().createStatement()) {
            stmt.executeUpdate(DELETE_QRY + obj.getId_buch());
        } catch (SQLException ex) {
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public PreparedStatement getInsertStatement(Buch obj) {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);

            stmt.setInt(1, obj.getId_buch());
            stmt.setInt(2, obj.getSb_nr());
            stmt.setString(3, obj.getSb_titel_lang());
            stmt.setString(4, obj.getSb_titel_kurz());
            stmt.setInt(5, obj.getIsbn());
            stmt.setString(6, obj.getAnmerkung());
            stmt.setDate(7, obj.getErstelldatum());
            stmt.setString(8, obj.getErsteller());
            stmt.setDouble(9, obj.getPreis());
            stmt.setInt(10, obj.getVerlag());
            stmt.setInt(11, obj.getFach());
            stmt.setInt(12, obj.getAbt());
            stmt.setBoolean(13, obj.isLehrerexample());
            stmt.setString(14, obj.getJahrgang());
            stmt.setBoolean(15, obj.isStatus_aktiv());
            return stmt;
        }catch(SQLException ex){
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Buch obj) {
        try (PreparedStatement stmt = this.getInsertStatement(obj)) { 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Buch obj) {
        try (PreparedStatement stmt = this.getInsertStatement(obj)) { 
            stmt.setInt(16, obj.getId_buch());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setBuchStatus(Indizes idx,boolean val) {
        try (PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(DEACTIVATE_QRY)) { 
            stmt.setBoolean(1, val);
            stmt.setInt(2, (Integer)idx.getIndizesMap().get(Buch.INDEX_KEYS[0]));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuecherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
