/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.negocio;

import controleacesso.dominio.Sistema;
import controleacesso.persistencia.dao.SistemaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa um controlador. Pode-se dizer que, nesta aplicação, a classe controladora
 * receberá as chamadas de métodos da tela e fará todo o processamento necessário para a operação desejada pelo usuário.
 * Nessa operação pode estar incluso acesso ao banco de dados. A responsabilidade do acesso ao banco de dados, por sua vez,
 * é de responsabilidade das classes DAO.
 * @author leosilva
 */
public class SistemaController {
    
    /**
     * Este método é chamado de uma tela e realiza o salvamento de um sistema no banco de dados.
     * @param sistema
     * @return int
     * @throws SQLException 
     */
    public int salvarSistema(Sistema sistema) throws SQLException {
        int resultado;
        // cria o DAO responsável por manipular a entidade Sistema no banco de dados.
        SistemaDAO sistemaDAO = new SistemaDAO();
        // chama o método de adicionar um novo sistema.
        resultado = sistemaDAO.adicionarSistema(sistema);
        return resultado;
    }
    
    /**
     * Este método é chamado de uma tela e realiza a listagem de todos os sistemas.
     * @return sistemas
     * @throws SQLException 
     */
    public List<Sistema> listarSistemas() throws SQLException {
        List<Sistema> sistemas = new ArrayList<Sistema>();
        // cria o DAO responsável por manipular a entidade Sistema no banco de dados.
        SistemaDAO sistemaDAO = new SistemaDAO();
        // chama o método de listar sistemas.
        sistemas = sistemaDAO.listarSistemas();
        return sistemas;
    }

    /**
     * Este método é chamado de uma tela e realiza a listagem de sistemas a partir de uma sigla.
     * @param sigla
     * @return sistema
     * @throws SQLException 
     */
    public Sistema listarSistemasPorSigla(String sigla) throws SQLException {
        // cria o DAO responsável por manipular a entidade Sistema no banco de dados.
        SistemaDAO sistemaDAO = new SistemaDAO();
        // chama o método de listar sistemas por sigla.
        Sistema sistema = sistemaDAO.listarSistemaPorSigla(sigla);
        return sistema;
    }
    
}