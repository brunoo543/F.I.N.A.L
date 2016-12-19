/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.Bean;
import br.com.FINAL.DAO.CategoriaDAO;
import br.com.FINAL.Entity.Categoria;
import br.com.FINAL.Util.Mensagem;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "cat")
@SessionScoped
public class CategoriaBean extends CrudBean<Categoria,CategoriaDAO> implements Serializable{
    
    private CategoriaDAO DAO;

    @Override
    public CategoriaDAO getDao() {
        if (DAO == null) {
            DAO = new CategoriaDAO();
        }
        return DAO;
    }
    
    @Override
    public Categoria criarNovaEntidade() {
        return new Categoria();
    }

    
    
    

    
}
