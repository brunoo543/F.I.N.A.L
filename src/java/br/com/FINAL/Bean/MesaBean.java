/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.Bean;

import br.com.FINAL.DAO.MesaDAO;
import br.com.FINAL.Entity.Mesa;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mesa")
@SessionScoped
public class MesaBean extends CrudBean<Mesa, MesaDAO> implements Serializable{
    
    private MesaDAO DAO;
   

    @Override
    public MesaDAO getDao() {
        if (DAO == null) {
            DAO = new MesaDAO();
        }
        return DAO;
    }

    @Override
    public Mesa criarNovaEntidade() {
        return new Mesa();
    }
    
}
