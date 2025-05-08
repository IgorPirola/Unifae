/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adapterexample;

/**
 *
 * @author igorp
 */
public class XmlToJsonParser implements XmlParser{
    private JsonParser jsonParser;
    
    public XmlToJsonParser(JsonParser jsonParser){
        this.jsonParser = jsonParser;
    }
    
    @Override
    public void parseXml(String xml){
        String json = convertXmlToJson(xml);
        
        jsonParser.parseJson(json);
    }
    
    private String convertXmlToJson(String xml){
        return " { \"data\": \"" + xml.replaceAll("<[^>]+>", "") + "\" } ";
    }
}
