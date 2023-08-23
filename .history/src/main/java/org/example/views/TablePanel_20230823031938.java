package org.example.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TablePanel extends JPanel {

    JTable dataTable;
    DefaultTableModel model;

    public TablePanel() {
        dataTable = new JTable(new CustomTableModel());

            // Set custom renderer for the JPanel cell
            dataTable.setDefaultRenderer(JPanel.class, new JPanelCellRenderer());
    }

    public void updateRowsTable(String[][] dataMatrix) {
        System.out.println("yep you called me");
        ((CustomTableModel) dataTable.getModel()).updateData(dataMatrix);
    }

    public int getSelectedRow() {
        return dataTable.getSelectedRow();
    }

}
