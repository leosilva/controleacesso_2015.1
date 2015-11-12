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
public class Funcionalidade {
    private Integer id;
    private String nome;
    private String descricao;
    private List<Componente> componentes;
    private Sistema sistema;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public Sistema getSistema() {
        return sistema;
    }
}
