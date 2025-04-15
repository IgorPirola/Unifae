/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estacionamentostrategy;

/**
 *
 * @author igorp
 */
public class CalculoDiaria implements Calculo{
    private float valorDiaria;
    
    public CalculoDiaria(float valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    
    @Override
    public float calcularTarifa(int qtdHoras){
        return valorDiaria * (int)Math.ceil(qtdHoras / 24.0f);
    }
}
