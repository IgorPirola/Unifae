/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.controller;

import com.mycompany.p1.model.Aluno;
import com.mycompany.p1.model.AlunoDAO;
import com.mycompany.p1.model.CoordAluno;
import com.mycompany.p1.model.CoordAlunoDAO;
import com.mycompany.p1.model.Coordenador;
import com.mycompany.p1.model.CoordenadorDAO;
import com.mycompany.p1.model.GerenciaMap;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class GerenciaController {
    private GerenciaMap gerenciaMap;
    private AlunoDAO alunoDAO;

    public GerenciaController() {
        this.gerenciaMap = new GerenciaMap();
        
        try{
           this.alunoDAO = new AlunoDAO(); 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco\n"+ e.getMessage());
        }
        
    }

    public void gerenciaArquivo() {
        this.alunoDAO = new AlunoDAO("alunos.txt");
        CoordenadorDAO coordDAO = new CoordenadorDAO();
        CoordAlunoDAO CoordAlunoDAO = new CoordAlunoDAO();

        try {
            List<Aluno> alunos = alunoDAO.recuperaTodos();
            List<Coordenador> coordenadores = coordDAO.recuperaTodos();
            List<CoordAluno> relacoes = CoordAlunoDAO.recuperaTodos(); 
            gerenciaMap.cadastro(alunos, coordenadores, relacoes);
        } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler os arquivos de texto\n"+ e.getMessage());
        }
    }
    
    public Aluno puxarBanco(String ra, String nome){
        try {
            return this.alunoDAO.mudarNome(ra, nome);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar no banco\n"+ e.getMessage());
        }
        return null;
    }
 
    public void fecharBanco(){
        try{
            this.alunoDAO.fecharBanco();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco\n"+ e.getMessage());
        }
        
    }

    public Map<Aluno, Coordenador> getAssociacoes() {
        return gerenciaMap.getAssoc();
    }
}
