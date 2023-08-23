package org.example.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel {

    JTable dataTable;
    DefaultTableModel model;

    public TablePanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setVisible(false);
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        initTable();
    }

    private void initTable() {
        String[][] initialData = {
                                {"A", "B", "C"},
                                {"D", "E", "F"},
                                {"G", "H", "I"}
                        };
            
        dataTable = new JTable(new CustomTableModel(initialData));
        JScrollPane scrollerTable = new JScrollPane();
		scrollerTable.setViewportView(dataTable);
        dataTable.setDefaultRenderer(JPanel.class, new JPanelCellRenderer());
        dataTable.getTableHeader().setVisible(false);
        add(scrollerTable);
    }

    public void updateRowsTable(String[][] dataMatrix) {
        ((CustomTableModel) dataTable.getModel()).updateData(dataMatrix);
        setVisible(true);
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }

}
