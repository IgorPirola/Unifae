/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lojamobiliaabstractfactory;

/**
 *
 * @author igorp
 */
public interface FurnitureFactory {
    public Chair createChair();
    public Sofa createSofa();
    public CoffeeTable createCoffeeTable();
}
