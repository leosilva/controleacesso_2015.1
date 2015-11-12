/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia;


/*
 * COMENTAR TODAS AS CLASSES ANTES DE COLOCAR NO GITHUB.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe é responsável por criar as conexões com o banco de dados.
 * @author leosilva
 */
public class FabricaDeConexoes {
    
    /*
     * As três variáveis abaixo representam, respectivamente, a URL de conexão com o banco de dados,
     * o usuário com permissões para acessar o banco de dados e a senha desse usuário.
     */
    private static String url = "jdbc:mysql://localhost:3306/controle_acesso";
    private static String usuario = "root";
    private static String senha = "root";
    
    private static FabricaDeConexoes fabrica = null;
    private Connection con;
    
    /**
     * Esse construtor privado carrega a classe do driver do JDBC para que se possa acessar
     * o banco de dados.
     */
    private FabricaDeConexoes() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Este método cria uma instância da classe FabricaDeConexoes. Por causa do if, é garantido
     * que somente uma instância desse objeto será criada enquanto o sistema estiver em execução.
     * @return fabrica
     */
    public static FabricaDeConexoes getInstance() {
        if (fabrica == null) {
            fabrica = new FabricaDeConexoes();
        }
        return fabrica;
    }
    
    /**
     * Este método cria uma conexão com o banco de dados, informando a url, usuario e senha
     * definidos nos atributos da classe.
     * @return
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        con = DriverManager.getConnection(url, usuario, senha);
        return con;
    }
    
}
