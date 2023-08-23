package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class RiPanel extends JPanel {

    private TablePanel tablePanel;
    private RiCommandsPanel riCommandsPanel;

    public RiPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setBackground(Color.GREEN);
    }

    private void initComponents() {
        tablePanel = new TablePanel();
        riCommandsPanel = new RiCommandsPanel();
        // add(tablePanel);
        // add(riCommandsPanel, BorderLayout.SOUTH);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }



}
