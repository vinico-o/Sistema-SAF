/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.Usuario;

import Controller.ControladorUsuario;

/**
 *
 * @author mardegan
 */
public class TelaCadastroUsuario extends javax.swing.JDialog {

        private static final java.util.logging.Logger logger = java.util.logging.Logger
                        .getLogger(TelaCadastroUsuario.class.getName());

        /**
         * Creates new form TelaCadastroUsuario
         */
        public TelaCadastroUsuario(java.awt.Frame parent, boolean modal) {
                super(parent, modal); // Envia o frame pai e o bloqueio de tela para o JDialog
                initComponents();
        setTitle("Cadastro de Usuário");
                this.pack(); // Ajusta o tamanho da janela aos componentes
                this.setLocationRelativeTo(parent); // Centraliza em cima da TelaPrincipal
        }

        public void cadastrarUsuario() {
                String nome_usuario;
                String senha;
                int nivel_usuario;
                ControladorUsuario controladorUsuario = new ControladorUsuario();

                nome_usuario = campoNomeUsuario.getText();
                senha = new String(campoSenha.getPassword());
                nivel_usuario = campoNivelUsuario.getSelectedIndex();

                boolean operacaoConcluida = controladorUsuario.cadastrarUsuario(nome_usuario, senha, nivel_usuario);
                if (operacaoConcluida) {
                    
                }
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                campoNomeUsuario = new javax.swing.JTextField();
                senha = new javax.swing.JLabel();
                campoSenha = new javax.swing.JPasswordField();
                jButton1 = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                campoNivelUsuario = new javax.swing.JComboBox<>();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(220, 220, 220));

                jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                jLabel1.setText("Cadastro");

                jLabel2.setForeground(new java.awt.Color(0, 0, 0));
                jLabel2.setText("Nome de Usuário");

                campoNomeUsuario.setBackground(new java.awt.Color(200, 200, 200));
                campoNomeUsuario.addActionListener(this::campoNomeUsuarioActionPerformed);

                senha.setForeground(new java.awt.Color(0, 0, 0));
                senha.setText("Senha");

                campoSenha.setBackground(new java.awt.Color(200, 200, 200));
                campoSenha.setForeground(new java.awt.Color(0, 0, 0));

                jButton1.setText("Cadastrar");
                jButton1.addActionListener(this::jButton1ActionPerformed);

                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setText("Nível");

                campoNivelUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Administrado (Adm)", "Gestor Financeiro (GF)", "Operador (Op)" }));
                campoNivelUsuario.addActionListener(this::campoNivelUsuarioActionPerformed);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(163, 163, 163)
                                                                                                .addComponent(jLabel1))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(94, 94, 94)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(campoNivelUsuario,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                                .addComponent(jLabel3)
                                                                                                                                                .addComponent(senha)
                                                                                                                                                .addComponent(campoNomeUsuario)
                                                                                                                                                .addComponent(campoSenha,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                200,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(146, 146, 146)
                                                                                                .addComponent(jButton1)))
                                                                .addContainerGap(106, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(jLabel1)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(campoNomeUsuario,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(senha)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(campoSenha,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(campoNivelUsuario,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                12,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButton1)
                                                                .addGap(29, 29, 29)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void campoNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void campoNivelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarUsuario();

                this.dispose();
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                // Cria um JFrame invisível só para servir de pai no teste
                                javax.swing.JFrame frameDummy = new javax.swing.JFrame();

                                // Instancia como JDialog passando o pai e 'true' para modal
                                TelaCadastroUsuario dialogCadastro = new TelaCadastroUsuario(frameDummy, true);

                                // Limpa a senha padrão do NetBeans
                                dialogCadastro.senha.setText("");

                                // Garante que o programa feche se encerrar o teste
                                dialogCadastro.setDefaultCloseOperation(javax.swing.JDialog.DISPOSE_ON_CLOSE);

                                // Exibe o dialog na tela
                                dialogCadastro.setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JComboBox<String> campoNivelUsuario;
        private javax.swing.JTextField campoNomeUsuario;
        private javax.swing.JPasswordField campoSenha;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel senha;
        // End of variables declaration//GEN-END:variables
}
