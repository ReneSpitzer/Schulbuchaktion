/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Abteilung;
import at.htlpinkafeld.schulbuchaktion.pojo.Bestelliste;
import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Fach;
import at.htlpinkafeld.schulbuchaktion.pojo.Identifiable;
import at.htlpinkafeld.schulbuchaktion.pojo.Jahr;
import at.htlpinkafeld.schulbuchaktion.pojo.JahresBuecher;
import at.htlpinkafeld.schulbuchaktion.pojo.Klasse;
import at.htlpinkafeld.schulbuchaktion.pojo.Nachbestelliste;
import at.htlpinkafeld.schulbuchaktion.pojo.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marko
 */
public abstract class BaseJdbcDao<T extends Identifiable>{
    private final String TABLENAME;

    protected abstract T getPojoFromResultSet(ResultSet result) throws SQLException;

    protected abstract PreparedStatement getUpdateStatement(Connection c, T t)throws SQLException;
    protected abstract PreparedStatement getInsertStatement(Connection c, T t)throws SQLException;

    public BaseJdbcDao(String tablename) {
        this.TABLENAME = tablename;
    }

    public String getTablename() {
        return TABLENAME;
    }


    private PreparedStatement getPreparedStatement(Connection c, String sql, List id) throws SQLException {
        PreparedStatement stmt = c.prepareStatement(sql);
        try{
            for(int i=1;i<=id.size();i++){
                int j=1;
                if(id.get(i).getClass()==Integer.class){
                    stmt.setInt(j, (Integer) id.get(i));
                    j++;
                }
                else if(id.get(i).getClass()==String.class){
                    stmt.setString(j, (String)id.get(i));
                    j++;
                }
                else if(id.get(i).getClass()==Date.class){
                    stmt.setDate(j, (Date)id.get(i));
                    j++;
                }
                else if(id.get(i).getClass()==Double.class){
                    stmt.setDouble(j, (Double)id.get(i));
                    j++;
                }
                else if(id.get(i).getClass()==Float.class){
                    stmt.setFloat(j, (Float)id.get(i));
                    j++;
                }
                else if(id.get(i).getClass()==Jahr.class){
                    stmt.setInt(j, (Integer)((Jahr)id.get(i)).getId().get(0));
                    j++;
                }
                else if(id.get(i).getClass()==Buch.class){
                    stmt.setInt(j, (Integer)((Buch)id.get(i)).getId().get(0));
                    j++;
                }
                else if(id.get(i).getClass()==Fach.class){
                    stmt.setInt(j, (Integer)((Fach)id.get(i)).getId().get(0));
                    j++;
                }
                else if(id.get(i).getClass()==Abteilung.class){
                    stmt.setInt(j, (Integer)((Abteilung)id.get(i)).getId().get(0));
                    j++;
                }
                else if(id.get(i).getClass()==JahresBuecher.class){
                    stmt.setInt(j, (Integer)((Jahr)((JahresBuecher)id.get(i)).getId().get(0)).getId().get(0));
                    j++;
                    stmt.setInt(j, (Integer)((Buch)((JahresBuecher)id.get(i)).getId().get(0)).getId().get(0));
                    j++;
                }
                else if(id.get(i).getClass()==Klasse.class){
                    stmt.setInt(j, (Integer)((Jahr)((Klasse)id.get(i)).getId().get(0)).getId().get(0));
                    j++;
                    stmt.setInt(j, (Integer)((Klasse)id.get(i)).getId().get(1));
                    j++;
                    stmt.setString(j, (String)((Klasse)id.get(i)).getId().get(2));
                    j++;
                }
                else if(id.get(i).getClass()==User.class){
                    stmt.setInt(j, (Integer)((User)id.get(i)).getId().get(0));
                    j++;
                }
                else{
                    throw new Exception("Unsupported Type in Index");
                }
            }
        }
        catch(Exception e){
            System.out.println("CONVERSION EXCEPTION: "+e.getMessage());
        }
        return stmt;
    }

    public void delete(T t) {
        if (t.getId() == null) return;
        
        String sql = "DELETE FROM " + TABLENAME + " WHERE "+t.getIndexQry()+";";
        try( Connection con = ConnectionManager.getInst().getConnection();
             PreparedStatement stmt = getPreparedStatement(con, sql, t.getId()) ){
    
            stmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public T read(List id) {
        T t = null;
        String sql = "SELECT * FROM " +TABLENAME+ " WHERE "+t.getIndexQry()+" LIMIT 1;";
        try( Connection con = ConnectionManager.getInst().getConnection();
             PreparedStatement stmt = getPreparedStatement(con, sql, id);
             ResultSet result = stmt.executeQuery()) {

            if (result.next()) {
                t = getPojoFromResultSet(result);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public List<T> list() {
        List<T> results = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLENAME;
        try( Connection con = ConnectionManager.getInst().getConnection();
             Statement stmt = con.createStatement(); 
             ResultSet result = stmt.executeQuery(sql)) {
            
            while (result.next()) {
                results.add(getPojoFromResultSet(result));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return results;
    }


    public void update(T t) {
        if (t.getId() ==null)  return;
   
        try( Connection con = ConnectionManager.getInst().getConnection();
             PreparedStatement stmt = getUpdateStatement(con, t)  ){
            stmt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void insert(T t) {
        if (t.getId() ==null) return;
        
        try( Connection con = ConnectionManager.getInst().getConnection();
             PreparedStatement stmt = getInsertStatement(con, t);
             ResultSet genKeys = (stmt.executeUpdate()==1) ? stmt.getGeneratedKeys() : null ) {
            
            if (genKeys != null && genKeys.next() ) {
                t.setId(genKeys.getInt(1));
            }   
        } catch (SQLException ex) {
            //Logger.getLogger(BaseJdbcDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}