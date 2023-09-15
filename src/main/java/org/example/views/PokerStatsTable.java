package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PokerStatsTable extends JPanel {

    JTable dataTable;
    DefaultTableModel model;

    public PokerStatsTable() {
        setLayout(new BorderLayout());
        model = new DefaultTableModel();
        dataTable = new JTable(model);

        // Add headers ("a," "b," "c," ... "f")
        String[] headers = {"Hand", "O\u2081", "Prob", "E\u2081", "Chix\u00B2"};
        model.setColumnIdentifiers(headers);

        JScrollPane scrollerTable = new JScrollPane();
        scrollerTable.setViewportView(dataTable);
        scrollerTable.getViewport().setBackground(Color.decode("#202020"));

        // Set a custom cell renderer for centering text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        dataTable.setDefaultRenderer(Object.class, centerRenderer);

        dataTable.setRowHeight(40);
        dataTable.setForeground(Color.decode("#EEF3F7"));
        dataTable.setFont(new Font("Oswald", Font.BOLD, 20));
        dataTable.setBackground(Color.decode("#202020"));
        dataTable.setShowVerticalLines(false);

        // Show the table header
        dataTable.getTableHeader().setVisible(true);

        add(scrollerTable);
    }

    public void updateRowsTable(String[][] dataMatrix, double totalError) {
        model.setRowCount(0);
        model.setColumnCount(dataMatrix[0].length);
        for (int i = 0; i < dataMatrix.length; i++) {
            String[] rowData = dataMatrix[i];
            model.addRow(rowData);
        }
        model.addRow(new String[]{" ","","","SUM", String.valueOf(totalError)});
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }
}