package org.example.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TablePanel extends JPanel {

    JTable dataTable;
    // DefaultTableModel model;
    CustomTableModel model;

    class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    public TablePanel() {
        setLayout(new BorderLayout());
        model = new CustomTableModel(null);
        dataTable = new JTable(model);
        dataTable.setDefaultRenderer(IndexedCell.class, new CustomCellRenderer());
        JScrollPane scrollerTable = new JScrollPane();
        scrollerTable.setViewportView(dataTable);
        scrollerTable.getViewport().setBackground(Color.decode("#202020"));
        ((DefaultTableCellRenderer) dataTable.getDefaultRenderer(Object.class)).setOpaque(false);

        dataTable.setRowHeight(40);
        dataTable.setForeground(Color.decode("#EEF3F7"));
        dataTable.setFont(new Font("Oswald", Font.BOLD, 20));
        dataTable.setBackground(Color.decode("#202020"));
        dataTable.setShowVerticalLines(false);
        Font f = new Font("Oswald", Font.BOLD, 21);
        JTableHeader header = dataTable.getTableHeader();
        TableColumnModel colMod = header.getColumnModel();
        TableColumn tabCol;
        for (int i = 0; i < colMod.getColumnCount(); i++) {
            tabCol = colMod.getColumn(0);
            tabCol.setResizable(true);
        }

        header.setFont(f);
        header.setBackground(Color.decode("#262B2C"));
        header.setForeground(Color.decode("#8F969B"));

        dataTable.setTableHeader(null);

        add(scrollerTable);
    }

    public void updateRowsTable(String[][] dataMatrix) {
        model.setRowCount(0);
        model.setColumnCount(dataMatrix[0].length);
        for (int i = 0; i < dataMatrix.length; i++) {
            String[] rowData = dataMatrix[i];
            IndexedCell[] rowCells = new IndexedCell[rowData.length];
            for(int j = 0; j < rowData.length; j++) {
                rowCells[j] = new IndexedCell(i*j,rowData[j]);
            }
            model.addRow(rowCells);
        }
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }

}
