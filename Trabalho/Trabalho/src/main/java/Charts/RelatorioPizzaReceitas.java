/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charts;

import Model.TransacaoFinanceira.TransacaoFinanceira;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Cauan
 */
public class RelatorioPizzaReceitas extends JDialog {

    public RelatorioPizzaReceitas(JFrame pai, ArrayList<TransacaoFinanceira> listaReceitas) {

        super(pai, "Distribuição de Receitas por Categoria", true);

        // Chama o método estático para criar o dataset
        DefaultPieDataset dataset = criarDataset(listaReceitas);

        // criando o gráfico de pizza
        JFreeChart chart = ChartFactory.createPieChart(
                "Receitas por Categoria",
                dataset,
                true,
                true,
                false);

        // customizando
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);

        // formato dos labels
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{0} = R$ {1} ({2})"));
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelBackgroundPaint(new Color(240, 240, 240));

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(pai);
    }

    public static DefaultPieDataset criarDataset(List<TransacaoFinanceira> listaReceitas) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Double> totaisPorCategoria = new HashMap<>();

        for (TransacaoFinanceira receita : listaReceitas) {
            String categoria = receita.getCategoria();
            double valor = receita.getValor();
            totaisPorCategoria.put(categoria, totaisPorCategoria.getOrDefault(categoria, 0.0) + valor);
        }

        for (Map.Entry<String, Double> registro : totaisPorCategoria.entrySet()) {
            dataset.setValue(registro.getKey(), registro.getValue());
        }

        return dataset;
    }

}
