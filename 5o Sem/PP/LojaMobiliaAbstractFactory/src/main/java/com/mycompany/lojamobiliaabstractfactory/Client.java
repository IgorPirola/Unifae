/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lojamobiliaabstractfactory;

/**
 *
 * @author igorp
 */
public class Client {

    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        
        Chair chair = factory.createChair();
        chair.exibir();
        
        Sofa sofa = factory.createSofa();
        sofa.exibir();
        
        System.out.println("");
        
        factory = new VictorianFurnitureFactory();
        
        chair = factory.createChair();
        chair.exibir();
        
        CoffeeTable coffeeTable = factory.createCoffeeTable();
        coffeeTable.exibir();
    }
}
