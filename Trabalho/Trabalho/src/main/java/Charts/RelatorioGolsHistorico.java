package Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import DataAcessObject.PartidaDAO;
import Model.Partida.Partida;

public class RelatorioGolsHistorico extends JDialog {

    public RelatorioGolsHistorico(JFrame pai, java.util.Date dataInicio, java.util.Date dataFim, String competicao,
            boolean isCasa, boolean isFora) {
        super(pai, "Histórico de Gols — Marcados vs. Sofridos", true);

        JFreeChart grafico = criarGrafico(dataInicio, dataFim, competicao, isCasa, isFora);

        ChartPanel painel = new ChartPanel(grafico);
        painel.setPreferredSize(new Dimension(900, 500));
        setContentPane(painel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JFreeChart criarGrafico(java.util.Date dataInicio, java.util.Date dataFim, String competicao,
            boolean isCasa, boolean isFora) {

        // Busca as partidas utilizando a função já existente no sistema (já filtradas
        // por Clube)
        List<Partida> partidas = PartidaDAO.listarPartidas();

        XYSeriesCollection dataset = criarDataset(partidas, dataInicio, dataFim, competicao, isCasa, isFora);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Histórico de Gols por Partida",
                "Nº da Partida",
                "Gols",
                dataset);

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, new Color(0, 153, 76)); // Verde
        renderer.setSeriesShapesVisible(0, true);

        renderer.setSeriesPaint(1, new Color(204, 0, 0)); // Vermelho
        renderer.setSeriesShapesVisible(1, true);

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        return chart;
    }

    public static XYSeriesCollection criarDataset(List<Partida> partidas, java.util.Date dataInicio,
            java.util.Date dataFim, String competicao, boolean isCasa, boolean isFora) {
        partidas.sort((p1, p2) -> {
            if (p1.getData() == null || p2.getData() == null)
                return 0;
            return p1.getData().compareTo(p2.getData());
        });

        XYSeries serieGolsMarcados = new XYSeries("Gols Marcados");
        XYSeries serieGolsSofridos = new XYSeries("Gols Sofridos");

        int numeroPartida = 0;
        for (int i = 0; i < partidas.size(); i++) {
            Partida p = partidas.get(i);

            if (dataInicio != null && p.getData() != null && p.getData().before(dataInicio)) {
                continue;
            }
            if (dataFim != null && p.getData() != null && p.getData().after(dataFim)) {
                continue;
            }

            if (!competicao.equals("Todas")) {
                if (p.getCompeticao() == null || !p.getCompeticao().equals(competicao)) {
                    continue;
                }
            }

            if (p.getLocal() != null) {
                boolean matchCasa = p.getLocal().equalsIgnoreCase("Em casa");
                boolean matchFora = p.getLocal().equalsIgnoreCase("Fora de casa");
                if (matchCasa && !isCasa)
                    continue;
                if (matchFora && !isFora)
                    continue;
            }

            numeroPartida++;
            int marcados = p.getGolsMarcados();
            int sofridos = p.getGolsSofridos();

            serieGolsMarcados.add(numeroPartida, marcados);
            serieGolsSofridos.add(numeroPartida, sofridos);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serieGolsMarcados);
        dataset.addSeries(serieGolsSofridos);

        return dataset;
    }

}
