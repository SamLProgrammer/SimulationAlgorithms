package org.example.views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class CustomCellRenderer extends DefaultTableCellRenderer {
    private final int targetRow;
    private final int targetColumn;
    private final String cellValue;

    public CustomCellRenderer(int targetRow, int targetColumn, String cellValue) {
        this.targetRow = targetRow;
        this.targetColumn = targetColumn;
        this.cellValue = cellValue;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        return new IndexedCellRenderer(row*column, cellValue);
    }
}