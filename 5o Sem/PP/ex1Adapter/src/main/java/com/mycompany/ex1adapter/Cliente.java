/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex1adapter;

/**
 *
 * @author igorp
 */
public class Cliente {

    public static void main(String[] args) {        
        if (new Cpf_Adapter().isAValideCpf("111.111.111-2")){
            System.out.println("CPF Valido");
        } else {
            System.err.println("CPF Invalido");
        }
        
    }
}
