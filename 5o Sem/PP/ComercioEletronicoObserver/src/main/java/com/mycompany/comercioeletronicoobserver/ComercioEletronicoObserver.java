/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comercioeletronicoobserver;

/**
 *
 * @author igorp
 */
public class ComercioEletronicoObserver {

    public static void main(String[] args) {
        Loja loja = new Loja();
        
        Cliente c1 = new Cliente("rogerio.colpani@prof.fae.br");
        Cliente c2 = new Cliente("joao.ressoni@sou.fae.br");
        
        loja.addObserver(c1);
        loja.addObserver(c2);
        
        loja.setNovoProduto("Iphone 17");
        System.out.println("");
        
        loja.removeObserver(c2);
        
        loja.setNovoProduto("Notebook Dell");
    }
}
