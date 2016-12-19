/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.DAO;

import java.util.List;

/**
 *
 * @author BRUNO
 * @param <E>
 */
public interface CrudDAO <E>{//O E vai representar nossa Entity, vinda do model
    public boolean salvar(E entidade);
    public boolean deletar(int entidade);
    public boolean alterar(E entidade);
    public List<E> carregar();    
}
