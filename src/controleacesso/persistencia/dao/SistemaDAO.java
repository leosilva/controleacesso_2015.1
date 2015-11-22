/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia.dao;

import controleacesso.dominio.Sistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe implementa o padrão DAO (Data Access Object) para a entidade Sistema.
 * Todos os métodos responsáveis por manipular registros no banco de dados 
 * relacionados a essa entidade estão nesta classe.
 * @author leosilva
 */
public class SistemaDAO extends GenericDAO {
    
    /**
     * Método que adiciona um sistema no banco de dados.
     * @param sistema
     * @return int
     * @throws SQLException 
     */
    public int adicionarSistema(Sistema sistema) throws SQLException {
        int resultado = 0;
        try {
            // as variáveis connection e pstmt foram definidas na classe pai GenericDAO.
            pstmt = connection.prepareStatement("INSERT INTO sistema (sigla, nome) VALUES (?, ?)");
            pstmt.setString(1, sistema.getSigla());
            pstmt.setString(2, sistema.getNome());
            resultado = pstmt.executeUpdate();
        } finally {
            // o bloco finally SEMPRE será executado, independente de acontecer ou não uma exceção.
            finishConnection();
        }
        return resultado;
    }
    
    /**
     * Método que lista todos os sistemas existentes no banco de dados.
     * @return
     * @throws SQLException 
     */
    public List<Sistema> listarSistemas() throws SQLException {
        List<Sistema> sistemas = new ArrayList<Sistema>();
        try {
            // as variáveis connection, resultSet e pstmt foram definidas na classe pai GenericDAO.
            pstmt = connection.prepareStatement("SELECT * FROM sistema");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Sistema sistema = new Sistema();
                sistema.setId(resultSet.getInt("id"));
                sistema.setSigla(resultSet.getString("sigla"));
                sistema.setNome(resultSet.getString("nome"));
                sistemas.add(sistema);
            }
        } finally {
            // o bloco finally SEMPRE será executado, independente de acontecer ou não uma exceção.
            finishConnection();
        }
        return sistemas;
    }

    /**
     * Método que lista os sistemas de acordo com a sigla passada como parâmetro.
     * @param sigla
     * @return sistema
     * @throws SQLException 
     */
    public Sistema listarSistemaPorSigla(String sigla) throws SQLException {
        Sistema sistema = new Sistema();
        try {
            // as variáveis connection, resultSet e pstmt foram definidas na classe pai GenericDAO.
            pstmt = connection.prepareStatement("SELECT * FROM sistema WHERE sigla = ?");
            pstmt.setString(1, sigla);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {        
                sistema.setId(resultSet.getInt("id"));
                sistema.setSigla(resultSet.getString("sigla"));
                sistema.setNome(resultSet.getString("nome"));
            }
        } finally {
            // o bloco finally SEMPRE será executado, independente de acontecer ou não uma exceção.
            finishConnection();
        }
        return sistema;
    }
    
}
