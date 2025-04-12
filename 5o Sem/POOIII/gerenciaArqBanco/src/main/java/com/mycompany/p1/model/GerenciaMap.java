/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author android
 */
public class GerenciaMap {
    private final TreeMap<Aluno, Coordenador> associacao;

    public GerenciaMap() {
        this.associacao = new TreeMap<>(Comparator.comparingInt(Aluno::getIdAluno));
    }
    
    public void cadastro(List<Aluno> alunos, List<Coordenador> coords, List<CoordAluno> relacoes){
        Map<Integer, Aluno> mapaAlunos = new HashMap<>();
        Map<Integer, Coordenador> mapaCoords = new HashMap<>();

        for (Aluno a : alunos) {
            mapaAlunos.put(a.getIdAluno(), a);
        }

        for (Coordenador c : coords) {
            mapaCoords.put(c.getIdCoordenador(), c);
        }

        for (CoordAluno rel : relacoes) {
            Aluno aluno = mapaAlunos.get(rel.getIdAluno());
            Coordenador coord = mapaCoords.get(rel.getIdCoordenador());

            if (aluno != null && coord != null) {
                associacao.put(aluno, coord);
            }
        }
    }
    
    public Map<Aluno, Coordenador> getAssoc(){
        return associacao;
    }
}
