package org.example.views;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel{
    private String[][] data;

    public CustomTableModel(String[][] data) {
        if(data != null) {
            this.data = data;
        }
    }

    public void updateData(String[][] newData) {
        this.data = newData;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return JPanel.class;
    }
}
