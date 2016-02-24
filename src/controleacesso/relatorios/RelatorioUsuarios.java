/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.relatorios;

import controleacesso.dominio.Usuario;
import controleacesso.persistencia.dao.UsuarioDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author leosilva
 */
public class RelatorioUsuarios {
    
    private static UsuarioDAO usuarioDao = new UsuarioDAO();
    private static String arquivoJRXML = "relatorios/relatorioClientes1.jrxml";
    private static String arquivoDestino = "relatorios/relatorioClientes1.pdf";
            
    /**
     * Método chamado pela ação da tela responsável por gerar o relatório.
     * @throws SQLException
     * @throws JRException
     * @throws FileNotFoundException 
     */
    public static void gerarRelatorio() throws SQLException, JRException, FileNotFoundException {
        System.out.println("Gerando relatório...");
        
        // listando os usuarios do banco de dados para o relatorio
        List<Usuario> listaUsuarios = usuarioDao.listarUsuarios();
        
        // criando um mapa de parâmetros a serem passados para o relatorio.
        Map parameters = new HashMap();
        parameters.put("usuarioLogado", "Leo Silva");
    
        // compilacao do JRXML 
        JasperReport report = JasperCompileManager.compileReport(arquivoJRXML);
        
        // preenchimento do relatorio, note que o metodo recebe 3 parametros:
        // 1 - o relatorio 
        // 2 - um Map, com parametros que sao passados ao relatorio 
        // no momento do preenchimento.
        // 3 - o data source. Note que nao devemos passar a lista diretamente, 
        // e sim "transformar" em um data source utilizando a classe JRBeanCollectionDataSource.
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(listaUsuarios));
        
        // exportacao do relatorio para outro formato, no caso PDF
        JasperExportManager.exportReportToPdfFile(print, arquivoDestino);
        
        // abrir aplicação do sistema operacional responsável por mostrar o arquivo PDF
        abrirJanelaComPDF(arquivoDestino);
        
        System.out.println("Relatório gerado.");
    }
    
    /**
     * Este método abre a aplicação do sistema operacional do usuário responsáel por mostrar arquivos PDF. Um exemplo é o Adobe Reader.
     * @param arquivoDestino 
     */
    private static void abrirJanelaComPDF(String arquivoDestino) {
        if (Desktop.isDesktopSupported()) {
            try {
                File arquivoPDF = new File(arquivoDestino);
                Desktop.getDesktop().open(arquivoPDF);
            } catch (IOException ex) {
                // acontecerá exceção se o sistema operacional do usuário não possuir nenhum aplicativo para abrir arquivos PDF.
                ex.printStackTrace();
            }
        }
    }
    
}
