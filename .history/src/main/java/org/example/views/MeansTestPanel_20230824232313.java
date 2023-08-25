package org.example.views;

import javax.swing.JPanel;

import org.example.controller.Controller;

public class MeansTestPanel extends JPanel{
    private TablePanel RiTable;
    private JPanel parametersPanel;
    private JPanel resultPanel;
    private Controller controller;

    public MeansTestPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {

    }

    private void initComponents(Controller controller) {
        this.controller = controller;
    }

    public void setRiTable(TablePanel riTable) {
        RiTable = riTable;
    }
}