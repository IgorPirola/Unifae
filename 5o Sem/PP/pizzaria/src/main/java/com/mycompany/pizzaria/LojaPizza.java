/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaria;

/**
 *
 * @author igorp
 */
public abstract class LojaPizza {
    
    public Pizza orderPizza(String tipo){
        Pizza pizza;
        pizza = criarPizza(tipo);
        
        pizza.preparar();
        pizza.assar();
        pizza.cortar();
        pizza.embalar();
        
        return pizza;
    }
    
    public abstract Pizza criarPizza(String tipo);
}
