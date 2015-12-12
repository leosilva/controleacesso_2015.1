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
    
    // as próximas 3 linhas definem os parâmetros para acesso ao banco de dados.
    private static String url = "jdbc:mysql://localhost:3306/controle_acesso";
    private static String usuario = "root";
    private static String senha = "root";
    
    private static ConnectionFactory fabrica = null;
    
    /**
     * Construtor privado da classe, onde é carregada a classe de conexão com o Banco de Dados.
     */
    private ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método estático onde é retornado uma instância desta classe. 
     * Do modo como foi implementado, apenas uma instância da classe existirá no sistema.
     * @return fabrica
     */
    public static ConnectionFactory getInstance() {
        if (fabrica == null) {
            fabrica = new ConnectionFactory();
        }
        return fabrica;
    }
    
    /**
     * Método que efetivamente cria uma conexão com o banco de dados a partir da url, usuario e senha.
     * @return con
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url, usuario, senha);
        return con;
    }
    
}
