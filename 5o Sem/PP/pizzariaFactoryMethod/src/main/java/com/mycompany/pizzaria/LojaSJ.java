/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaria;

/**
 *
 * @author igorp
 */
public class LojaSJ extends LojaPizza {

    @Override
    public Pizza criarPizza(String tipo) {
        return switch (tipo) {
            case "mussarela" -> new SJMussarela();
            case "marguerita" -> new SJMarguerita();
            default -> null;
        };
    }
    
}
