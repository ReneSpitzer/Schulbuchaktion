/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Klasse;
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
public class KlassenJdbcDao extends BaseJdbcDao<Klasse> implements KlassenDAO{
    private static final String INSERT_QRY="INSERT INTO KLASSEN (JAHR_IDX,BEZEICHNUNG,JAHRGANG,ABTEILUNG,SCHUELER_ANZ,REP_ANZ) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_QRY="UPDATE KLASSEN SET ABTEILUNG=?,SCHUELER_ANZ=?,REP_ANZ=? WHERE ";
    
    private JahrDAO jd;
    private AbteilungDAO ad;
    
    
    public KlassenJdbcDao(JahrDAO jd, AbteilungDAO ad) {
        super("KLASSEN");
        
        this.jd=jd;
        this.ad=ad;
    }

    @Override
    protected Klasse getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            List jahr_idx=new ArrayList();
            List abt_idx=new ArrayList();
            
            abt_idx.add(result.getInt("ABTEILUNG"));
            jahr_idx.add(result.getInt("JAHRIDX"));
            
            return new Klasse(
                jd.read(jahr_idx),
                result.getInt("JAHRGANG"),
                result.getString("BEZEICHNUNG"),
                result.getInt("SCHUELER_ANZ"),
                ad.read(abt_idx),
                result.getInt("REP_ANZ")
                );
            
        }catch(Exception e){
            
        }
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Klasse t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry());
            
            stmt.setInt(1, t.getAbt().getId_abteilung());
            stmt.setInt(2, t.getSchueler_anz());
            stmt.setInt(3, t.getRep_anz());
            
            stmt.setInt(4, t.getJahrIdx().getJahr());
            stmt.setInt(5, t.getJahrgang());
            stmt.setString(6, t.getKlassen_Bez());
            
            return stmt;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Klasse t) throws SQLException {
        try{
            PreparedStatement stmt = ConnectionManager.getInst().getConnection().prepareStatement(UPDATE_QRY+t.getIndexQry());
            
            stmt.setInt(1, t.getJahrIdx().getJahr());
            stmt.setString(3, t.getKlassen_Bez());
            stmt.setInt(2, t.getJahrgang());          
            stmt.setInt(4, t.getAbt().getId_abteilung());
            stmt.setInt(5, t.getSchueler_anz());
            stmt.setInt(6, t.getRep_anz());
            
            return stmt;
        }catch(Exception e){
            return null;
        }
    }
    
}
