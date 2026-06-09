/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mardegan
 */
public class Sessao {
    private static Usuario usuarioLogado;
    
    public static void iniciarSessao(Usuario usuario) {
        usuarioLogado = usuario;
    }
    
    public static void encerrarSessao(Usuario usuario) {
        usuarioLogado = null;
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
