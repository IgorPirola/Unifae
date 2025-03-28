/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.logisticafactorymethod;

/**
 *
 * @author igorp
 */
public class LogisticaFactoryMethod {

    public static void main(String[] args) {
        Logistics log = new SeaLogistics();
        Transport tp = log.createTransport();
        tp.deliver();
        
        log = new RoadLogistics();
        tp = log.createTransport();
        tp.deliver();
        
    }
}
