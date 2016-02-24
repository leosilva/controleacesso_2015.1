/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class T1 {
    
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meusCdsDb", "root", "root");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT titulo, autor, total_faixas FROM MeusCDs");
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int total_faixas = rs.getInt("total_faixas");
                System.out.println("Titulo: " + titulo + " Autor: " + autor + " Tot. Faixas: " + total_faixas);
            }
        } 
        catch (SQLException e) {} 
        catch (ClassNotFoundException ex) {}
        finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro no fechamento da conexão.");
                ex.printStackTrace();
            }
        }
    }
}