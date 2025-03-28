/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaria;

/**
 *
 * @author igorp
 */
public class LojaPocos extends LojaPizza{
    
    @Override
    public Pizza criarPizza(String tipo) {
        return switch (tipo) {
            case "mussarela" -> new PocosMussarela();
            case "marguerita" -> new PocosMarguerita();
            default -> null;
        };
    }
}
