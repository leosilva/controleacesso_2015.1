/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia;

import controleacesso.dominio.Sistema;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author leosilva
 */
public class TesteInsertSistema {
    
    private PreparedStatement pstmt;
    
    /*
     * Método que insere um registro de Sistema no banco de dados. Para isso,
     * recebe como parâmetro um objeto da classe Sistema.
     */
    public int inserirSistema(Sistema sistema) {
        // variável do tipo int criada para armazenar o retorno do método pstmt.executeUpdate().
        int resultado = 0;
        try {
            /* a partir da classe FabricaDeConexoes, abre uma conexão com o banco de dados.
             * a partir da conexão é criado um PreparedStatement.
             * Nesse PreparedStatement, que é a instrução que será enviada ao banco de dados,
             * existem dois parâmetros indicados nas interrogações ("?"). A primeira interrogação,
             * seguindo a lógica da instrução INSERT, está relacionada ao parâmetro da coluna "sigla", e
             * a segunda instrução está relacionada a coluna "nome".
             */
            pstmt = FabricaDeConexoes.getInstance().getConnection().prepareStatement("INSERT INTO sistema (sigla, nome) VALUES (?, ?)");
            /* na linha abaixo um valor do tipo String está sendo atribuído ao primeiro parâmetro (indicado 
             * no primeiro argumento do método setString()). Esse valor é a sigla do sistema.
             */
            pstmt.setString(1, sistema.getSigla());
            /* na linha abaixo um valor do tipo String está sendo atribuído ao segundo parâmetro (indicado 
             * no primeiro argumento do método setString()). Esse valor é o nome do sistema.
             */
            pstmt.setString(2, sistema.getNome());
            /* 
            * o método pstmt.executeUpdate() retorna um inteiro indicando se o
            * comando foi ou não executado com sucesso. Caso seja, o retorno será 
            * um, caso contrário, zero.
            */
            resultado = pstmt.executeUpdate();
            // depois de executada a instrução, é ideal que o PreparedStatement seja fechado.
            pstmt.close();
        } catch(SQLException e) {
            e.printStackTrace();               
        }
        return resultado;
    }
    
}
