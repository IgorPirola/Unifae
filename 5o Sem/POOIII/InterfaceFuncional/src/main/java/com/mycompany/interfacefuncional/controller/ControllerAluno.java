/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfacefuncional.controller;

import com.mycompany.interfacefuncional.model.Aluno;
import com.mycompany.interfacefuncional.model.DAOAlunos;

/**
 *
 * @author igorp
 */
public class ControllerAluno {
    private static DAOAlunos dao = new DAOAlunos();
    
    public static boolean cadastra(String ra, String nome){
        Aluno aluno = new Aluno(ra, nome);
        return dao.cadastra(aluno);
    }
    
    public static String getAlunos(int sort){
        return dao.toString(sort);
    }
}
