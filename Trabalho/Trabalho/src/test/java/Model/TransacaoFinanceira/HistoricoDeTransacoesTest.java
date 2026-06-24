package Model.TransacaoFinanceira;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoDeTransacoesTest {

    @Test
    void validarInformacoesValorPositivo() {
        HistoricoDeTransacoes ht = new HistoricoDeTransacoes();
        assertTrue(ht.validarInformacoes(100.0f));
    }

    @Test
    void validarInformacoesValorZero() {
        HistoricoDeTransacoes ht = new HistoricoDeTransacoes();
        assertTrue(ht.validarInformacoes(0.0f));
    }

    @Test
    void validarInformacoesValorNegativo() {
        HistoricoDeTransacoes ht = new HistoricoDeTransacoes();
        assertFalse(ht.validarInformacoes(-10.0f));
    }
}
