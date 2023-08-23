package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RIPanel extends JPanel {

    private TablePanel tablePanel;
    private RiCommandsPanel riCommandsPanel;

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
        riCommandsPanel = new RiCommandsPanel();
        add(tablePanel);
        add(riCommandsPanel, BorderLayout.SOUTH);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }



}
