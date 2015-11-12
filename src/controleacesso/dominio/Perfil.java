/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacesso.dominio;

import java.util.List;

/**
 *
 * @author leosilva
 */
public class Perfil {
    private Integer id;
    private String nome;
    private Sistema sistema;
    private List<Autorizacao> autorizacoes;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }
}
