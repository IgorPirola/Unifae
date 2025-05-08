/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interfacefuncional;

import com.mycompany.interfacefuncional.controller.ControllerAluno;

/**
 *
 * @author igorp
 */
public class InterfaceFuncional {

    public static void main(String[] args) {
        ControllerAluno.cadastra("123","Maria Luiza");
        ControllerAluno.cadastra("321","Igor");
         
        System.out.println(ControllerAluno.getAlunos(1));
    }
}
