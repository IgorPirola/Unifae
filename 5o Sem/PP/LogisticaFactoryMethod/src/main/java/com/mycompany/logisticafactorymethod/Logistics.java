/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logisticafactorymethod;

/**
 *
 * @author igorp
 */
public abstract class Logistics {
    public Transport planDelivery(){
        Transport t = this.createTransport();
        return t;
    }
    
    public abstract Transport createTransport();
}
