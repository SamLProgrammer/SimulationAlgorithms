package org.example.views;
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
    }

    private void initComponents() {
        tablePanel = new TablePanel();
        add(tablePanel);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }

}
