/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author android
 */
public class CoordenadorDAO {
    public List<Coordenador> recuperaTodos() throws FileNotFoundException{
        FileReader arquivoIn = new FileReader("coordenador.txt");
        Scanner leitor = new Scanner(arquivoIn);
        List<Coordenador> coordenadores = new ArrayList<>();
        while(leitor.hasNext()){
            int idCoordenador = Integer.parseInt(leitor.nextLine());
            String nome = leitor.nextLine();
            String titulacao = leitor.nextLine();
            
            coordenadores.add(new Coordenador(idCoordenador, nome, titulacao));
       }
        leitor.close();
        return coordenadores;
    }
}
