/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorymethod;

/**
 *
 * @author igorp
 */
public class ConcreteCreator extends Creator{

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
    
}
