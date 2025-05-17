/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comercioeletronicoobserver;

import java.util.ArrayList;


/**
 *
 * @author igorp
 */
public class Loja implements Subject {
    private ArrayList<Observer> observers;
    private String nome; // produto
    
    public Loja(){
        observers = new ArrayList<>();
    }
    
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer){
        int i = observers.indexOf(observer);
        
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        System.out.println("Item "+ nome + " agora está dosponivel na loja.");
        
        for(Observer o : observers){
            o.update(nome);
        }
    }
    
    public void setNovoProduto(String nome){
        this.nome = nome;
        notifyObserver();
    }
}
