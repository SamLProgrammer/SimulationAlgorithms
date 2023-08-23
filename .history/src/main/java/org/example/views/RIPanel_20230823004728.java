package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

import org.example.controller.Controller;

public class RiPanel extends JPanel {

    private TablePanel tablePanel;
    private RiCommandsPanel riCommandsPanel;
    private Controller controller;

    public RiPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;
        
        tablePanel = new TablePanel();
        riCommandsPanel = new RiCommandsPanel();
        add(tablePanel);
        add(riCommandsPanel, BorderLayout.SOUTH);
    }

    public void updateTableRows(String[][] tableData) {
        tablePanel.updateRowsTable(tableData);
    }



}
