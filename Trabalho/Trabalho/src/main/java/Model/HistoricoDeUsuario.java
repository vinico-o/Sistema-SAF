/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Vinícius Mardegan
 */
public class HistoricoDeUsuario {
    
    private ArrayList<Usuario> usuarios;
    int contador = 0;

    public HistoricoDeUsuario() {
        
    }

    public HistoricoDeUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public Usuario buscarNomeUsuario(String nome_usuario) {
        return null;
    }

    public void atualizarDados(String nome_usuario, String senha) {
        
    }

    public Boolean validarSenha(String senha) {
        return null;
    }

    public Boolean validarInformacoes(String nome_usuario, String senha) {
        return null;
    }

    public Usuario criar(String nome_usuario, String senha, int nivel_usuario) {
        return null;
    }

    public void listarUsuarios() {
        
    }

    public void excluirUsuario(int id_usuario) {
        
    }
}
