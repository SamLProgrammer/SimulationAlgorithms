package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RIPanel extends JPanel {

    private TablePanel tablePanel;

    public RIPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        tablePanel = new TablePanel();
        add(tablePanel, BorderLayout.CENTER);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }

}
