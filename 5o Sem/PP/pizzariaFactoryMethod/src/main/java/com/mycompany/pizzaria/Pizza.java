/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaria;

import java.util.ArrayList;

/**
 *
 * @author igorp
 */
public abstract class Pizza {
    protected String nome;
    protected String massa;
    protected String molho;
    protected String temperatura;
    protected int tempo;
    ArrayList coberturas = new ArrayList();
    
    public void preparar(){
        System.out.println("Preparando "+ nome);
        System.out.println("Amassando "+ massa);
        System.out.println("Adicionando "+ molho);
        System.out.println("Temperatura "+ temperatura +" ºC");
        
        System.out.println("Adicionando coberturas: ");
        for(int i=0; i < coberturas.size(); i++){
            System.out.println(" "+ coberturas.get(i));
        }
    }
    
    public void assar(){
        System.out.println("Assando por"+ tempo + "minutos");
    }
    
    public void cortar(){
        System.out.println("Cortando a pizza em fatias");
    }
    
    public void embalar(){
        System.out.println("Colocando a pizza na caixa");
    }
    
    public String getNome() {
        return nome;
    }
}


