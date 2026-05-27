/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vinícius Mardegan
 */
public class GestorFinanceiro extends Usuario {
    private int nivel_usuario;

    public GestorFinanceiro() {
    }

    public GestorFinanceiro(int id_usuario, String nome_usuario, String senha) {
        super(id_usuario, nome_usuario, senha);
    }

    public int getNivel_usuario() {
        return nivel_usuario;
    }

    public void setNivel_usuario(int nivel_usuario) {
        this.nivel_usuario = nivel_usuario;
    }
    
}
