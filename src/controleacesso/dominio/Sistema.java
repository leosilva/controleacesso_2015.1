/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.dominio;

/**
 *
 * @author leosilva
 */
public class Sistema {
    private Integer id;
    private String sigla;
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}