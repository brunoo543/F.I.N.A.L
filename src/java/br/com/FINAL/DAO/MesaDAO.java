/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.DAO;

import br.com.FINAL.Entity.Mesa;
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

/**
 *
 * @author BRUNO
 */
public class MesaDAO implements CrudDAO<Mesa>{    
    
    private Connection con;

    @Override
    public boolean salvar(Mesa mesa) {
        String sql = "insert into mesa "
                + "(numero_mesa) "
                + "values (?)";
        try {
            con = BancoDados.conectar();
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, mesa.getNumeroMesa());
            p.execute();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    @Override
    public boolean deletar(int i) {
          String sql = "delete from mesa where id = ?";
        try {
            PreparedStatement p = conectar().prepareStatement(sql);
            p.setInt(1,i);
            p.execute();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean alterar(Mesa entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mesa> carregar() {
        try {
            con = BancoDados.conectar();
            PreparedStatement ps = con.prepareStatement("select * from mesa");
            ResultSet resultSet = ps.executeQuery();
            List<Mesa> Array = new ArrayList<>();
            while (resultSet.next()) {
                Mesa mesa=  new Mesa();
                mesa.setId(resultSet.getInt("id"));
                mesa.setNumeroMesa(resultSet.getInt("numero_mesa"));
                Array.add(mesa);
            }
            con.close();
            return Array;
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
    }

