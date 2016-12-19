/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.DAO;

import br.com.FINAL.Entity.Categoria;
import br.com.FINAL.Util.BancoDados;
import static br.com.FINAL.Util.BancoDados.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoriaDAO implements CrudDAO<Categoria>{
    private Connection con;

    @Override
    public boolean salvar(Categoria entidade) {
       String sql = "insert into categorias "
                + "(nome) "
                + "values (?)";
        try {
            con = BancoDados.conectar();
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, entidade.getNome());
            p.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    

    @Override
    public boolean alterar(Categoria entidade) {
        return true;
    }
    
    @Override
    public List<Categoria> carregar() {
         try {
            con = BancoDados.conectar();
            PreparedStatement ps = con.prepareStatement("select * from categorias");
            ResultSet resultSet = ps.executeQuery();
            List<Categoria> Array = new ArrayList<>();
            while (resultSet.next()) {
                Categoria mesa=  new Categoria();
                mesa.setId(resultSet.getInt("id"));
                mesa.setNome(resultSet.getString("nome"));
                Array.add(mesa);
            }
            con.close();
            return Array;
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  

    @Override
    public boolean deletar(int i) {
          String sql = "delete from mesa where id = ?";
        try {
            PreparedStatement p = conectar().prepareStatement(sql);
            p.setInt(1, i);
            p.execute();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    }
