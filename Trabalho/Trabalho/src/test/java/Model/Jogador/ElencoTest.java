package Model.Jogador;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class ElencoTest {

    @Test
    public void validarInformacoes_NomeInvalido() {
        Elenco elenco = new Elenco();
        Date hoje = new Date();
        assertFalse(elenco.validarInformacoes(-1, "", hoje, "Brasil", "Atacante", 10, 1000f, 12, 1000000f), "Deveria falhar com nome vazio");
        assertFalse(elenco.validarInformacoes(-1, null, hoje, "Brasil", "Atacante", 10, 1000f, 12, 1000000f), "Deveria falhar com nome nulo");
    }

    @Test
    public void validarInformacoes_DataNula() {
        Elenco elenco = new Elenco();
        assertFalse(elenco.validarInformacoes(-1, "Neymar", null, "Brasil", "Atacante", 10, 1000f, 12, 1000000f), "Deveria falhar com data nula");
    }

    @Test
    public void validarInformacoes_PosicaoInvalida() {
        Elenco elenco = new Elenco();
        Date hoje = new Date();
        assertFalse(elenco.validarInformacoes(-1, "Neymar", hoje, "Brasil", "Selecione", 10, 1000f, 12, 1000000f), "Deveria falhar com posicao Selecione");
    }

    @Test
    public void validarInformacoes_CamisaForaDoIntervalo() {
        Elenco elenco = new Elenco();
        Date hoje = new Date();
        assertFalse(elenco.validarInformacoes(-1, "Neymar", hoje, "Brasil", "Atacante", 0, 1000f, 12, 1000000f), "Deveria falhar com camisa 0");
        assertFalse(elenco.validarInformacoes(-1, "Neymar", hoje, "Brasil", "Atacante", 100, 1000f, 12, 1000000f), "Deveria falhar com camisa 100");
    }
}
