/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAcessObject.UsuarioDAO;
import Model.HistoricoDeUsuario;
import Model.Usuario;

/**
 *
 * @author Vinícius Mardegan
 */
public class ControladorUsuario {

    public void editarInformacoes(String nome_usuario, String senha) {
        
    }

    public void autenticarUsuario(String nome_usuario, String senha) {
        
    }

    public Boolean cadastrarADM(String nome_usuario, String senha) {
        HistoricoDeUsuario historicoDeUsuario = new HistoricoDeUsuario();
        
        boolean validacao = historicoDeUsuario.validarInformacoes(nome_usuario, senha);
        
        if (!(validacao == false)) {
            Usuario usuario = historicoDeUsuario.cadastrarUsuario(nome_usuario, senha, 0);
            UsuarioDAO.createUsuario(usuario);
            return true;
        } else {
            return false;
        }
    }

    public void cadastrarUsuario(String nome_usuario, String senha, int nivel_usuario) {
        
    }

    public void selecionarUsuario(Usuario usuario) {
        
    }

}
