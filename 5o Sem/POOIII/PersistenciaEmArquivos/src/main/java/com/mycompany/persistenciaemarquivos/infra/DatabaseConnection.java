/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistenciaemarquivos.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author igorp
 */
public class DatabaseConnection {
    private static Properties props = new Properties();
    
    static {
        try (InputStream input = new FileInputStream("db.properties")){
            props.load(input);
        } catch(IOException e){
            throw new RuntimeException("Erro ao ler config do banco", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("usuario"),
                props.getProperty("senha")
        );
    }
    
}
