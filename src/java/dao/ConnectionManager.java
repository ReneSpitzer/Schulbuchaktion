/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maue
 */
public class ConnectionManager {

    private static final String DBDRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String PROTOCOL = "jdbc:derby:";
    private static final String URLDATASOURCE = "..\\SchulbuchAktion\\company";
    private static final String URLPOSTFIX = ";create=true";

    private static volatile ConnectionManager instance = null;

    private Connection connection = null;

    public static ConnectionManager getInst() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    private ConnectionManager() {
        try {
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(PROTOCOL + URLDATASOURCE + URLPOSTFIX, "db", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static void closeConnection() {
        //close the connection only if there is a instance
        //--> closeConnection() can always be called. 
        //(e.g. if non JDBC-Dao's are used  --> ConnectionManager is not instantiated)
        if (instance != null) {
            try {
                instance.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
