/*
 * TelaBuscarPartida.java
 */
package View.Partida;

import Controller.ControladorPartida;
import Model.Partida.Partida;
import java.util.ArrayList;

public class TelaBuscarPartida extends javax.swing.JDialog {

    private TelaPartida telaPartida;

    public TelaBuscarPartida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public TelaBuscarPartida(java.awt.Frame parent, boolean modal, TelaPartida telaPartida) {
        super(parent, modal);
        this.telaPartida = telaPartida;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelCompeticao = new javax.swing.JLabel();
        campoCompeticao = new javax.swing.JComboBox<>();
        jLabelDataInicial = new javax.swing.JLabel();
        campoDataInicial = new javax.swing.JFormattedTextField();
        jLabelDataFinal = new javax.swing.JLabel();
        campoDataFinal = new javax.swing.JFormattedTextField();
        jLabelLocal = new javax.swing.JLabel();
        campoLocal = new javax.swing.JComboBox<>();
        botaoBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Partida");

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitulo.setText("Buscar Partida");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(140, 20, 150, 25);

        jLabelCompeticao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCompeticao.setText("Competição");
        jPanel1.add(jLabelCompeticao);
        jLabelCompeticao.setBounds(40, 70, 300, 20);

        campoCompeticao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasileirão",
                "Libertadores", "Sul-Americana", "Copa do Brasil", "Estadual", "Amistoso" }));
        jPanel1.add(campoCompeticao);
        campoCompeticao.setBounds(40, 90, 300, 25);

        jLabelDataInicial.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataInicial.setText("Data Inicial (dd/MM/yyyy)");
        jPanel1.add(jLabelDataInicial);
        jLabelDataInicial.setBounds(40, 130, 300, 20);

        try {
            campoDataInicial.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(campoDataInicial);
        campoDataInicial.setBounds(40, 150, 300, 25);

        jLabelDataFinal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataFinal.setText("Data Final (dd/MM/yyyy)");
        jPanel1.add(jLabelDataFinal);
        jLabelDataFinal.setBounds(40, 190, 300, 20);

        try {
            campoDataFinal.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(campoDataFinal);
        campoDataFinal.setBounds(40, 210, 300, 25);

        jLabelLocal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLocal.setText("Local");
        jPanel1.add(jLabelLocal);
        jLabelLocal.setBounds(40, 250, 300, 20);

        campoLocal.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Em casa", "Fora de casa" }));
        jPanel1.add(campoLocal);
        campoLocal.setBounds(40, 270, 300, 25);

        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoBuscar);
        botaoBuscar.setBounds(140, 330, 100, 45);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE));

        pack();
    }

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String competicao = campoCompeticao.getSelectedItem().toString();
        String local = campoLocal.getSelectedItem().toString();
        String diStr = campoDataInicial.getText().replace("/", "").trim();
        String dfStr = campoDataFinal.getText().replace("/", "").trim();

        java.util.Date dInicial = null;
        if (!diStr.isEmpty()) {
            try {
                dInicial = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(campoDataInicial.getText());
            } catch (Exception e) {
            }
        }

        java.util.Date dFinal = null;
        if (!dfStr.isEmpty()) {
            try {
                dFinal = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(campoDataFinal.getText());
            } catch (Exception e) {
            }
        }

        ControladorPartida cp = new ControladorPartida();
        ArrayList<Partida> partidas = cp.buscarPartidasRelatorio(competicao, dInicial, dFinal, local);

        if (telaPartida != null) {
            telaPartida.atualizarTabela(partidas);
        }

        dispose();
    }

    // Variables declaration
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JComboBox<String> campoCompeticao;
    private javax.swing.JFormattedTextField campoDataFinal;
    private javax.swing.JFormattedTextField campoDataInicial;
    private javax.swing.JComboBox<String> campoLocal;
    private javax.swing.JLabel jLabelCompeticao;
    private javax.swing.JLabel jLabelDataFinal;
    private javax.swing.JLabel jLabelDataInicial;
    private javax.swing.JLabel jLabelLocal;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
