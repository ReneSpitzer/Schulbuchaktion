/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class ConnectionManager {
   private static final String DATASOURCE = "jdbc/schulbuchaktiondb";
   private static ConnectionManager connMgrInst = null;
   private DataSource ds = null;

   public static synchronized ConnectionManager getInst() {
      if (connMgrInst == null) 
        	connMgrInst = new ConnectionManager();
      
      return connMgrInst;
   }
   private ConnectionManager() {
      try {
         Context ctx;
         ctx = new javax.naming.InitialContext();
         ds = (DataSource) ctx.lookup("java:comp/env/" + DATASOURCE);
      } catch (NamingException ex) {
        	//log.error("Error lookup:"java:comp/env/"+DATASOURCE, ex);
      }
   }

   public Connection getConnection() {
      Connection retVal = null;
      try {
         retVal = ds.getConnection();  //get a connection from the pool
      } catch (SQLException ex) {
         //log.error("Error while connecting to database: "+ DATASOURCE, ex);
      }

      return retVal;
   }
} 

