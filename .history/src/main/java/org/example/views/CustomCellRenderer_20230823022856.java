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
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Apply custom rendering only to the specified cell
        if (row == targetRow && column == targetColumn) {
            System.out.println("yep");
            System.out.println(column);
            System.out.println(targetColumn);
            System.out.println(row);
            System.out.println(targetRow);
            renderer = new IndexedCellRenderer(targetRow*targetColumn, "x");
        }

        return renderer;
    }
}