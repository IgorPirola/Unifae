/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciaemarquivos.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author igorp
 */
public class ProdutoDAO {
    
    private String nomeArq = null;
    
    private Connection con = null;
    
    public ProdutoDAO() throws SQLException{
        if(con == null){
            Scanner leitor = new Scanner(System.in);
            String url = "jdbc:mysql://localhost:3306/POO3?useSSL=false&serverTimezone=UTC";
            String usr = "root";
            String senha = leitor.nextLine();
            leitor.nextLine();
            con = DriverManager.getConnection(url, usr, senha);
        }
    }
    
    public ProdutoDAO(String nomeArq){
        this.nomeArq = nomeArq;
    }
    
    public void grava(Produto produto) throws IOException{
        FileWriter arquivoSaida; //Objeto para o arquivo onde a escrita será realizada
        PrintWriter out; //Objeto para escrever
        arquivoSaida = new FileWriter(nomeArq, true); //Abertura do arquivo
        
        out = new PrintWriter(arquivoSaida);
        out.println(produto);
        
        out.close();
        arquivoSaida.close();
    }
    
    public void gravaTodos(Collection<Produto> produto){
    
    }
    public Produto recupera(String codigo) throws FileNotFoundException{
       FileReader arquivoIn = new FileReader("produtos.txt");
       Scanner leitor = new Scanner(arquivoIn);
       while(leitor.hasNext()){
           String cod = leitor.nextLine();
           String desc = leitor.nextLine();
           double preco = Double.parseDouble(leitor.nextLine());
           int quant = Integer.parseInt(leitor.nextLine());
           
           if(cod.equalsIgnoreCase(codigo)){
               return new Produto(cod, desc, preco, quant);
           }
       }
       return null;
    }
    public Collection<Produto> recuperaTodos() throws FileNotFoundException{
        return null;
    }
    
    public static void main(String[] args){
        /*
        try{
            ProdutoDAO dao = new ProdutoDAO("produtos.txt");
        
            Produto prod1 = dao.recupera("10");
            if (prod1 != null){
                JOptionPane.showMessageDialog(null, prod1);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }
            
        } catch (FileNotFoundException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Houve um erro na leitura");
        }
        
        */
        
        try{
            new ProdutoDAO();
            JOptionPane.showMessageDialog(null, "Conexão efetuada");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Reveja os paramêtros da conexão\n"+ ex.getMessage());
        }
        
    }
}
