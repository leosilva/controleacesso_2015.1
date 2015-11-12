/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso;

import controleacesso.dominio.Sistema;
import controleacesso.persistencia.TesteInsertSistema;
import java.util.Scanner;

/**
 *
 * @author leosilva
 */
public class ControleAcesso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome, sigla;
        System.out.println("Nome do sistema:");
        nome = scan.nextLine();
        System.out.println("Sigla do sistema:");
        sigla = scan.nextLine();
        // as próximas três criam um objeto do tipo Sistema e preenche os seus atributos
        Sistema sistema = new Sistema();
        sistema.setNome(nome);
        sistema.setSigla(sigla);
        /* é criada uma instância da classe TesteInsertSistema a fim de inserir um sistema
         * no banco de dados
         */
        TesteInsertSistema tis = new TesteInsertSistema();
        /*
         * é chamado o método inserirSistema(), que de fato faz a inserção. Caso o retorno
         * seja 1, significa que o sistema foi inserido com sucesso. Caso o retorno
         * não seja 1, o sistema não foi inserido com sucesso.
         */
        if (tis.inserirSistema(sistema) == 1) {
            System.out.println("Sistema inserido com sucesso!");
        } else {
            System.out.println("Sistema não inserido!");
        }
    }
}
