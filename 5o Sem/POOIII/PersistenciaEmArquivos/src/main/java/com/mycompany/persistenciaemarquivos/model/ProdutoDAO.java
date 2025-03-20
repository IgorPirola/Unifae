/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciaemarquivos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 *
 * @author igorp
 */
public class ProdutoDAO {
    
    private String nomeArq = null;
    
    public ProdutoDAO(String nomeArq){
        this.nomeArq = nomeArq;
    }
    
    public void grava(Produto produto) throws IOException{
        FileWriter arquivoSaida; //Objeto para o arquivo onde a escrita será realizada
        PrintWriter out; //Objeto para escrever
        arquivoSaida = new FileWriter(nomeArq); //Abertura do arquivo
        
        out = new PrintWriter(arquivoSaida);
        out.println(produto);
        
        out.close();
        arquivoSaida.close();
    }
    
    public void gravaTodos(Collection<Produto> produto){
    
    }
    public Produto recupera(String codigo){
       return null; 
    }
    public Collection<Produto> recuperaTodos(){
        return null;
    }
}
