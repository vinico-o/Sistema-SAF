/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Usuario.Usuario;

/**
 *
 * @author mardegan
 */
public class Sessao {
    private static Usuario usuarioLogado;
    private static int idClubeAtual;

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
        idClubeAtual = 0;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setIdClubeAtual(int id) {
        idClubeAtual = id;
    }

    public static int getIdClubeAtual() {
        return idClubeAtual;
    }
}
