/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leosilva
 */
public class ConnectionFactory {
    
    private static String url = "jdbc:mysql://localhost:3306/controle_acesso";
    private static String usuario = "root";
    private static String senha = "root";
    
    private static ConnectionFactory fabrica = null;
    
    private ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static ConnectionFactory getInstance() {
        if (fabrica == null) {
            fabrica = new ConnectionFactory();
        }
        return fabrica;
    }
    
    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, usuario, senha);
        return con;
    }
    
}
