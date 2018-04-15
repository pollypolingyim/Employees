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
 * @see <a href = "https://tomcat.apache.org/tomcat-8.0-doc/jndi-resources-howto.html">Tomcat How to</a> 
 */
public class DataSource {

    private static DataSource singleton = new DataSource();

    /**
     * {@link DataSource} object
     */
    public javax.sql.DataSource ds;

    /**
     * Private no arguments constructor.
     */
    private DataSource() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (javax.sql.DataSource) envCtx.lookup("jdbc/Employees");
        } catch (NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method sets up the database connection
     *
     * @return Connection object
     */
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

    /**
     * This method sets up the the {@link Context} and the {@link DataSource}.
     */
    private void getDataSource() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("java: ds = (java.sql.DataSource) envCtx.lookup(“jdbc/Employee");
        } catch (NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, "");
        }
    }

    /**
     * This method returns the {@link Connection} object via a singleton.
     *
     * @return {@link DataSource} singleton
     */
    public static Connection getConnection() {
        if (singleton == null) {
            singleton = new DataSource();
            singleton.getDataSource();
        }
        return singleton.createConnection();
    }
}
