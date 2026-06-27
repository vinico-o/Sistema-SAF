package Charts;

import Model.Partida.Partida;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraficoAproveitamentoPontosTest {

    @Test
    public void testCriarDataset() {
        
        List<Partida> partidas = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        // partida 1 dev ser vitoria em janeriro
        cal.set(2023, Calendar.JANUARY, 10);
        Partida p1 = new Partida();
        p1.setData(cal.getTime());
        p1.setCompeticao("Brasileirão");
        p1.setGolsMarcados(2);
        p1.setGolsSofridos(1);

        // partida 2 deve ser empate em janeriro
        cal.set(2023, Calendar.JANUARY, 15);
        Partida p2 = new Partida();
        p2.setData(cal.getTime());
        p2.setCompeticao("Brasileirão");
        p2.setGolsMarcados(1);
        p2.setGolsSofridos(1);

        // Partida 3: Derrota em Fevereiro
        cal.set(2023, Calendar.FEBRUARY, 5);
        Partida p3 = new Partida();
        p3.setData(cal.getTime());
        p3.setCompeticao("Copa do Brasil");
        p3.setGolsMarcados(0);
        p3.setGolsSofridos(2);

        partidas.add(p1);
        partidas.add(p2);
        partidas.add(p3);

        DefaultCategoryDataset dataset = GraficoAproveitamentoPontos.criarDataset(partidas, null, null, "Todas", true, true);

        assertEquals(1.0, dataset.getValue("Vitórias", "Janeiro").doubleValue(), "Deve ter 1 vitória em Janeiro");
        assertEquals(1.0, dataset.getValue("Empates", "Janeiro").doubleValue(), "Deve ter 1 empate em Janeiro");
        assertEquals(0.0, dataset.getValue("Derrotas", "Janeiro").doubleValue(), "Deve ter 0 derrotas em Janeiro");

        assertEquals(0.0, dataset.getValue("Vitórias", "Fevereiro").doubleValue(), "Deve ter 0 vitórias em Fevereiro");
        assertEquals(0.0, dataset.getValue("Empates", "Fevereiro").doubleValue(), "Deve ter 0 empates em Fevereiro");
        assertEquals(1.0, dataset.getValue("Derrotas", "Fevereiro").doubleValue(), "Deve ter 1 derrota em Fevereiro");
        
        DefaultCategoryDataset datasetFiltrado = GraficoAproveitamentoPontos.criarDataset(partidas, null, null, "Brasileirão", true, true);
        
        assertEquals(1, datasetFiltrado.getColumnCount(), "Deve ter apenas o mês de Janeiro ao filtrar Brasileirão");
    }
}
