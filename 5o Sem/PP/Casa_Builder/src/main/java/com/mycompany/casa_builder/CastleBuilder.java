/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casa_builder;

/**
 *
 * @author igorp
 */
public class CastleBuilder implements Builder {
    private String wallType;
    private String windowType;
    private String doorType;
    
    @Override
    public void setWallType() {
        this.wallType = "Pedra";
    }

    @Override
    public void setWindowType() {
        this.windowType = "Ferro";
    }

    @Override
    public void setDoorType() {
        this.doorType = "Ferro";
    }
    
    public House getResult(){
        return new House(wallType, windowType, doorType);
    }
    
}
