package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelatorioBarrasDespesasTest {

    @Test
    public void testCriarDataset() {
        List<TransacaoFinanceira> despesas = new ArrayList<>();
        
        TransacaoFinanceira t1 = new TransacaoFinanceira();
        t1.setCategoria("Salários e Encargos");
        t1.setValor(50000.0f);
        
        TransacaoFinanceira t2 = new TransacaoFinanceira();
        t2.setCategoria("Infraestrutura");
        t2.setValor(15000.0f);
        
        TransacaoFinanceira t3 = new TransacaoFinanceira();
        t3.setCategoria("Salários e Encargos");
        t3.setValor(20000.0f);
        
        despesas.add(t1);
        despesas.add(t2);
        despesas.add(t3);

        DefaultCategoryDataset dataset = RelatorioBarrasDespesas.criarDataset(despesas);

        assertEquals(2, dataset.getColumnCount(), "Deve haver 2 categorias (colunas) no dataset");
        
        assertEquals(70000.0, dataset.getValue("Despesas", "Salários e Encargos").doubleValue(), "Soma de Salários deve ser 70000");
        assertEquals(15000.0, dataset.getValue("Despesas", "Infraestrutura").doubleValue(), "Soma de Manutenção deve ser 15000");
    }
}
