/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author android
 */
public class AlunoDAO {
    private Connection con = null;
    private String nomeArq = null;
    
    public AlunoDAO() throws SQLException{
        if(con == null){
            con = getConnection();
        }
    }
    
    public AlunoDAO(String nomeArq){
        this.nomeArq = nomeArq;
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
    }
    
    public void fecharBanco() throws SQLException{
        this.con.close();
    }
    
    public List<Aluno> recuperaTodos() throws FileNotFoundException{
        FileReader arquivoIn = new FileReader(this.nomeArq);
        Scanner leitor = new Scanner(arquivoIn);
        List<Aluno> alunos = new ArrayList<>();
        while(leitor.hasNext()){
            String idAluno = leitor.nextLine();
            String nome = leitor.nextLine();
            String ra = leitor.nextLine();
            
            alunos.add(new Aluno(Integer.parseInt(idAluno), nome, ra));
        }
        
        leitor.close();
        return alunos;
    }
    public Aluno mudarNome(String ra, String nome) throws SQLException{
        if(con!=null){
            String sql = "UPDATE Aluno SET nome = ? WHERE ra = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, ra);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                return new Aluno(nome, ra);
            }
            return null;
        }
        return null;
    }
    
}
