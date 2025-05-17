/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aulaOptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author igorp
 */
public class Pessoa {
    private String name;
    private String cpf;

    public Pessoa(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "name=" + name + ", cpf=" + cpf + '}';
    }
    
    public static void main(String[] args){
        List<String> nomes = new ArrayList<>();
        nomes.add("Igor");
        nomes.add("João");
        nomes.add(null);
        
        for (String nome : nomes){
            Optional<String> aux = Optional.ofNullable(nome);
            aux.ifPresent(System.out::println);
        }
    }
}
