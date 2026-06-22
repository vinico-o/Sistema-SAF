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
public class RelatorioPizzaReceitas extends JDialog{
    
    public RelatorioPizzaReceitas(JFrame pai, ArrayList<TransacaoFinanceira> listaReceitas) {
        
        super(pai, "Distribuição de Receitas por Categoria", true);

        // dataset pizza
        DefaultPieDataset dataset = new DefaultPieDataset();

        // mapa auxiliar para somar os valores de categorias repetidas
        Map<String, Double> totaisPorCategoria = new HashMap<>();

        // agrupando e somando os valores por categoria
        for (TransacaoFinanceira receita : listaReceitas) {
            String categoria = receita.getCategoria();
            double valor = receita.getValor();

            //soma o valor se a categoria já existir, senão começa com 0 e soma
            totaisPorCategoria.put(categoria, totaisPorCategoria.getOrDefault(categoria, 0.0) + valor);
        }

        // transfere os dados somados do napa para o dataset (aquele do gráfico)
        for (Map.Entry<String, Double> registro : totaisPorCategoria.entrySet()) {
            dataset.setValue(registro.getKey(), registro.getValue());
        }

        // criando o gráfico de pizza
        JFreeChart chart = ChartFactory.createPieChart(
                "Receitas por Categoria", 
                dataset,                  
                true,                     
                true,                     
                false                     
        );

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
    
}
