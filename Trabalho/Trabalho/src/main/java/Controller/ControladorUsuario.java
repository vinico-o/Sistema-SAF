/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.UsuarioDAO;
import Model.HistoricoDeUsuario;
import Model.Sessao;
import Model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Vinícius Mardegan
 */
public class ControladorUsuario {

    public void editarInformacoes(String nome_usuario, String senha, int nivel_usuario, int id_usuario) {
        HistoricoDeUsuario historicoDeClubes = new HistoricoDeUsuario();
        historicoDeClubes.atualizarDados(nome_usuario, senha, nivel_usuario, id_usuario);
    }
    
    //Talvez tenha um jeito melhor de fazer isso, mas coloquei do jeito que esta no diagrama de colaboracao
    //tem que trocar o metodo para passar o usuario e senha
    public boolean autenticarUsuario(String nome_usuario, String senha) {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();
        
        Usuario usuario = new Usuario();
        usuario = historicoDeUsuario.buscarNomeUsuario(nome_usuario);
        if(usuario == null) {
            return false;
        }
        
        boolean validacao = historicoDeUsuario.validarSenha(usuario, senha);
        if(validacao == false) {
            return false;
        }
        
        Sessao.iniciarSessao(usuario);
        return true;
        
    }

   public Boolean cadastrarUsuario(String nome_usuario, String senha, int nivel_usuario) {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();


        boolean validacao = historicoDeUsuario.validarInformacoes(nome_usuario, senha);

        if (validacao) { 

            if (UsuarioDAO.existeNomeUsuario(nome_usuario)) {
                return false; 
            }

            Usuario usuario = historicoDeUsuario.cadastrarUsuario(nome_usuario, senha, nivel_usuario);
            UsuarioDAO.createUsuario(usuario);
            return true;

        } else {
            return false;
        }
    }

    public void selecionarUsuario(Usuario usuario) {
        
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();
        
        return historicoDeUsuario.listarUsuarios();
        
    }
    
    public void excluirUsuario(int id_usuario) {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();
        
        historicoDeUsuario.excluirUsuario(id_usuario);
    }
    
    public Usuario buscarUsuario(String nome_usuario) {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();
        
        Usuario usuario = historicoDeUsuario.buscarNomeUsuario(nome_usuario);
        
        return usuario;
    }

}
