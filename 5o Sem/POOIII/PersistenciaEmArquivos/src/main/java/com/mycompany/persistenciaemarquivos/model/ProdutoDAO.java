/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciaemarquivos.model;

import com.mycompany.persistenciaemarquivos.controller.ProdutoController;
import com.mycompany.persistenciaemarquivos.infra.DatabaseConnection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
            con = DatabaseConnection.getConnection();
        }
    }
    
    
    public ProdutoDAO(String nomeArq){
        this.nomeArq = nomeArq;
    }
    
    public void gravaEmBanco(Produto prod) throws SQLException{
       if(con!=null){
           String sql = "insert into produto(codigo, descricao, valor, quantEstoque) values (?,?,?,?)";
           
           PreparedStatement comando = con.prepareStatement(sql);
           comando.setString(1, prod.getCodigo());
           comando.setString(2, prod.getDesc());
           comando.setDouble(3, prod.getValor());
           comando.setInt(4, prod.getQuantEstoque());
           comando.executeUpdate();
       } 
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
    
    public void gravaTodos(List<Produto> produtos) throws IOException{
        FileWriter arquivoSaida; //Objeto para o arquivo onde a escrita será realizada
        PrintWriter out; //Objeto para escrever
        arquivoSaida = new FileWriter(nomeArq, true); //Abertura do arquivo
        out = new PrintWriter(arquivoSaida);
        
        for(int i=0; i<produtos.size(); i++){
            out.println(produtos.get(i));
        }

        out.close();
        arquivoSaida.close();
    }
    
    public Produto recuperaEmBanco(String codigo) throws SQLException{
        if(con!=null){
            String sql="select codProd, descricao, valor, quantEstoque,"+ " codigo from produto where codProd = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, codigo);
            
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                Produto prod = new Produto();
                prod.setCodProd(resultado.getInt("codProd"));
                prod.setCodigo(resultado.getString("codigo"));
                prod.setDesc(resultado.getString("descricao"));
                prod.setValor(resultado.getDouble("valor"));
                prod.setQuantEstoque(resultado.getInt("quantEstoque"));
                
                return prod;
            }
        }
        return null;
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
    public List<Produto> recuperaTodos() throws FileNotFoundException{
        FileReader arquivoIn = new FileReader("produtos.txt");
        Scanner leitor = new Scanner(arquivoIn);
        List<Produto> produtos = new ArrayList<>();
        while(leitor.hasNext()){
            String cod = leitor.nextLine();
            String desc = leitor.nextLine();
            double preco = Double.parseDouble(leitor.nextLine());
            int quant = Integer.parseInt(leitor.nextLine());
            
            produtos.add(new Produto(cod, desc, preco, quant));
       }
       return produtos;
    }
    
    public void fechaConexao() throws SQLException{
        con.close();
    }
    
    public static void main(String[] args){
//        try{
//            ProdutoDAO dao = new ProdutoDAO("produtos.txt");
//        
//            List<Produto> prod1 = new ArrayList<>();
//            prod1.add(new Produto("3", "leite", 5.0, 10));
//            prod1.add(new Produto("4", "pizza", 45.0, 8));
//            
//            dao.gravaTodos(prod1);
//            JOptionPane.showMessageDialog(null, "Produto Cadastrado");
//            if (prod1 != null){
//                for(int i=0; i<prod1.size(); i++){
//                    JOptionPane.showMessageDialog(null, prod1.get(i));
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Produto não encontrado");
//            }
            
//        } catch (IOException e){
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
//            JOptionPane.showMessageDialog(null, "Houve um erro na leitura");
//        }
        
        
        try{
            Produto prod = new ProdutoDAO().recuperaEmBanco("14");
                        
            JOptionPane.showMessageDialog(null, prod==null?"Não há produto com esse codigo":prod);
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Reveja os paramêtros da conexão\n"+ ex.getMessage());
        }
        
    }
}
