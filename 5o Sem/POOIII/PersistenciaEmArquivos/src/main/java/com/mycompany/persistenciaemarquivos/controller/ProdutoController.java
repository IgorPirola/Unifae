/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciaemarquivos.controller;

import com.mycompany.persistenciaemarquivos.model.Produto;
import com.mycompany.persistenciaemarquivos.model.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorp
 */
public class ProdutoController {
    
    public void grava(String cod, String desc, double preco, int estoque) throws IOException, SQLException{
        Produto produto = new Produto(cod, desc, preco, estoque);
        new ProdutoDAO("produtos.txt").grava(produto);
        new ProdutoDAO().gravaEmBanco(produto);
    }
    
    
}
