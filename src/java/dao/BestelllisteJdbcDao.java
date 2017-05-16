/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Bestelliste;
import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Jahr;
import at.htlpinkafeld.schulbuchaktion.pojo.JahresBuecher;
import at.htlpinkafeld.schulbuchaktion.pojo.Klasse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author marko
 */
public class BestelllisteJdbcDao extends BaseJdbcDao<Bestelliste> implements BestelllisteDAO {
    private static final String UPDATE_QRY="UPDATE BESTELLLISTE SET JAHR_JAHR=?, ID_BESTELLLISTE=?, ANZAHL=?, KLASSEN_JAHR=?, KLASSEN_JAHRGANG=?, KLASSEN_BEZEICHUNG=?, JAHRESBUCH_BUCHID=?, JAHRESBUCH_JAHR=? WHERE ";
    private static final String INSERT_QRY="INSERT INTO ABTEILUNG (JAHR_JAHR,ID_BESTELLLISTE,ANZAHL,KLASSEN_JAHR,KLASSEN_BEZEICHNUNG,JAHRESBUCH_BUCHID,JAHRESBUCH_JAHR) VALUES(?,?,?,?,?,?,?,?);";
    
    
    public BestelllisteJdbcDao() {
        super("BESTLLLISTE");
    }

    @Override
    protected Bestelliste getPojoFromResultSet(ResultSet result) throws SQLException {
        try{
            return new Bestelliste(
            new Jahr(result.getInt("JAHR_JAHR")),
            result.getInt("ID_BESTELLLISTE"),
            result.getInt("ANZAHL"),
            new Klasse(new Jahr(result.getInt("KLASSEN_JAHR")),result.getInt("KLASSEN_JAHRGANG"),result.getString("KLASSEN_BEZEICHNUNG")),
            new JahresBuecher(new Buch(result.getInt("JAHRESBUCH_BUCHID")),new Jahr(result.getInt("JAHRESBUCH_JAHR"))));
        }catch(Exception e){
            return null;
        }
                
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection c, Bestelliste t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(UPDATE_QRY+t.getIndexQry()+";");

            stmt.setInt(0, t.getJahr().getJahr());
            stmt.setInt(1, t.getId_bestellisten());
            stmt.setInt(2,t.getAnz());
            stmt.setInt(3, t.getKlasse().getJahrIdx().getJahr());
            stmt.setInt(4, t.getKlasse().getJahrgang());
            stmt.setString(5, t.getKlasse().getKlassen_Bez());
            stmt.setInt(6, t.getJahresBuch().getBuch().getId_buch());
            stmt.setInt(7, t.getJahresBuch().getJahr().getJahr());
            
            stmt.setInt(8, t.getJahr().getJahr());
            stmt.setInt(9, t.getId_bestellisten());
            stmt.setInt(10, t.getKlasse().getJahrIdx().getJahr());
            stmt.setInt(11, t.getKlasse().getJahrgang());
            stmt.setString(12, "\""+t.getKlasse().getKlassen_Bez()+"\"");
            stmt.setInt(13, t.getJahresBuch().getBuch().getId_buch());
            stmt.setInt(14, t.getJahresBuch().getJahr().getJahr());
            
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    protected PreparedStatement getInsertStatement(Connection c, Bestelliste t) throws SQLException {
        try{
            PreparedStatement stmt= c.prepareStatement(UPDATE_QRY+t.getIndexQry()+";");
            
            stmt.setInt(0, t.getJahr().getJahr());
            stmt.setInt(1, t.getId_bestellisten());
            stmt.setInt(2,t.getAnz());
            stmt.setInt(3, t.getKlasse().getJahrIdx().getJahr());
            stmt.setInt(4, t.getKlasse().getJahrgang());
            stmt.setString(5, "\""+t.getKlasse().getKlassen_Bez()+"\"");
            stmt.setInt(6, t.getJahresBuch().getBuch().getId_buch());
            stmt.setInt(7, t.getJahresBuch().getJahr().getJahr());
                        
            return stmt;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
