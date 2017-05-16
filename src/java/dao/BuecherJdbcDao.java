/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.dao.BaseJdbcDao;
import at.htlpinkafeld.dao.ConnectionManager;
import at.htlpinkafeld.dao.BuecherDAO;
import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Identifiable;
import java.sql.Connection;
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
public class BuecherJdbcDao extends BaseJdbcDao<Buch> implements BuecherDAO {
    private final static String UPDATE_QRY = "UPDATE BUECHER SET ID_BUCH=?, SB_NR=?, SB_TITEL_LANG=?, SB_TITEL_KURZ=?, ISBN=?, ANMERKUNG=?, ERSTELLDATUM=?, ERSTELLER=?, PREIS=?, VERLAG=?, FAECHER_ID_FACH=?, ABTEILUNG_ID_ABTEILUNG=?, LEHREXEMPLAR=?, JAHRGANG=?, STATUS_AKTIV=? where ";
    private final static String INSERT_QRY = "INSERT INTO BUECHER (SB_Nr,SB_TITEL_LANG,SB_TITEL_KURZ,ISBN,ANMERKUNG,ERSTELLDATUM,ERSTELLER,PREIS,VERLAG,FAECHER_ID_FAECHER,ABTEILUNG_ID_ABTEILUNG,LEHREXEMPLAR,JAHRGANG,STATUS_AKTIV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public BuecherJdbcDao() {
        super("BUECHER");
    }

    @Override
    protected Buch getPojoFromResultSet(ResultSet rs) throws SQLException {
        try{
            return new Buch(rs.getInt("ID_BUCH"), rs.getInt("SB_Nr"), rs.getString("SB_TITEL_LANG"), rs.getString("SB_TITEL_KURZ"), rs.getInt("ISBN"), rs.getString("Anmerkung")
                , rs.getDate("ERSTELLDATUM"), rs.getString("ERSTELLER"), rs.getDouble("PREIS"), rs.getInt("VERLAG"),rs.getInt("FAECHER_ID_FACH"), rs.getInt("ABTEILUNG_ID_ABTEILUNG")
                , rs.getString("Jahrgang"), rs.getBoolean("LEHREXEMPLAR"), rs.getBoolean("STATUS_AKTIV"));  //REFERNEZIMPLEMENTIERUNG IN DEN POJOS FEHLT
        }
        catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Buch obj) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+obj.getIndexQry()+";");

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
            stmt.setInt(12, obj.getId_buch());
            return stmt;
        }catch(SQLException ex){
            Logger.getLogger(BuecherJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Buch obj) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(INSERT_QRY);

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
            Logger.getLogger(BuecherJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setBuchStatus(Buch buch, boolean val) {
        try( Connection con = ConnectionManager.getInst().getConnection();
             PreparedStatement stmt = getUpdateStatement(con, buch)  ){
        
            String qry="UPDATE BUECHER SET STATUS_AKTIV="+val+"WHERE" +buch.getIndexQry();
   
            buch.setStatus_aktiv(val);
        
            stmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}