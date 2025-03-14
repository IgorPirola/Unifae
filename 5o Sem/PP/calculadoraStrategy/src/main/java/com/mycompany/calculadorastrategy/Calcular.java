package com.mycompany.calculadorastrategy;

/**
 *
 * @author igorp
 */
public class Calcular {
    private CalcularStrategy strategy;
    
    public void setStrategy(CalcularStrategy strategy){
        this.strategy = strategy;
    } 
    
    public double calcular(double numA, double numB){
        return strategy.calcular(numA, numB);
    }
}
