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

    // Paleta de Cores
    public static final Color COLOR_BG_MAIN = Color.decode("#F5F7FA");
    public static final Color COLOR_BG_SIDEBAR = Color.decode("#1E293B");
    public static final Color COLOR_BG_SIDEBAR_HOVER = Color.decode("#162036");  // Azul mais escuro para hover/ativo
    
    public static final Color COLOR_PRIMARY = Color.decode("#2563EB");
    public static final Color COLOR_SUCCESS = Color.decode("#16A34A");
    public static final Color COLOR_DANGER = Color.decode("#DC2626");
    public static final Color COLOR_WARNING = Color.decode("#D97706");
    public static final Color COLOR_SECONDARY = Color.decode("#475569");
    
    public static final Color COLOR_TEXT_WHITE = Color.decode("#FFFFFF");
    public static final Color COLOR_TEXT_DARK = Color.decode("#334155");
    public static final Color COLOR_TEXT_MUTED = Color.decode("#64748B");
    public static final Color COLOR_SIDEBAR_TEXT_MUTED = Color.decode("#CBD5E1");
    
    public static final Color COLOR_BORDER = Color.decode("#CBD5E1");
    public static final Color COLOR_PANEL_BORDER = Color.decode("#E2E8F0");
    public static final Color COLOR_TABLE_HEADER = Color.decode("#F1F5F9");

    // Tipografia
    public static final String FONT_FAMILY = "Segoe UI";
    public static final Font FONT_TITLE = new Font(FONT_FAMILY, Font.BOLD, 24);
    public static final Font FONT_SUBTITLE = new Font(FONT_FAMILY, Font.PLAIN, 14);
    public static final Font FONT_TEXT = new Font(FONT_FAMILY, Font.PLAIN, 13);
    public static final Font FONT_BUTTON = new Font(FONT_FAMILY, Font.BOLD, 13);
    public static final Font FONT_MENU = new Font(FONT_FAMILY, Font.PLAIN, 13);

    // Configuração Global (Chamar no início da aplicação)
    public static void setup() {
        try {
            // Tenta usar o LookAndFeel do sistema como base
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fundo padrão global
        UIManager.put("Panel.background", COLOR_BG_MAIN);
        UIManager.put("OptionPane.background", COLOR_BG_MAIN);
        UIManager.put("OptionPane.messageForeground", COLOR_TEXT_DARK);
        
        // Fontes globais
        UIManager.put("Label.font", FONT_TEXT);
        UIManager.put("Label.foreground", COLOR_TEXT_DARK);
        
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
        styleBaseButton(btn, COLOR_PRIMARY, COLOR_TEXT_WHITE);
    }

    public static void styleButtonSuccess(JButton btn) {
        styleBaseButton(btn, COLOR_SUCCESS, COLOR_TEXT_WHITE);
    }

    public static void styleButtonDanger(JButton btn) {
        styleBaseButton(btn, COLOR_DANGER, COLOR_TEXT_WHITE);
    }
    
    public static void styleButtonSecondary(JButton btn) {
        styleBaseButton(btn, COLOR_SECONDARY, COLOR_TEXT_WHITE);
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
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void stylePasswordField(JPasswordField txt) {
        txt.setPreferredSize(new Dimension(txt.getPreferredSize().width, 34));
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void styleComboBox(JComboBox<?> combo) {
        combo.setPreferredSize(new Dimension(combo.getPreferredSize().width, 34));
        combo.setBackground(Color.WHITE);
        combo.setBorder(BorderFactory.createLineBorder(COLOR_BORDER, 1));
    }

    // Estilização de Tabelas
    public static void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setFont(FONT_TEXT);
        table.setForeground(COLOR_TEXT_DARK);
        table.setSelectionBackground(COLOR_PRIMARY);
        table.setSelectionForeground(COLOR_TEXT_WHITE);
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setGridColor(COLOR_PANEL_BORDER);
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(COLOR_TABLE_HEADER);
        header.setForeground(COLOR_TEXT_DARK);
        header.setFont(FONT_BUTTON);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 32));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_BORDER));
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
    }
}
