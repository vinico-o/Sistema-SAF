/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import java.awt.BasicStroke;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Cauan
 */
public class RelatorioLinhaTempoFinanceiro extends JDialog {

    public RelatorioLinhaTempoFinanceiro(JFrame pai, List<TransacaoFinanceira> listaDoPeriodo) {
        super(pai, "Relatório de Evolução Financeira", true);

        TimeSeriesCollection dataset = criarDataset(listaDoPeriodo);

        // criando o gráfico
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Evolução Financeira por Período",
                "Linha do Tempo",
                "Valor (R$)",
                dataset,
                true,
                true,
                false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // customização do Renderer para as três linhas
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // definição das Cores
        renderer.setSeriesPaint(0, new Color(0, 255, 0));
        renderer.setSeriesPaint(1, new Color(255, 0, 0));
        renderer.setSeriesPaint(2, new Color(0, 0, 255));

        // exibir os pontos em todas as linhas
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(2, true);

        // espessura das linhas (saldo tem destaque)
        renderer.setSeriesStroke(0, new BasicStroke(2.5f));
        renderer.setSeriesStroke(1, new BasicStroke(2.5f));
        renderer.setSeriesStroke(2, new BasicStroke(3.5f));

        plot.setRenderer(renderer);

        // configuração do painel
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        pack();
        setSize(900, 500);
        setLocationRelativeTo(pai);
    }

    public static TimeSeriesCollection criarDataset(List<TransacaoFinanceira> listaDoPeriodo) {
        TimeSeries serieReceitas = new TimeSeries("Receitas");
        TimeSeries serieDespesas = new TimeSeries("Despesas");
        TimeSeries serieSaldo = new TimeSeries("Saldo Líquido");

        Map<Month, Double> acumuloReceitas = new HashMap<>();
        Map<Month, Double> acumuloDespesas = new HashMap<>();

        for (TransacaoFinanceira item : listaDoPeriodo) {
            Date data = item.getData();
            LocalDate localDate = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Month mesJFreeChart = new Month(localDate.getMonthValue(), localDate.getYear());

            if ("Receita".equalsIgnoreCase(item.getTipo())) {
                acumuloReceitas.put(mesJFreeChart, acumuloReceitas.getOrDefault(mesJFreeChart, 0.0) + item.getValor());
            } else {
                acumuloDespesas.put(mesJFreeChart, acumuloDespesas.getOrDefault(mesJFreeChart, 0.0) + item.getValor());
            }
        }

        Set<Month> todosOsMeses = new HashSet<>();
        todosOsMeses.addAll(acumuloReceitas.keySet());
        todosOsMeses.addAll(acumuloDespesas.keySet());

        for (Month mes : todosOsMeses) {
            double totalReceita = acumuloReceitas.getOrDefault(mes, 0.0);
            double totalDespesa = acumuloDespesas.getOrDefault(mes, 0.0);
            double saldoDoMes = totalReceita - totalDespesa;

            if (totalReceita > 0) {
                serieReceitas.add(mes, totalReceita);
            }
            if (totalDespesa > 0) {
                serieDespesas.add(mes, totalDespesa);
            }

            serieSaldo.add(mes, saldoDoMes);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(serieReceitas);
        dataset.addSeries(serieDespesas);
        dataset.addSeries(serieSaldo);

        return dataset;
    }
}
