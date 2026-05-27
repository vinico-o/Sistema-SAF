/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vinícius Mardegan
 */
public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String senha;
    private int nivel_usuario;

    public Usuario() {
    }
    
    public Usuario(int id_usuario, String nome_usuario, String senha, int nivel_usuario) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.nivel_usuario = nivel_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel_usuario() {
        return nivel_usuario;
    }

    public void setNivel_usuario(int nivel_usuario) {
        this.nivel_usuario = nivel_usuario;
    }
    
}
