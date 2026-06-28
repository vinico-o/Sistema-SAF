package View.Partida;

import Model.Partida.Partida;
import java.awt.Color;
import java.awt.Font;

public class TelaDetalhesPartida extends javax.swing.JDialog {

    public TelaDetalhesPartida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void preencherDados(Partida partida) {
        campoIdPartida.setText(String.valueOf(partida.getIdPartida()));

        if (partida.getData() != null) {
            String dataFormatada = new java.text.SimpleDateFormat("dd/MM/yyyy").format(partida.getData());
            campoData.setText(dataFormatada);
        }

        campoClubeAdversario.setText(partida.getClubeAdversario());
        campoGolsMarcados.setText(String.valueOf(partida.getGolsMarcados()));
        campoGolsSofridos.setText(String.valueOf(partida.getGolsSofridos()));
        campoCompeticao.setText(partida.getCompeticao());
        campoPremiacao.setText(String.valueOf(partida.getPremiacao()));
        campoPublico.setText(String.valueOf(partida.getPublico()));
        campoValorDoIngresso.setText(String.valueOf(partida.getValorDoIngresso()));
        campoLocal.setText(partida.getLocal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel_campoIdPartida = new javax.swing.JLabel();
        campoIdPartida = new javax.swing.JTextField();
        jLabel_campoData = new javax.swing.JLabel();
        campoData = new javax.swing.JTextField();
        jLabel_campoClubeAdversario = new javax.swing.JLabel();
        campoClubeAdversario = new javax.swing.JTextField();
        jLabel_campoGolsMarcados = new javax.swing.JLabel();
        campoGolsMarcados = new javax.swing.JTextField();
        jLabel_campoGolsSofridos = new javax.swing.JLabel();
        campoGolsSofridos = new javax.swing.JTextField();
        jLabel_campoCompeticao = new javax.swing.JLabel();
        campoCompeticao = new javax.swing.JTextField();
        jLabel_campoPremiacao = new javax.swing.JLabel();
        campoPremiacao = new javax.swing.JTextField();
        jLabel_campoPublico = new javax.swing.JLabel();
        campoPublico = new javax.swing.JTextField();
        jLabel_campoValorDoIngresso = new javax.swing.JLabel();
        campoValorDoIngresso = new javax.swing.JTextField();
        jLabel_campoLocal = new javax.swing.JLabel();
        campoLocal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Partida");

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitulo.setText("Detalhes da Partida");
        jPanel1.add(jLabelTitulo);
        jLabelTitulo.setBounds(100, 10, 200, 20);

        jLabel_campoIdPartida.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoIdPartida.setText("ID");
        jPanel1.add(jLabel_campoIdPartida);
        jLabel_campoIdPartida.setBounds(20, 50, 150, 20);

        campoIdPartida.setEditable(false);
        campoIdPartida.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoIdPartida);
        campoIdPartida.setBounds(20, 70, 150, 25);

        jLabel_campoData.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoData.setText("Data");
        jPanel1.add(jLabel_campoData);
        jLabel_campoData.setBounds(200, 50, 150, 20);

        campoData.setEditable(false);
        campoData.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoData);
        campoData.setBounds(200, 70, 150, 25);

        jLabel_campoClubeAdversario.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoClubeAdversario.setText("Clube Adversário");
        jPanel1.add(jLabel_campoClubeAdversario);
        jLabel_campoClubeAdversario.setBounds(20, 110, 150, 20);

        campoClubeAdversario.setEditable(false);
        campoClubeAdversario.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoClubeAdversario);
        campoClubeAdversario.setBounds(20, 130, 150, 25);

        jLabel_campoGolsMarcados.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoGolsMarcados.setText("Gols Marcados");
        jPanel1.add(jLabel_campoGolsMarcados);
        jLabel_campoGolsMarcados.setBounds(200, 110, 150, 20);

        campoGolsMarcados.setEditable(false);
        campoGolsMarcados.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoGolsMarcados);
        campoGolsMarcados.setBounds(200, 130, 150, 25);

        jLabel_campoGolsSofridos.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoGolsSofridos.setText("Gols Sofridos");
        jPanel1.add(jLabel_campoGolsSofridos);
        jLabel_campoGolsSofridos.setBounds(20, 170, 150, 20);

        campoGolsSofridos.setEditable(false);
        campoGolsSofridos.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoGolsSofridos);
        campoGolsSofridos.setBounds(20, 190, 150, 25);

        jLabel_campoCompeticao.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoCompeticao.setText("Competição");
        jPanel1.add(jLabel_campoCompeticao);
        jLabel_campoCompeticao.setBounds(200, 170, 150, 20);

        campoCompeticao.setEditable(false);
        campoCompeticao.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoCompeticao);
        campoCompeticao.setBounds(200, 190, 150, 25);

        jLabel_campoPremiacao.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoPremiacao.setText("Premiação");
        jPanel1.add(jLabel_campoPremiacao);
        jLabel_campoPremiacao.setBounds(20, 230, 150, 20);

        campoPremiacao.setEditable(false);
        campoPremiacao.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoPremiacao);
        campoPremiacao.setBounds(20, 250, 150, 25);

        jLabel_campoPublico.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoPublico.setText("Público");
        jPanel1.add(jLabel_campoPublico);
        jLabel_campoPublico.setBounds(200, 230, 150, 20);

        campoPublico.setEditable(false);
        campoPublico.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoPublico);
        campoPublico.setBounds(200, 250, 150, 25);

        jLabel_campoValorDoIngresso.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoValorDoIngresso.setText("Valor do Ingresso");
        jPanel1.add(jLabel_campoValorDoIngresso);
        jLabel_campoValorDoIngresso.setBounds(20, 290, 150, 20);

        campoValorDoIngresso.setEditable(false);
        campoValorDoIngresso.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoValorDoIngresso);
        campoValorDoIngresso.setBounds(20, 310, 150, 25);

        jLabel_campoLocal.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_campoLocal.setText("Local");
        jPanel1.add(jLabel_campoLocal);
        jLabel_campoLocal.setBounds(200, 290, 150, 20);

        campoLocal.setEditable(false);
        campoLocal.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.add(campoLocal);
        campoLocal.setBounds(200, 310, 150, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368,
                                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoClubeAdversario;
    private javax.swing.JTextField campoCompeticao;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoGolsMarcados;
    private javax.swing.JTextField campoGolsSofridos;
    private javax.swing.JTextField campoIdPartida;
    private javax.swing.JTextField campoLocal;
    private javax.swing.JTextField campoPremiacao;
    private javax.swing.JTextField campoPublico;
    private javax.swing.JTextField campoValorDoIngresso;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabel_campoClubeAdversario;
    private javax.swing.JLabel jLabel_campoCompeticao;
    private javax.swing.JLabel jLabel_campoData;
    private javax.swing.JLabel jLabel_campoGolsMarcados;
    private javax.swing.JLabel jLabel_campoGolsSofridos;
    private javax.swing.JLabel jLabel_campoIdPartida;
    private javax.swing.JLabel jLabel_campoLocal;
    private javax.swing.JLabel jLabel_campoPremiacao;
    private javax.swing.JLabel jLabel_campoPublico;
    private javax.swing.JLabel jLabel_campoValorDoIngresso;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
