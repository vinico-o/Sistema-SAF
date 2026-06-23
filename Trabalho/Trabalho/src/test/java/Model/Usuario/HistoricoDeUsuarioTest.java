package Model.Usuario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoDeUsuarioTest {

    @Test
    void trueValidarSenhaCorreta() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        Usuario usuario = new Administrador("user1", "senha123", 0, 0);
        assertTrue(historico.validarSenha(usuario, "senha123"));
    }

    @Test
    void falseValidarSenhaIncorreta() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        Usuario usuario = new Administrador("user1", "senha123", 0, 0);
        assertFalse(historico.validarSenha(usuario, "senhaErrada"));
    }

    @Test
    void trueValidarInformacoesValidas() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        assertTrue(historico.validarInformacoes("user1", "senha123"));
    }

    @Test
    void falseValidarInformacoesNomeVazio() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        assertFalse(historico.validarInformacoes("", "senha123"));
    }

    @Test
    void falseValidarInformacoesSenhaVazia() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        assertFalse(historico.validarInformacoes("user1", ""));
    }

    @Test
    void falseValidarInformacoesNomeNulo() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        assertFalse(historico.validarInformacoes(null, "senha123"));
    }

    @Test
    void falseValidarInformacoesSenhaNula() {
        HistoricoDeUsuario historico = new HistoricoDeUsuario();
        assertFalse(historico.validarInformacoes("user1", null));
    }
}
