/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estacionamentostrategy;

/**
 *
 * @author igorp
 */
public class TarifaEstacionamento {
    private int qtdHoras;
    private Calculo calculo;
    
    public TarifaEstacionamento(int qtdHoras, Calculo calculo){
        this.qtdHoras = qtdHoras;
        this.calculo = calculo;
    }
    
    public float valor(){
        return calculo.calcularTarifa(qtdHoras);
    }
}
