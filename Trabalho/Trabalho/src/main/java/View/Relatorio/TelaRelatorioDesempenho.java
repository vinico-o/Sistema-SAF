package View.Relatorio;

import Charts.GraficoAproveitamentoPontos;
import Charts.RelatorioGolsHistorico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TelaRelatorioDesempenho extends javax.swing.JPanel {

    public TelaRelatorioDesempenho() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTipoRelatorio = new javax.swing.JLabel();
        jComboBoxTipoRelatorio = new javax.swing.JComboBox<>();
        jLabelCompeticao = new javax.swing.JLabel();
        jComboBoxCompeticao = new javax.swing.JComboBox<>();
        jLabelInicio = new javax.swing.JLabel();
        jLabelFinal = new javax.swing.JLabel();
        campoPeriodoInicial = new javax.swing.JFormattedTextField();
        campoPeriodoFinal = new javax.swing.JFormattedTextField();
        botaoGerar = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 220, 220));

        jLabelTipoRelatorio.setText("Tipo de Relatório");

        jComboBoxTipoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Aproveitamento de Pontos", "Histórico de Gols" }));

        jLabelCompeticao.setText("Competição");

        jComboBoxCompeticao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Brasileirão",
                "Copa do Brasil", "Libertadores", "Sul-Americana", "Paulistão" }));

        jLabelInicio.setText("Início");

        jLabelFinal.setText("Final");

        campoPeriodoInicial.setBackground(new java.awt.Color(200, 200, 200));
        try {
            campoPeriodoInicial.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        campoPeriodoFinal.setBackground(new java.awt.Color(200, 200, 200));
        try {
            campoPeriodoFinal.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        botaoGerar.setText("Gerar");
        botaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTipoRelatorio)
                                        .addComponent(jComboBoxTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCompeticao)
                                        .addComponent(jComboBoxCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelInicio)
                                                        .addComponent(campoPeriodoInicial,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelFinal)
                                                        .addComponent(campoPeriodoFinal,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(botaoGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(80, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabelTipoRelatorio)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabelCompeticao)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelInicio)
                                        .addComponent(jLabelFinal))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoPeriodoInicial, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoPeriodoFinal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(botaoGerar)
                                .addContainerGap(40, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoGerarActionPerformed
        String tipoRelatorio = (String) jComboBoxTipoRelatorio.getSelectedItem();
        String competicao = (String) jComboBoxCompeticao.getSelectedItem();

        Date dataInicio = null;
        Date dataFim = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        String txtInicio = campoPeriodoInicial.getText().replace("/", "").trim();
        if (!txtInicio.isEmpty()) {
            try {
                dataInicio = sdf.parse(campoPeriodoInicial.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Data Inicial inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String txtFim = campoPeriodoFinal.getText().replace("/", "").trim();
        if (!txtFim.isEmpty()) {
            try {
                dataFim = sdf.parse(campoPeriodoFinal.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Data Final inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        javax.swing.JFrame janelaPai = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (tipoRelatorio.equals("Aproveitamento de Pontos")) {
            new GraficoAproveitamentoPontos(janelaPai, dataInicio, dataFim, competicao);
        } else {
            new RelatorioGolsHistorico(janelaPai, dataInicio, dataFim, competicao);
        }
    }// GEN-LAST:event_botaoGerarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerar;
    private javax.swing.JFormattedTextField campoPeriodoFinal;
    private javax.swing.JFormattedTextField campoPeriodoInicial;
    private javax.swing.JComboBox<String> jComboBoxCompeticao;
    private javax.swing.JComboBox<String> jComboBoxTipoRelatorio;
    private javax.swing.JLabel jLabelCompeticao;
    private javax.swing.JLabel jLabelFinal;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelTipoRelatorio;
    // End of variables declaration//GEN-END:variables
}
