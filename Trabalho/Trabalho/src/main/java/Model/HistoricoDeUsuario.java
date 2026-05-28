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
    
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
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
        // verifica se eh nulo
        if (nome_usuario == null || senha == null) {
            return false;
        }
        
        //verifica se eh vazio
        if (nome_usuario.isEmpty() || senha.isEmpty()) {
            return false;
        }
        
         return true;
    }

    public Usuario cadastrarUsuario(String nome_usuario, String senha, int nivel_usuario) {
        // verifica qual tipo de usuario sera criado
        Usuario usuario = null;
        switch (nivel_usuario) {
            case 0:
                usuario = new Administrador(nome_usuario, senha, nivel_usuario);
                break;
            case 1:
                usuario = new GestorFinanceiro(nome_usuario, senha, nivel_usuario);
                break;
            case 2:
                usuario = new Operador(nome_usuario, senha, nivel_usuario);
                break;
        }
        
        usuarios.add(usuario);
        
        return usuario;
    }

    public void listarUsuarios() {
        
    }

    public void excluirUsuario(int id_usuario) {
        
    }
}
