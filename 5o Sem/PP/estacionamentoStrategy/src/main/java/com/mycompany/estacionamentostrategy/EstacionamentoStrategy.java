/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estacionamentostrategy;

/**
 *
 * @author igorp
 */
public class EstacionamentoStrategy {

    public static void main(String[] args) {
        TarifaEstacionamento te = new TarifaEstacionamento(30, new CalculoDiaria(11));
        
        System.out.println(te.valor());
        
    }
}
