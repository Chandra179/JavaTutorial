import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Dbconn {

    public static void main(String[] args) {
        // create three connections to three different databases on localhost
        Connection conn = null;
        String dbURL2 = "jdbc:postgresql://localhost/ProductDB2";
        String user = "root";
        String pass = "secret";

        try {
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                System.out.println("Connected to database");
            }
            var tes = new Example("chandra");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}