package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ChiTablePanel extends JPanel {

    JTable dataTable;
    DefaultTableModel model;

    public ChiTablePanel() {
        setLayout(new BorderLayout());
        model = new DefaultTableModel();
        dataTable = new JTable(model);

        // Add headers ("a," "b," "c," ... "f")
        String[] headers = {"Interval", "Start", "End", "Occurrences", "Expected", "Error"};
        model.setColumnIdentifiers(headers);

        JScrollPane scrollerTable = new JScrollPane();
        scrollerTable.setViewportView(dataTable);
        scrollerTable.getViewport().setBackground(Color.decode("#202020"));
        ((DefaultTableCellRenderer) dataTable.getDefaultRenderer(Object.class)).setOpaque(false);

        dataTable.setRowHeight(40);
        dataTable.setForeground(Color.decode("#EEF3F7"));
        dataTable.setFont(new Font("Oswald", Font.BOLD, 20));
        dataTable.setBackground(Color.decode("#202020"));
        dataTable.setShowVerticalLines(false);

        // Show the table header
        dataTable.getTableHeader().setVisible(true);

        add(scrollerTable);
    }

    public void updateRowsTable(String[][] dataMatrix) {
        model.setRowCount(0);
        model.setColumnCount(dataMatrix[0].length);
        for (int i = 0; i < dataMatrix.length; i++) {
            String[] rowData = dataMatrix[i];
            for(int j = 0; j < rowData.length; j++) {
                System.out.print(rowData[j] + ' ');
            }
            System.out.println("=====================");
            model.addRow(rowData);
        }
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }
}