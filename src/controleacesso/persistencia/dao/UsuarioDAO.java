/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia.dao;

import controleacesso.dominio.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe implementa o padrão DAO (Data Access Object) para a entidade Usuario.
 * Todos os métodos responsáveis por manipular registros no banco de dados 
 * relacionados a essa entidade estão nesta classe.
 * @author leosilva
 */
public class UsuarioDAO extends GenericDAO {
    
    /**
     * Método que adiciona um usuario no banco de dados.
     * @param usuario
     * @return int
     * @throws SQLException 
     */
    public int adicionarUsuario(Usuario usuario) throws SQLException {
        int resultado = 0;
        try {
            // as variáveis connection e pstmt foram definidas na classe pai GenericDAO.
            pstmt = connection.prepareStatement("INSERT INTO usuario (login, senha) VALUES (?, ?)");
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            resultado = pstmt.executeUpdate();
        } finally {
            // o bloco finally SEMPRE será executado, independente de acontecer ou não uma exceção.
            finishConnection();
        }
        return resultado;
    }
    
    /**
     * Método que lista todos os usuarios existentes no banco de dados.
     * @return
     * @throws SQLException 
     */
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            // as variáveis connection, resultSet e pstmt foram definidas na classe pai GenericDAO.
            pstmt = connection.prepareStatement("SELECT * FROM usuario");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Usuario usuario= new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuarios.add(usuario);
            }
        } finally {
            // o bloco finally SEMPRE será executado, independente de acontecer ou não uma exceção.
            finishConnection();
        }
        return usuarios;
    }
    
}
