package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel{

	JTable dataTable;
	DefaultTableModel model;
	
	public TablePanel() {
		setLayout(new BorderLayout());

		model = new DefaultTableModel();
		
		dataTable = new JTable(model);
		JScrollPane scrollerTable = new JScrollPane();
		scrollerTable.setViewportView(dataTable);
		scrollerTable.getViewport().setBackground(Color.decode("#202020"));
		((DefaultTableCellRenderer)dataTable.getDefaultRenderer(Object.class)).setOpaque(false);
		
		dataTable.setRowHeight(40);
		dataTable.setForeground(Color.decode("#EEF3F7"));
		dataTable.setFont(new Font("Oswald", Font.BOLD, 20));
		dataTable.setBackground(Color.decode("#202020"));
		dataTable.setShowVerticalLines(false);

        dataTable.getTableHeader().setVisible(false);
		
		add(scrollerTable);
	}
	
	public void updateRowsTable(String[][] dataMatrix) {
		model.setRowCount(0);
        System.out.println("yep I got called");
		for (int i = 0; i < dataMatrix.length; i++) {
			String[] rowData = dataMatrix[i];
            for(String s : rowData) {
                System.out.println('s');
                System.out.println(s);
            }
			model.addRow(rowData);
		}
	}
	
	public int getSelectedRow() {
		return dataTable.getSelectedRow();
	}
	
}