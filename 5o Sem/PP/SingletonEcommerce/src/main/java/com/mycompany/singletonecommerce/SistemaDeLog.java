/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singletonecommerce;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author igorp
 */
public class SistemaDeLog {
    
    private static SistemaDeLog instancia;
    private FileWriter arquivoLog;
    private boolean logsAtivados = true;
    private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    private SistemaDeLog(){
        try{
            File arq = new File("aplicacao.log");
            arquivoLog = new FileWriter(arq, true);
        } catch (IOException e){
            System.err.println("Erro: \n" + e.getMessage());
        }
    }
    
    public static SistemaDeLog getInstancia(){
        if(instancia == null){
            instancia = new SistemaDeLog();
        }
        return instancia;
    }
    
    public void registrarLog(String mensagem, String nivel){
        if (!logsAtivados)
            return;
        
        /*
        [%s]: [data/hora]
        %s: nivel do log (DEBUG, INFO, ...)
        %s: mensagem
        %n: quebra de linha
        */
        String logFormatado = String.format(
            "[%s] %s: %s%n",
                LocalDateTime.now().format(formatador),
                nivel.toUpperCase(),
                mensagem,
                "\n"
        );
        
        try{
            arquivoLog.write(logFormatado);
            arquivoLog.flush();
        }catch(IOException e){
            System.err.println("Erro: \n" + e.getMessage());
            
        }
    }
    
    public void ativarLogs(){
        this.logsAtivados = true;
    }
    
    public void desativarLogs(){
        this.logsAtivados = false;
    }
    
    public void finalizar(){
        try{
            if(arquivoLog != null){
                arquivoLog.close();
            }
        } catch(IOException e){
            System.err.println("Erro: \n"+ e.getMessage());
        }
        
        
    }
}
