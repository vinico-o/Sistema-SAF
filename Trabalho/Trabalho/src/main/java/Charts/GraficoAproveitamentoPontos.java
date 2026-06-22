package Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import DataAcessObject.PartidaDAO;
import Model.Partida.Partida;

public class GraficoAproveitamentoPontos extends JDialog {

    public GraficoAproveitamentoPontos(JFrame pai, java.util.Date dataInicio, java.util.Date dataFim,
            String competicao) {
        super(pai, "Aproveitamento de Pontos — Vitórias / Empates / Derrotas", true);

        JFreeChart grafico = criarGrafico(dataInicio, dataFim, competicao);

        ChartPanel painel = new ChartPanel(grafico);
        painel.setPreferredSize(new Dimension(900, 500));
        setContentPane(painel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String extrairMes(java.util.Date data) {
        if (data == null)
            return "Desconhecido";

        // Extração manual utilizando Calendar
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(data);
        int numeroMes = cal.get(java.util.Calendar.MONTH) + 1; // Calendar.MONTH é 0-based

        switch (numeroMes) {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
            default:
                return "Desconhecido";
        }
    }

    private JFreeChart criarGrafico(java.util.Date dataInicio, java.util.Date dataFim, String competicao) {

        // Utilizamos a função do sistema para buscar todas as partidas (já filtradas
        // pelo Clube atual)
        List<Partida> todasPartidas = PartidaDAO.listarPartidas();

        // Arrays paralelos para guardar os meses e os contadores
        List<String> mesesVistos = new ArrayList<>();
        List<Integer> vitorias = new ArrayList<>();
        List<Integer> empates = new ArrayList<>();
        List<Integer> derrotas = new ArrayList<>();

        // Percorre cada partida individualmente de forma manual
        for (int i = 0; i < todasPartidas.size(); i++) {
            Partida p = todasPartidas.get(i);

            // Aplica filtro de data
            if (dataInicio != null && p.getData() != null && p.getData().before(dataInicio)) {
                continue;
            }
            if (dataFim != null && p.getData() != null && p.getData().after(dataFim)) {
                continue;
            }

            // Aplica filtro de competição
            if (!competicao.equals("Todas")) {
                if (p.getCompeticao() == null || !p.getCompeticao().equals(competicao)) {
                    continue;
                }
            }

            String mes = extrairMes(p.getData());

            // Descobre se o mês já foi encontrado antes
            int indiceMes = -1;
            for (int j = 0; j < mesesVistos.size(); j++) {
                if (mesesVistos.get(j).equals(mes)) {
                    indiceMes = j;
                    break;
                }
            }

            // Se o mês é novo, adiciona nas listas com contadores zerados
            if (indiceMes == -1) {
                mesesVistos.add(mes);
                vitorias.add(0);
                empates.add(0);
                derrotas.add(0);
                indiceMes = mesesVistos.size() - 1;
            }

            // Classifica o resultado da partida manualmente
            if (p.getGolsMarcados() > p.getGolsSofridos()) {
                int valorAtual = vitorias.get(indiceMes);
                vitorias.set(indiceMes, valorAtual + 1);
            } else if (p.getGolsMarcados() == p.getGolsSofridos()) {
                int valorAtual = empates.get(indiceMes);
                empates.set(indiceMes, valorAtual + 1);
            } else {
                int valorAtual = derrotas.get(indiceMes);
                derrotas.set(indiceMes, valorAtual + 1);
            }
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < mesesVistos.size(); i++) {
            String mes = mesesVistos.get(i);
            dataset.addValue(vitorias.get(i), "Vitórias", mes);
            dataset.addValue(empates.get(i), "Empates", mes);
            dataset.addValue(derrotas.get(i), "Derrotas", mes);
        }

        JFreeChart chart = ChartFactory.createStackedBarChart(
                "Aproveitamento de Pontos por Mês",
                "Mês",
                "Quantidade de Partidas",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);

        StackedBarRenderer renderer = (StackedBarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, new Color(0, 153, 76)); // Verde
        renderer.setSeriesPaint(1, new Color(255, 204, 0)); // Amarelo
        renderer.setSeriesPaint(2, new Color(204, 0, 0)); // Vermelho

        return chart;
    }

}
