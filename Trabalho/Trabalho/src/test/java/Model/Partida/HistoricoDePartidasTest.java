package Model.Partida;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoDePartidasTest {

    @Test
    public void validarInformacoes_ValoresNegativos() {
        HistoricoDePartidas historico = new HistoricoDePartidas();
        Date data = new Date();
        
        assertFalse(historico.validarInformacoes(data, "Flamengo", -1, 0, "Brasileirão", 1000, 50000, 50, "Em Casa"), "Deveria falhar com gols marcados negativos");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, -1, "Brasileirão", 1000, 50000, 50, "Em Casa"), "Deveria falhar com gols sofridos negativos");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, 0, "Brasileirão", -1000, 50000, 50, "Em Casa"), "Deveria falhar com premiação negativa");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, 0, "Brasileirão", 1000, -100, 50, "Em Casa"), "Deveria falhar com público negativo");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, 0, "Brasileirão", 1000, 50000, -10, "Em Casa"), "Deveria falhar com valor de ingresso negativo");
    }

    @Test
    public void validarInformacoes_CamposInvalidos() {
        HistoricoDePartidas historico = new HistoricoDePartidas();
        Date data = new Date();
        
        assertFalse(historico.validarInformacoes(null, "Flamengo", 1, 0, "Brasileirão", 1000, 50000, 50, "Em Casa"), "Deveria falhar com data nula");
        assertFalse(historico.validarInformacoes(data, "", 1, 0, "Brasileirão", 1000, 50000, 50, "Em Casa"), "Deveria falhar com adversário vazio");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, 0, "Selecione", 1000, 50000, 50, "Em Casa"), "Deveria falhar com competição Selecione");
        assertFalse(historico.validarInformacoes(data, "Flamengo", 1, 0, "Brasileirão", 1000, 50000, 50, "Selecione"), "Deveria falhar com local Selecione");
    }
    
    @Test
    public void validarInformacoes_Corretas() {
        HistoricoDePartidas historico = new HistoricoDePartidas();
         Date data = new Date();
        assertTrue(historico.validarInformacoes(data, "Palmeiras", 1, 0, "Brasileirão", 10000, 10000, 60, "Em Casa"), "Não deveria falhar");
    }
}
