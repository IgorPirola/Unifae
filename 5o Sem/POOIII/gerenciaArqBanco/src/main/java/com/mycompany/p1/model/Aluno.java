/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.model;

import java.util.Objects;

/**
 *
 * @author android
 */
public class Aluno {
    private int idAluno;
    private String nome;
    private String ra;

    public Aluno(int idAluno, String nome, String ra) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.ra = ra;
    }
    
    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idAluno;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.ra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.idAluno != other.idAluno) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.ra, other.ra);
    }

    @Override
    public String toString() {
        return idAluno + " - " +
                nome + " - " +
                ra + " ";
    }
    
    
}
