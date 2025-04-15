/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transaction_bd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author igorp
 */
public class ContaDAO {
    private Connection con = null;
    
    private void conecta() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
    }
    
    void transferencia(int idOrigem, int idDestino, double valor){
        con.setAutoCommit(false);
        try{
            String sql = "Update Conta set saldo = saldo +?" + "where idConta = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setDouble(1, (-1)*valor);
            comando.setInt(2, idOrigem);
            comando.executeUpdate();

            comando.setDouble(1, valor);
            comando.setInt(2, idDestino);
            comando.executeUpdate();
            con.commit();
        } catch(SQLException e){
            con.rollback();
        } finally {
            con.setAutoCommit(true);
        }
        
    }
}
