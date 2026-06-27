package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelatorioPizzaReceitasTest {

    @Test
    public void testCriarDataset() {
        List<TransacaoFinanceira> receitas = new ArrayList<>();

        TransacaoFinanceira t1 = new TransacaoFinanceira();
        t1.setCategoria("Patrocínio");
        t1.setValor(5000.0f);

        TransacaoFinanceira t2 = new TransacaoFinanceira();
        t2.setCategoria("Bilheteria");
        t2.setValor(2000.0f);

        TransacaoFinanceira t3 = new TransacaoFinanceira();
        t3.setCategoria("Patrocínio");
        t3.setValor(3000.0f);

        receitas.add(t1);
        receitas.add(t2);
        receitas.add(t3);

        DefaultPieDataset dataset = RelatorioPizzaReceitas.criarDataset(receitas);

        assertEquals(2, dataset.getItemCount(), "Deve haver exatamente 2 categorias no dataset");

        assertEquals(8000.0, dataset.getValue("Patrocínio").doubleValue(), "Soma de Patrocínio deve ser 8000");
        assertEquals(2000.0, dataset.getValue("Bilheteria").doubleValue(), "Soma de Bilheteria deve ser 2000");
    }
}
