/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.Bean;

import br.com.FINAL.DAO.ProdutoDAO;
import br.com.FINAL.Entity.Produto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoDAO> implements Serializable{
    
    private ProdutoDAO DAO;

    @Override
    public ProdutoDAO getDao() {
        if (DAO == null) {
            DAO = new ProdutoDAO();
        }
        return DAO;
    }

    @Override
    public Produto criarNovaEntidade() {
        return new Produto();
    }
    
}
