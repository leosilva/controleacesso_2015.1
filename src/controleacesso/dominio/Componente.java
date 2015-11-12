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
class Componente {
    private Integer id;
    private String nome;
    private List<Funcionalidade> funcionalidades;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }
}
