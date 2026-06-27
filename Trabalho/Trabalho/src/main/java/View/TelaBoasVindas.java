package View;

import Model.Sessao;
import Model.Usuario.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaBoasVindas extends JPanel {

    public TelaBoasVindas() {
        setLayout(new BorderLayout(24, 24));
        setBackground(Theme.COLOR_BG_MAIN);
        setBorder(new EmptyBorder(40, 40, 40, 40));

        // header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Theme.COLOR_BG_MAIN);

        Usuario user = Sessao.getUsuarioLogado();
        String nome = user != null ? user.getNome_usuario() : "Usuário";

        JLabel lblBemVindo = new JLabel("Bem-vindo, " + nome);
        lblBemVindo.setFont(Theme.FONT_TITLE);
        lblBemVindo.setForeground(Theme.COLOR_TEXT_DARK);

        JLabel lblSubtitulo = new JLabel("Guia rápido de uso do sistema");
        lblSubtitulo.setFont(Theme.FONT_SUBTITLE);
        lblSubtitulo.setForeground(Theme.COLOR_TEXT_MUTED);

        headerPanel.add(lblBemVindo);
        headerPanel.add(Box.createVerticalStrut(8));
        headerPanel.add(lblSubtitulo);

        add(headerPanel, BorderLayout.NORTH);

        // cards de instrucoes
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Theme.COLOR_BG_MAIN);

        // primeiso cards
        JPanel linha1 = new JPanel(new GridLayout(1, 3, 24, 0));
        linha1.setBackground(Theme.COLOR_BG_MAIN);
        linha1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        linha1.add(createInstructionCard(
                "1. Dashboard",
                "Acesse o Dashboard no menu lateral para visualizar o resumo financeiro do clube, incluindo receitas, despesas e saldo.",
                Theme.COLOR_PRIMARY
        ));
        linha1.add(createInstructionCard(
                "2. Jogadores",
                "Cadastre, edite e gerencie os jogadores do elenco. Acompanhe informações como posição, salário e tempo de contrato.",
                Theme.COLOR_SUCCESS
        ));
        linha1.add(createInstructionCard(
                "3. Partidas",
                "Registre as partidas do clube, incluindo placar, adversário e data. Os dados alimentam o relatório de desempenho.",
                Theme.COLOR_WARNING
        ));

        // cards d ebaixo
        JPanel linha2 = new JPanel(new GridLayout(1, 3, 24, 0));
        linha2.setBackground(Theme.COLOR_BG_MAIN);
        linha2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));

        linha2.add(createInstructionCard(
                "4. Receitas e Despesas",
                "Cadastre as movimentações financeiras do clube. As receitas e despesas são utilizadas nos relatórios e no dashboard.",
                Theme.COLOR_DANGER
        ));
        linha2.add(createInstructionCard(
                "5. Relatórios",
                "Gere relatórios financeiros e de desempenho para analisar a saúde financeira e os resultados esportivos do clube.",
                Theme.COLOR_SECONDARY
        ));
        linha2.add(createInstructionCard(
                "6. Administração",
                "Gerencie clubes, usuários e consulte o log de auditoria. Funcionalidades disponíveis conforme seu nível de acesso.",
                new Color(124, 58, 237) // Roxo
        ));

        // Montagem
        centerPanel.add(linha1);
        centerPanel.add(Box.createVerticalStrut(24));
        centerPanel.add(linha2);

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(Theme.COLOR_BG_MAIN);
        centerWrapper.add(centerPanel, BorderLayout.NORTH);

        add(centerWrapper, BorderLayout.CENTER);
    }

    
    private JPanel createInstructionCard(String title, String description, Color accentColor) {
        JPanel card = new JPanel(new BorderLayout(0, 12));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Theme.COLOR_PANEL_BORDER, 1),
                new EmptyBorder(20, 20, 20, 20)
        ));

        //barra colorida no topo
        JPanel barraColorida = new JPanel();
        barraColorida.setBackground(accentColor);
        barraColorida.setPreferredSize(new Dimension(0, 4));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font(Theme.FONT_FAMILY, Font.BOLD, 15));
        lblTitle.setForeground(accentColor);

        // Texto com quebra de linha automática via HTML
        JLabel lblDesc = new JLabel("<html><body style='width: 100%'>" + description + "</body></html>");
        lblDesc.setFont(Theme.FONT_TEXT);
        lblDesc.setForeground(Theme.COLOR_TEXT_MUTED);
        lblDesc.setVerticalAlignment(SwingConstants.TOP);

        JPanel headerCard = new JPanel(new BorderLayout(0, 8));
        headerCard.setBackground(Color.WHITE);
        headerCard.add(barraColorida, BorderLayout.NORTH);
        headerCard.add(lblTitle, BorderLayout.CENTER);

        card.add(headerCard, BorderLayout.NORTH);
        card.add(lblDesc, BorderLayout.CENTER);

        return card;
    }
}
