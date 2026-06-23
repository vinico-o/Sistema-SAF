/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioBarrasDespesas extends JDialog {

    public RelatorioBarrasDespesas(JFrame pai, List<TransacaoFinanceira> listaDespesas) {

        super(pai, "Distribuição de Despesas por Categoria", true);

        // Chama o método estático para criar o dataset
        DefaultCategoryDataset dataset = criarDataset(listaDespesas);

        // estilizando o gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Despesas por Categoria",
                "Categorias",
                "Valor (R$)",
                dataset,
                PlotOrientation.HORIZONTAL,
                false,
                true,
                false);

        // customizações
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // + customizações
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(231, 76, 60));
        renderer.setItemMargin(0.1);

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(pai);
    }

    public static DefaultCategoryDataset criarDataset(List<TransacaoFinanceira> listaDespesas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Double> totaisPorCategoria = new HashMap<>();

        for (TransacaoFinanceira despesa : listaDespesas) {
            String categoria = despesa.getCategoria();
            double valor = despesa.getValor();
            totaisPorCategoria.put(categoria, totaisPorCategoria.getOrDefault(categoria, 0.0) + valor);
        }

        for (Map.Entry<String, Double> registro : totaisPorCategoria.entrySet()) {
            dataset.setValue(registro.getValue(), "Despesas", registro.getKey());
        }

        return dataset;
    }
}
