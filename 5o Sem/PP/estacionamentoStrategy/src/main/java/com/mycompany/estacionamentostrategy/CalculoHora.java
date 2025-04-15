/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estacionamentostrategy;

/**
 *
 * @author igorp
 */
public class CalculoHora implements Calculo{
    private float valorHora;

    public CalculoHora(float valorHora) {
        this.valorHora = valorHora;
    }
    
    @Override
    public float calcularTarifa(int qtdHoras) {
        return qtdHoras * valorHora;
    }
    
}
