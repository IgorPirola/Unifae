package com.mycompany.persistenciaemarquivos.model;

import java.util.Objects;

/**
 *
 * @author igorp
 */
public class Produto {
    private String codigo;
    private String desc;
    private double valor;
    private int quantEstoque;
    private int codProd;

    public Produto(String codigo, String desc, double valor, int quantEstoque) {
        this.codigo = codigo;
        this.desc = desc;
        this.valor = valor;
        this.quantEstoque = quantEstoque;
    }
    
    public Produto(){};

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.desc);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 67 * hash + this.quantEstoque;
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
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.quantEstoque != other.quantEstoque) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.desc, other.desc);
    }

    @Override
    public String toString() {
        return codProd + "\n" +
               codigo + "\n" + 
               desc + "\n" + 
               valor + "\n" +
               quantEstoque;
    }
    
}
