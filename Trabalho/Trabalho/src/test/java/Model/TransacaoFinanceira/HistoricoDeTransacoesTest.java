package Model.TransacaoFinanceira;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoDeTransacoesTest {

    @Test
    void trueValorPositivo() {
        HistoricoDeTransacoes historico = new HistoricoDeTransacoes();
        assertTrue(historico.validarInformacoes(100.0f));
    }

    @Test
    void trueValorZero() {
        HistoricoDeTransacoes historico = new HistoricoDeTransacoes();
        assertTrue(historico.validarInformacoes(0.0f));
    }

    @Test
    void falseValorNegativo() {
        HistoricoDeTransacoes historico = new HistoricoDeTransacoes();
        assertFalse(historico.validarInformacoes(-10.0f));
    }
}
