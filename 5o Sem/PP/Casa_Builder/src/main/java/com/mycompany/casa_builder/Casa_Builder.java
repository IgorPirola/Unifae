/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.casa_builder;

/**
 *
 * @author igorp
 */
public class Casa_Builder {

    public static void main(String[] args) {
        Director director = new Director();
        
        HutBuilder hutBuilder = new HutBuilder();
        director.buildHouse(hutBuilder);
        
        House house = hutBuilder.getResult();
        System.out.println(house.print());
        
        
        CastleBuilder castleBuilder = new CastleBuilder();
        director.buildHouse(castleBuilder);
        
        house = castleBuilder.getResult();
        System.out.println(house.print());
        
        
        NormalBuilder normalBuilder = new NormalBuilder();
        director.buildHouse(normalBuilder);
        
        house = normalBuilder.getResult();
        System.out.println(house.print());
    }
}
