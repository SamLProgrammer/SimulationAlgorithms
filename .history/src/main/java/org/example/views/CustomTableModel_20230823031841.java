package org.example.views;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel{
    private String[][] data;


    public CustomTableModel() {
        this.data = null; // Initialize with null or empty data
    }

    public void updateData(String[][] newData) {
        this.data = newData;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return (data != null) ? data.length : 0;
    }

    @Override
    public int getColumnCount() {
        return (data != null && data.length > 0) ? data[0].length : 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return (data != null && row < data.length && col < data[row].length) ? data[row][col] : null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return JPanel.class;
    }
}
