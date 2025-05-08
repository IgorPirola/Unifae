/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfacefuncional.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author igorp
 */
public class DAOAlunos {
    private List<Aluno> alunos = null;
    
    public DAOAlunos(){
        alunos = new ArrayList<Aluno>();
    }
    
    public boolean cadastra(Aluno aluno){
        return alunos.add(aluno);
    }
    
    public List<Aluno> getAlunos(){
        return alunos;
    }
    
    public String toString(int sort) {        
        TreeSet<Aluno> alunosAux ;
        if (sort == 1){ //ordena por ra
            alunosAux= new TreeSet();
        }
        else{ //ordena por nome            
            alunosAux = new TreeSet<Aluno>((a1,a2)->{
                return a1.getNome().compareToIgnoreCase(a2.getNome());
            });
        }
        alunosAux.addAll(alunos);
       
        StringBuffer buffer = new StringBuffer();
    
        for(Aluno aluno: alunosAux){
            buffer.append(aluno.toString());
        }
        return buffer.toString();
        
    }
    
    
}
