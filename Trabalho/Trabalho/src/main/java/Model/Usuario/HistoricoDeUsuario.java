/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Usuario;

import Controller.ControladorAuditoria;
import DataAcessObject.UsuarioDAO;
import Model.Sessao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        Usuario usuario = null;

        usuario = DataAcessObject.UsuarioDAO.buscarUsuario(nome_usuario);

        return usuario;
    }

    public void atualizarDados(String nome_usuario, String senha, int nivel_usuario, int id_usuario) {
        if (id_usuario != Sessao.getUsuarioLogado().getId_usuario()) {
            JOptionPane.showMessageDialog(null, "Você só pode editar as suas próprias informações!");
            return;
        }

        Usuario usuario_existente = DataAcessObject.UsuarioDAO.buscarUsuario(nome_usuario);

        if (usuario_existente != null && usuario_existente.getId_usuario() != id_usuario) {
            JOptionPane.showMessageDialog(null, "Nome de Usuário já existente!");
        } else {
            if (nivel_usuario == 0) {
                Usuario usuario = new Usuario(nome_usuario, senha, nivel_usuario, 0);
                DataAcessObject.UsuarioDAO.atualizarUsuario(usuario, id_usuario);
            } else {
                Usuario usuario = new Usuario(nome_usuario, senha, nivel_usuario,
                        Sessao.getUsuarioLogado().getIdClube());
                DataAcessObject.UsuarioDAO.atualizarUsuario(usuario, id_usuario);
            }
            ControladorAuditoria controladorAuditoria = new ControladorAuditoria();
            controladorAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Usuário", "EDIÇÃO",
                    id_usuario);

        }
    }

    public Boolean validarSenha(Usuario usuario, String senha) {
        return usuario.getSenha().equals(senha);
    }

    public Boolean validarInformacoes(String nome_usuario, String senha) {
        // verifica se eh nulo
        if (nome_usuario == null || senha == null) {
            return false;
        }

        // verifica se eh vazio
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
                usuario = new Administrador(nome_usuario, senha, nivel_usuario, 0);
                break;
            case 1:
                usuario = new GestorFinanceiro(nome_usuario, senha, nivel_usuario, Sessao.getIdClubeAtual());
                break;
            case 2:
                usuario = new Operador(nome_usuario, senha, nivel_usuario, Sessao.getIdClubeAtual());
                break;
        }

        usuarios.add(usuario);

        return usuario;
    }

    public ArrayList<Usuario> listarUsuarios() {
        this.usuarios = DataAcessObject.UsuarioDAO.listarUsuarios();

        return usuarios;
    }

    public void excluirUsuario(int id_usuario) {
        if (id_usuario == Sessao.getUsuarioLogado().getId_usuario()) {
            JOptionPane.showMessageDialog(null, "Você não pode excluir o seu próprio usuário!");
            return;
        }

        UsuarioDAO.excluirUsuario(id_usuario);
        ControladorAuditoria controladorAuditoria = new ControladorAuditoria();
        controladorAuditoria.registrarAuditoria(Sessao.getUsuarioLogado().getNome_usuario(), "Usuário", "EXCLUSÃO",
                id_usuario);
    }
}
