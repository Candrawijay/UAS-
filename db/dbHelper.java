package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo Yoga
 */
public class dbHelper {
    private static final String username = "root";
    private static final String password = "";
    private static final String db = "boypro";
    private static final String myconn = "jdbc:mysql://localhost/"+db;
    
    public static Connection getConnection(){
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(myconn, username, password);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(dbHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        
        return conn;
    }
}
