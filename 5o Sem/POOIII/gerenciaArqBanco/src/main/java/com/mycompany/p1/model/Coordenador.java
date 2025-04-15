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
public class Coordenador {
    private int idCoordenador;
    private String nome;
    private String titulacao;

    public Coordenador(int idCoordenador, String nome, String titulacao) {
        this.idCoordenador = idCoordenador;
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public Coordenador() {
    }

    public int getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(int idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCoordenador;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.titulacao);
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
        final Coordenador other = (Coordenador) obj;
        if (this.idCoordenador != other.idCoordenador) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.titulacao, other.titulacao);
    }

    @Override
    public String toString() {
        return " "+ idCoordenador + " - " +
                nome + " - " +
                titulacao + " ";
    }
    
    
}
