/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factorymethod;

/**
 *
 * @author igorp
 */
public class FactoryMethod {

    public static void main(String[] args) {
        
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        product.print();
        creator.createShow();
    }
}
