/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadorastrategy;

/**
 *
 * @author igorp
 */
public class Divisao implements CalcularStrategy {

    @Override
    public double calcular(double numA, double numB) {
        return numA / numB;
    }
    
}
