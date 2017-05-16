/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Nachbestelliste;
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
public class NachbestelllisteJdbcDao extends BaseJdbcDao<Nachbestelliste> implements NachbestelllisteDAO{
    private static final String UPDATE_QRY="UPDATE BESTELLLISTE SET ANZAHL=? WHERE ";
    private static final String INSERT_QRY="INSERT INTO ABTEILUNG (JAHR_JAHR,ID_NACHBESTELLLISTE,ANZAHL,KLASSEN_JAHR,KLASSEN_BEZEICHNUNG,JAHRESBUCH_BUCHID,JAHRESBUCH_JAHR) VALUES(?,?,?,?,?,?,?,?);";
    
    private JahrDAO jd;
    private KlassenDAO kd;
    private JahresBuecherDAO jbd;
    
    public NachbestelllisteJdbcDao(JahrDAO j, KlassenDAO k, JahresBuecherDAO jb) {
        super("NACHBESTELLLISTE");
        jd=j;
        kd=k;
        jbd=jb;
    }

    @Override
    protected Nachbestelliste getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            List jahr_idx=new ArrayList();
            List klassen_idx=new ArrayList();
            List jahresbuecher_idx=new ArrayList();

            jahr_idx.add(result.getInt("JAHR_JAHR"));
            klassen_idx.add(result.getInt("KLASSEN_JAHR"));
            klassen_idx.add(result.getInt("KLASSEN_JAHRGANG"));
            klassen_idx.add(result.getString("KLASSEN_BEZEICHNUNG"));
            jahresbuecher_idx.add(result.getInt("JAHRESBUCH_BUCHID"));
            jahresbuecher_idx.add(result.getInt("JAHRESBUCH_JAHR"));
            
            return new Nachbestelliste(
                                        jd.read(jahr_idx),
                                        result.getInt("ID_BESTELLLISTE"),
                                        result.getInt("ANZAHL"),
                                        kd.read(klassen_idx),
                                        jbd.read(jahresbuecher_idx));
        }catch(Exception e){
            return null;
        }
                
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Nachbestelliste t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(UPDATE_QRY+t.getIndexQry()+";");

            stmt.setInt(1,t.getAnz());

            stmt.setInt(2, t.getJahr().getJahr());
            stmt.setInt(3, t.getNachbestell_id());
            stmt.setInt(4, t.getKlasse().getJahrIdx().getJahr());
            stmt.setInt(5, t.getKlasse().getJahrgang());
            stmt.setString(6, t.getKlasse().getKlassen_Bez());
            stmt.setInt(7, t.getBuch().getBuch().getId_buch());
            stmt.setInt(8, t.getBuch().getJahr().getJahr());
            
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Nachbestelliste t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(UPDATE_QRY+t.getIndexQry()+";");
            
            stmt.setInt(0, t.getJahr().getJahr());
            stmt.setInt(1, t.getNachbestell_id());
            stmt.setInt(2,t.getAnz());
            stmt.setInt(3, t.getKlasse().getJahrIdx().getJahr());
            stmt.setInt(4, t.getKlasse().getJahrgang());
            stmt.setString(5, t.getKlasse().getKlassen_Bez());
            stmt.setInt(6, t.getBuch().getBuch().getId_buch());
            stmt.setInt(7, t.getBuch().getJahr().getJahr());
                        
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
