/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comercioeletronicoobserver;

/**
 *
 * @author igorp
 */
public class Cliente implements Observer{
    private String email;
    
    public Cliente(String email){
        this.email = email;
    }
    
    @Override
    public void update(String nome){
        System.out.println("Enviando email para o cliente: "+ email +" sobre o produto "+ nome);
    }
}
