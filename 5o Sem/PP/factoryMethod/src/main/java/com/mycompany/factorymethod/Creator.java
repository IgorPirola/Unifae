/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.factorymethod;

/**
 *
 * @author igorp
 */
public abstract class Creator {
    
    public void createShow(){
        Product product = this.factoryMethod();
        System.out.println(product);
    }
    
    public abstract Product factoryMethod();
}
