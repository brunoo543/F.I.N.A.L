/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FINAL.DAO;

import br.com.FINAL.Entity.Mesa;
import br.com.FINAL.Entity.Produto;
import br.com.FINAL.Util.BancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO implements CrudDAO<Produto>{
    
    private Connection con;

    @Override
    public List<Produto> carregar() {
        try {
            con = BancoDados.conectar();
            PreparedStatement ps = con.prepareStatement("select * from produtos");
            ResultSet resultSet = ps.executeQuery();
            List<Produto> Array = new ArrayList<>();
            while (resultSet.next()) {
                Produto prod=  new Produto();
                prod.setId(resultSet.getInt("id"));
                prod.setNomeProduto(resultSet.getString("nome"));
                prod.setPreco(resultSet.getDouble("preco"));
                prod.setCodCategoria(resultSet.getInt("categoria_id"));
                Array.add(prod);
            }
            con.close();
            return Array;
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean salvar(Produto produto) {
        String sql = "insert into produtos "
                + "(nome,preco,categoria_id) "
                + "values (?,?,?)";
        try {
            con = BancoDados.conectar();
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, produto.getNomeProduto());
            p.setDouble(2, produto.getPreco());
            p.setInt(3, produto.getCodCategoria());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Produto entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
