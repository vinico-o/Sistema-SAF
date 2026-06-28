package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Theme {

    //cores
    public static final Color BACKGROUND = Color.decode("#F5F7FA");
    public static final Color SIDEBAR = Color.decode("#1E293B");
    public static final Color SIDEBAR_HOVER = Color.decode("#162036");  // Azul mais escuro para hover/ativo
    
    public static final Color COR_PRINCIPAL = Color.decode("#2563EB");
    public static final Color VERDE = Color.decode("#16A34A");
    public static final Color VERMELHO = Color.decode("#DC2626");
    public static final Color LARANJA = Color.decode("#D97706");
    public static final Color CINZA = Color.decode("#475569");
    
    public static final Color BRANCO = Color.decode("#FFFFFF");
    public static final Color CINZA_ESCURO = Color.decode("#334155");
    public static final Color CINZA_CLARO = Color.decode("#64748B");
    public static final Color CINZA_CLARO_CLARO = Color.decode("#CBD5E1");
    
    public static final Color CINZA_CLARO_BORDA = Color.decode("#CBD5E1");
    public static final Color CINZA_CLARO_PAINEL = Color.decode("#E2E8F0");
    public static final Color CINZA_CLARO_HEADER = Color.decode("#F1F5F9");

    //letras e texto
    public static final String FONT_FAMILY = "Segoe UI";
    public static final Font FONT_TITLE = new Font(FONT_FAMILY, Font.BOLD, 24);
    public static final Font FONT_SUBTITLE = new Font(FONT_FAMILY, Font.PLAIN, 14);
    public static final Font FONT_TEXT = new Font(FONT_FAMILY, Font.PLAIN, 13);
    public static final Font FONT_BUTTON = new Font(FONT_FAMILY, Font.BOLD, 13);
    public static final Font FONT_MENU = new Font(FONT_FAMILY, Font.PLAIN, 13);

    public static void setup() {
        try {
            //tenta usar o LookAndFeel do sistema como base
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fundo padrão global
        UIManager.put("Panel.background", BACKGROUND);
        UIManager.put("OptionPane.background", BACKGROUND);
        UIManager.put("OptionPane.messageForeground", CINZA_ESCURO);
        
        // Fontes globais
        UIManager.put("Label.font", FONT_TEXT);
        UIManager.put("Label.foreground", CINZA_ESCURO);
        
        UIManager.put("TextField.font", FONT_TEXT);
        UIManager.put("PasswordField.font", FONT_TEXT);
        UIManager.put("ComboBox.font", FONT_TEXT);
        UIManager.put("TextArea.font", FONT_TEXT);
        UIManager.put("Button.font", FONT_BUTTON);
        UIManager.put("Table.font", FONT_TEXT);
        UIManager.put("TableHeader.font", FONT_BUTTON);
    }

    // Estilização Específica de Botões
    public static void styleButtonPrimary(JButton btn) {
        styleBaseButton(btn, COR_PRINCIPAL, BRANCO);
    }

    public static void styleButtonSuccess(JButton btn) {
        styleBaseButton(btn, VERDE, BRANCO);
    }

    public static void styleButtonDanger(JButton btn) {
        styleBaseButton(btn, VERMELHO, BRANCO);
    }
    
    public static void styleButtonSecondary(JButton btn) {
        styleBaseButton(btn, CINZA, BRANCO);
    }

    private static void styleBaseButton(JButton btn, Color bg, Color fg) {
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(FONT_BUTTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false); // Impede o L&F de desenhar fundo/sombra/gradiente
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(btn.getPreferredSize().width, 36));
        btn.setMinimumSize(new Dimension(80, 36));
        btn.setBorder(new EmptyBorder(8, 16, 8, 16));
    }

    // Estilização de Campos de Entrada
    public static void styleTextField(JTextField txt) {
        txt.setPreferredSize(new Dimension(txt.getPreferredSize().width, 34));
        txt.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(CINZA_CLARO_BORDA, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void stylePasswordField(JPasswordField txt) {
        txt.setPreferredSize(new Dimension(txt.getPreferredSize().width, 34));
        txt.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(CINZA_CLARO_BORDA, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void styleComboBox(JComboBox<?> combo) {
        combo.setPreferredSize(new Dimension(combo.getPreferredSize().width, 34));
        combo.setBackground(Color.WHITE);
        combo.setBorder(BorderFactory.createLineBorder(CINZA_CLARO_BORDA, 1));
    }

    // Estilização de Tabelas
    public static void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setFont(FONT_TEXT);
        table.setForeground(CINZA_ESCURO);
        table.setSelectionBackground(COR_PRINCIPAL);
        table.setSelectionForeground(BRANCO);
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setGridColor(CINZA_CLARO_PAINEL);
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(CINZA_CLARO_HEADER);
        header.setForeground(CINZA_ESCURO);
        header.setFont(FONT_BUTTON);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 32));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, CINZA_CLARO_BORDA));
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
    }
}
