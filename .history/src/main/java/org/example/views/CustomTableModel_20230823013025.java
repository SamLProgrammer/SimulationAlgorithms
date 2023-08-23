package org.example.views;

import javax.swing.table.AbstractTableModel;

class CustomTableModel extends AbstractTableModel {

    private final IndexedCell[][] data;

    private final String[] columnNames = {"Column 1", "Column 2"};

    public CustomTableModel() {
        // this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return IndexedCell.class;
    }
}
