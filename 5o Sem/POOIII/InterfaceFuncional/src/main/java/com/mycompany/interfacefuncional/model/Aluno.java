/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfacefuncional.model;

import java.util.Objects;

/**
 *
 * @author igorp
 */
public class Aluno implements Comparable<Aluno>{
    private String ra;
    private String nome;
    
    public Aluno(){
    
    }

    public Aluno(String ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" + "ra=" + ra + ", nome=" + nome + "}\n";
    }

    @Override
    public int hashCode() {
        return ra.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Aluno){
                return this.ra.equals(((Aluno)obj).ra);
            }
            return false;
        }
        return false;
    }

    @Override
    public int compareTo(Aluno o) {
        return ra.compareTo(o.ra);
    }
    
    
}
