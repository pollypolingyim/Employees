package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Shahriar Emami
 * @author Stanley Pieda
 * @see https://tomcat.apache.org/tomcat-8.0-doc/jndi-resources-howto.html
 */
public class DataSource {

    private static DataSource singleton = new DataSource();
    
    public javax.sql.DataSource ds;
    
    private DataSource() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (javax.sql.DataSource) envCtx.lookup("jdbc/Employees");
        } catch (NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection createConnection() {
        Connection connection = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("jdbc/Employees");
            connection = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    private void getDataSource() {
        try{ 
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("java: ds = (java.sql.DataSource) envCtx.lookup(“jdbc/Employee"); 
        }
        catch(NamingException ex){ 
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "");
        }
    }
    public static Connection getConnection(){ 
        if (singleton == null){
            singleton = new DataSource();
            singleton.getDataSource();
        }
        return singleton.createConnection(); 
    }
}
