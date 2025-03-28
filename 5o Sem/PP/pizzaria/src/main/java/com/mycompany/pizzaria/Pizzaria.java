/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pizzaria;

/**
 *
 * @author igorp
 */
public class Pizzaria {

    public static void main(String[] args) {
        LojaPizza lojaSJ = new LojaSJ();
        LojaPizza lojaPocos = new LojaPocos();
        
        Pizza pizza = lojaSJ.orderPizza("mussarela");
        System.out.println("---"+ pizza.getNome() + "---");

        pizza = lojaPocos.orderPizza("marguerita");
        System.out.println("---"+ pizza.getNome() + "---");
    }
}
