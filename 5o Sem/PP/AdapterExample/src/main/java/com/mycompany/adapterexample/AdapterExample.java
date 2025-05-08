/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adapterexample;

/**
 *
 * @author igorp
 */
public class AdapterExample {

    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
        
        XmlParser adapter = new XmlToJsonParser(jsonParser);
        
        adapter.parseXml("<data>2025-05-07</data>");
    }
}
