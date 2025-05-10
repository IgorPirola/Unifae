/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1adapter;

import br.com.caelum.stella.validation.CPFValidator;

/**
 *
 * @author igorp
 */
public class Cpf_Adapter implements ProtocoloDeValidacaoDeCpf {

    @Override
    public boolean isAValideCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator(); 
        try{ cpfValidator.assertValid(cpf); 
            return true; 
        }catch(Exception e){ 
            return false; 
        } 
         
    }
    
}
