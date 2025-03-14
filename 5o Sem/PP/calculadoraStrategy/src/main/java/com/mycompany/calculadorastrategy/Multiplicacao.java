package com.mycompany.calculadorastrategy;

/**
 *
 * @author igorp
 */
public class Multiplicacao implements CalcularStrategy {

    @Override
    public double calcular(double numA, double numB) {
        return numA * numB;
    }
    
}
