/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transaction_bd.model;

/**
 *
 * @author igorp
 */
public class Conta {
    private int idConta;
    private double saldo;

    public Conta(int idConta, double saldo) {
        this.idConta = idConta;
        this.saldo = saldo;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idConta;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
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
        final Conta other = (Conta) obj;
        if (this.idConta != other.idConta) {
            return false;
        }
        return Double.doubleToLongBits(this.saldo) == Double.doubleToLongBits(other.saldo);
    }

    @Override
    public String toString() {
        return "Conta{" + "idConta=" + idConta + ", saldo=" + saldo + '}';
    }
    
    
}
