/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.singletonecommerce;

/**
 *
 * @author igorp
 */
public class SingletonEcommerce {

    public static void main(String[] args) {
        SistemaDeLog logger = SistemaDeLog.getInstancia();
        
        logger.registrarLog("item adicionado ao carrinho: Produto XYZ", "INFO");
        logger.registrarLog("Pagamento processado com sucesso", "INFO");
        
        try{
            throw new RuntimeException("Erro ao carregar a imagem do produto");
        } catch(RuntimeException e){
            logger.registrarLog(e.getMessage(), "ERRO");
        }
        
        logger.desativarLogs();
        logger.registrarLog("esta msg não será registrada", "debug");
        
        logger.ativarLogs();
        logger.registrarLog("esta msg será registrada", "debug");
        
        logger.finalizar();
    }
}
