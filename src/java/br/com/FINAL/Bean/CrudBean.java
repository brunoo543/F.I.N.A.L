/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.Bean;

import br.com.FINAL.DAO.CrudDAO;
import br.com.FINAL.Util.Mensagem;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public abstract class CrudBean<E, D extends CrudDAO> {//O E vai representar a entidade(model) e o D o DAO(usuarioDAO) etc.....

    private E entidade;
    private List<E> listaEntidade;
    Mensagem m = new Mensagem();

    public CrudBean() {
        novo();
    }

    //Metodos Crud
    public void novo() {
        entidade = criarNovaEntidade();
    }

    public void salvar() {
        if (getDao().salvar(entidade)) {
            m.adicionarMensagem("Salvo com sucesso", FacesMessage.SEVERITY_INFO);
            novo();
        }
        else{
        m.adicionarMensagem("wqeeq",FacesMessage.SEVERITY_INFO);
        }
    }

    public void editar(E ent) {
        entidade = ent;
//    getDao().alterar(ent);
//    entidade = criarNovaEntidade();
    }

    public void excluir() {

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        int id = Integer.parseInt(request.getParameter("frmDetails:idmesa"));
        if (getDao().deletar(id)) {
            novo();
            m.adicionarMensagem("Mesa excluida com sucesso", FacesMessage.SEVERITY_INFO);
        }

    }

    public void buscar() {
        listaEntidade = getDao().carregar();
    }
    //Metodos Crud
    //Create, Read, Update e Delete

    //Responsável por criar os metodos na classe Bean.
    public abstract D getDao();

    public abstract E criarNovaEntidade();
    //Responsável por criar os metodos na classe Bean.

    //get e set 
    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getListaEntidade() {
        return listaEntidade;
    }

    public void setListaEntidade(List<E> listaEntidade) {
        this.listaEntidade = listaEntidade;
    }
    //get e set 

}
