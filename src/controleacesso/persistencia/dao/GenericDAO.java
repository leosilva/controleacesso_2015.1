/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia.dao;

import controleacesso.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe abstrata pai de todas as classes DAO da aplicação. 
 * Esta classe oferece todas as variáveis para se acessar e manipular o banco de dados.
 * Além disso, oferece um método para fechar todas as variáveis abertas.
 * @author leosilva
 */
public abstract class GenericDAO {
    
    // as variáveis abaixo serão usadas por todas as classes que herdarem o GenericDAO.
    protected Connection connection = null;
    protected PreparedStatement pstmt = null;
    protected Statement stmt = null;
    protected ResultSet resultSet = null;
    
    /**
     * Toda vez que um DAO for instanciado, este construtor será executado.
     * Dessa forma, a conexão com banco de dados será aberta no momento da instanciação das classes filhas.
     */
    public GenericDAO() {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Este método fechará todas as variáveis desta classe que foram usadas pelas classes filhas durante a manipulação do banco de dados.
     */
    protected void finishConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
