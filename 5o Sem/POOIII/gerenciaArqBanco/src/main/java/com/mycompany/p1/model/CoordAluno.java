/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.model;

/**
 *
 * @author android
 */
public class CoordAluno {
    private int idCoordenador;
    private int idAluno;

    public CoordAluno(int idCoordenador, int idAluno) {
        this.idCoordenador = idCoordenador;
        this.idAluno = idAluno;
    }

    public CoordAluno() {
    }

    public int getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(int idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCoordenador;
        hash = 67 * hash + this.idAluno;
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
        final CoordAluno other = (CoordAluno) obj;
        if (this.idCoordenador != other.idCoordenador) {
            return false;
        }
        return this.idAluno == other.idAluno;
    }

    @Override
    public String toString() {
        return idCoordenador + "\n" + 
                idAluno;
    }
    
    
}
