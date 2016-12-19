
package br.com.FINAL.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    
    private static Connection con = null;
    
    public static Connection conectar(){
        //Cria as variáveis de conexão
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/f.i.n.a.l";
        String usuario = "root";
        String senha = "root";

        try { //Registra o driver do SGDB MySQL
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();    
        }        
        try { //Realiza a conexão com o MYSQL
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();         
            return null;
        }
    }
}

