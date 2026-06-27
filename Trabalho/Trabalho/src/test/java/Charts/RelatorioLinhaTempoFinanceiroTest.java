package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelatorioLinhaTempoFinanceiroTest {

    @Test
    public void testCriarDataset() {
        List<TransacaoFinanceira> transacoes = new ArrayList<>();

        Calendar cal = Calendar.getInstance();

        cal.set(2023, Calendar.JANUARY, 10);
        TransacaoFinanceira t1 = new TransacaoFinanceira();
        t1.setTipo("Receita");
        t1.setValor(10000.0f);
        t1.setData(cal.getTime());

        cal.set(2023, Calendar.JANUARY, 15);
        TransacaoFinanceira t2 = new TransacaoFinanceira();
        t2.setTipo("Despesa");
        t2.setValor(3000.0f);
        t2.setData(cal.getTime());

        cal.set(2023, Calendar.FEBRUARY, 5);
        TransacaoFinanceira t3 = new TransacaoFinanceira();
        t3.setTipo("Despesa");
        t3.setValor(2000.0f);
        t3.setData(cal.getTime());

        transacoes.add(t1);
        transacoes.add(t2);
        transacoes.add(t3);

        TimeSeriesCollection dataset = RelatorioLinhaTempoFinanceiro.criarDataset(transacoes);

        assertEquals(3, dataset.getSeriesCount(), "Deve haver 3 séries: Receitas, Despesas, Saldo Líquido");

        Month jan2023 = new Month(1, 2023);
        Month fev2023 = new Month(2, 2023);

        // Verifica Receitas
        assertEquals(10000.0, dataset.getSeries("Receitas").getValue(jan2023).doubleValue(),
                "Receita de Janeiro deve ser 10000");

        // Verifica Despesas
        assertEquals(3000.0, dataset.getSeries("Despesas").getValue(jan2023).doubleValue(),
                "Despesa de Janeiro deve ser 3000");
        assertEquals(2000.0, dataset.getSeries("Despesas").getValue(fev2023).doubleValue(),
                "Despesa de Fevereiro deve ser 2000");

        // Verifica Saldo
        assertEquals(7000.0, dataset.getSeries("Saldo Líquido").getValue(jan2023).doubleValue(),
                "Saldo de Janeiro deve ser 7000 (10k - 3k)");
        assertEquals(-2000.0, dataset.getSeries("Saldo Líquido").getValue(fev2023).doubleValue(),
                "Saldo de Fevereiro deve ser -2000 (0 - 2k)");
    }
}
