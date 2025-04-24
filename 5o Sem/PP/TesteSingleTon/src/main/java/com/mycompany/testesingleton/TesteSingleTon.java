/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testesingleton;

/**
 *
 * @author igorp
 */
public class TesteSingleTon {

    public static void main(String[] args) {
        Singleton ob1 = Singleton.getInstance();
        Singleton ob2 = Singleton.getInstance();
        
        System.out.println(ob1);
        System.out.println(ob2);
    }
}
