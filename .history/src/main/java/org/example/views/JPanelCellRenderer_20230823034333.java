package org.example.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JPanelCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        JPanel panel = new JPanel(new BorderLayout());
        JLabel indexLabel = new JLabel((column * table.getRowCount() + row) + "");
        JLabel valueLabel = new JLabel(value.toString());

        Font largerFont = valueLabel.getFont().deriveFont(Font.BOLD, valueLabel.getFont().getSize());
        indexLabel.setFont(largerFont);
        indexLabel.setBorder(BorderFactory.createMatteBorder((row == 0) ? 1 : 0, 0, 0, 1, Color.black));
        valueLabel.setFont(largerFont);
        valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        panel.add(indexLabel, BorderLayout.WEST);
        panel.add(valueLabel);


        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }

        return panel;
    }
}