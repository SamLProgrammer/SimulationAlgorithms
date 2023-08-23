package org.example.views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class CustomCellRenderer extends DefaultTableCellRenderer {
    private final int targetRow;
    private final int targetColumn;

    public CustomCellRenderer(int targetRow, int targetColumn) {
        this.targetRow = targetRow;
        this.targetColumn = targetColumn;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component renderer = new IndexedCellRenderer(targetColumn, "nothing");

        // Apply custom rendering only to the specified cell
        if (row == targetRow && column == targetColumn) {
            renderer.setBackground(Color.YELLOW);
        }

        return renderer;
    }
}