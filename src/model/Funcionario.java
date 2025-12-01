/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mari
 */
public class Funcionario {
    private int idFunc;
    private String nome;
    private String turno;

    public Funcionario() {}

    public Funcionario(int idFunc, String nome, String turno) {
        this.idFunc = idFunc;
        this.nome = nome;
        this.turno = turno;
    }
    
    public int getIdFunc() { return idFunc; }
    public void setIdFunc(int idFunc) { this.idFunc = idFunc; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    @Override
    public String toString() {
        return idFunc + " - " + nome + " (" + turno + ")";
    }
}
