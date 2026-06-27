package Charts;

import Model.Partida.Partida;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelatorioGolsHistoricoTest {

    @Test
    public void testCriarDataset() {
        List<Partida> partidas = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.set(2023, Calendar.JANUARY, 10);
        Partida p1 = new Partida();
        p1.setData(cal.getTime());
        p1.setCompeticao("Amistoso");
        p1.setGolsMarcados(3);
        p1.setGolsSofridos(0);

        cal.set(2023, Calendar.FEBRUARY, 15);
        Partida p2 = new Partida();
        p2.setData(cal.getTime());
        p2.setCompeticao("Amistoso");
        p2.setGolsMarcados(1);
        p2.setGolsSofridos(2);

        partidas.add(p2); // Adiciona fora de ordem cronológica para testar a ordenação
        partidas.add(p1);

        XYSeriesCollection dataset = RelatorioGolsHistorico.criarDataset(partidas, null, null, "Todas", true, true);

        assertEquals(2, dataset.getSeriesCount(), "Deve conter 2 séries: Marcados e Sofridos");

        //As partidas devem ficar ordenadasd

        // Partida 1 (Janeiro)
        assertEquals(3.0, dataset.getSeries("Gols Marcados").getY(0).doubleValue(),
                "A primeira partida deve ter 3 gols marcados");
        assertEquals(0.0, dataset.getSeries("Gols Sofridos").getY(0).doubleValue(),
                "A primeira partida deve ter 0 gols sofridos");

        // Partida 2 (Fevereiro)
        assertEquals(1.0, dataset.getSeries("Gols Marcados").getY(1).doubleValue(),
                "A segunda partida deve ter 1 gol marcado");
        assertEquals(2.0, dataset.getSeries("Gols Sofridos").getY(1).doubleValue(),
                "A segunda partida deve ter 2 gols sofridos");
    }
}
