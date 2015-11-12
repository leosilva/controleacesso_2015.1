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
public class Usuario {
    private Integer id;
    private String login;
    private String senha;
    private List<Sistema> sistemas;
    private List<Autorizacao> autorizacoes;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSistemas(List<Sistema> sistemas) {
        this.sistemas = sistemas;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public List<Sistema> getSistemas() {
        return sistemas;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }
}
