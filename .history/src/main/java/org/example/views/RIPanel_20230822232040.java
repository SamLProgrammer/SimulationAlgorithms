package org.example.views;

import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class RIPanel extends JPanel {

    private TablePanel tablePanel;

    public RIPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {

    }

    private void initComponents() {
        tablePanel = new TablePanel();
        add(tablePanel);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }

}
