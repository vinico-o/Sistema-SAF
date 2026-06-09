/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.UsuarioDAO;
import Model.HistoricoDeUsuario;
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

    public void autenticarUsuario(String nome_usuario, String senha) {
        
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

}
