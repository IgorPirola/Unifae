package com.mycompany.calculadorastrategy;

/**
 *
 * @author igorp
 */
public class CalculadoraStrategy {

    public static void main(String[] args) {
        double numA = 6;
        double numB = 12;
        
        Calcular calcular = new Calcular();
        calcular.setStrategy(new Adicao());
        System.out.println("Adição: " + calcular.calcular(numA, numB));
        
        calcular.setStrategy(new Divisao());
        System.out.println("Divisão: " + calcular.calcular(numA, numB));
        
        calcular.setStrategy(new Subtracao());
        System.out.println("Subtração: " + calcular.calcular(numA, numB));
        
        calcular.setStrategy(new Multiplicacao());
        System.out.println("Multiplicação: " + calcular.calcular(numA, numB));
    }
}
