package Model.Usuario;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoDeUsuarioTest {

    @Test
    void validarSenhaCorreta() {
        HistoricoDeUsuario ht = new HistoricoDeUsuario();
        Usuario usuario = new Administrador("admin", "12345", 1, 1);
        assertTrue(ht.validarSenha(usuario, "12345"));
    }

    @Test
    void validarSenhaIncorreta() {
        HistoricoDeUsuario ht = new HistoricoDeUsuario();
        Usuario usuario = new Administrador("admin", "12345", 1, 1);
        assertFalse(ht.validarSenha(usuario, "54321"));
    }

    @Test
    void validarInformacoesCorretas() {
        HistoricoDeUsuario ht = new HistoricoDeUsuario();
        assertTrue(ht.validarInformacoes("usuario1", "senha123"));
    }

    @Test
    void validarInformacoesVazias() {
        HistoricoDeUsuario ht = new HistoricoDeUsuario();
        assertFalse(ht.validarInformacoes("", ""));
        assertFalse(ht.validarInformacoes("usuario", ""));
        assertFalse(ht.validarInformacoes("", "senha"));
    }

    @Test
    void validarInformacoesNulas() {
        HistoricoDeUsuario ht = new HistoricoDeUsuario();
        assertFalse(ht.validarInformacoes(null, null));
        assertFalse(ht.validarInformacoes("usuario", null));
        assertFalse(ht.validarInformacoes(null, "senha"));
    }
}
