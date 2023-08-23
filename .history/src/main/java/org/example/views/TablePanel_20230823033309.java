package org.example.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {

    JTable dataTable;
    DefaultTableModel model;

    public TablePanel() {
        String[][] initialData = {
                                {"A", "B", "C"},
                                {"D", "E", "F"},
                                {"G", "H", "I"}
                        };
            
        dataTable = new JTable(new CustomTableModel(initialData));
        JScrollPane scrollerTable = new JScrollPane();
		scrollerTable.setViewportView(dataTable);
        dataTable.setDefaultRenderer(JPanel.class, new JPanelCellRenderer());
        add(scrollerTable);
    }

    public void updateRowsTable(String[][] dataMatrix) {
        System.out.println("yep you called me");
        ((CustomTableModel) dataTable.getModel()).updateData(dataMatrix);
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }

}
