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
public class CoordAlunoDAO {
    public List<CoordAluno> recuperaTodos() throws FileNotFoundException{
        FileReader arquivoIn = new FileReader("coordAluno.txt");
        Scanner leitor = new Scanner(arquivoIn);
        List<CoordAluno> coordAluno = new ArrayList<>();
        while(leitor.hasNext()){
            int idAluno = Integer.parseInt(leitor.nextLine());
            int idCoordenador = Integer.parseInt(leitor.nextLine());
            
            coordAluno.add(new CoordAluno(idCoordenador, idAluno));
       }
        return coordAluno;
    }
}
