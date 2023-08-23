package org.example.views;
import javax.swing.JPanel;

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
