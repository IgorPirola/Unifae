/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casa_builder;

/**
 *
 * @author igorp
 */
public class House {
    private String wallType;
    private String windowType;
    private String doorType;

    public House(String wallType, String windowType, String doorType) {
        this.wallType = wallType;
        this.windowType = windowType;
        this.doorType = doorType;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public String getWindowType() {
        return windowType;
    }

    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

    public String getDoorType() {
        return doorType;
    }

    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }
    
    public String print(){
        String info = "";
        info += "Tipo de parede: " + this.wallType + "\n";
        info += "Tipo de janela: " + this.windowType + "\n";
        info += "Tipo de porta: " + this.doorType + "\n";
        
        return info;
    }
}
