package org.example.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.example.controller.Controller;

public class MeansTestPanel extends JPanel {
    private TablePanel RiTable;
    private JPanel parametersPanel;
    private JPanel resultPanel;
    private JTextField acceptanceLevelField;
    private JTextArea alfaValueArea;
    private JTextArea halfAlfaValueArea;
    private JTextArea inverseHalfAlfaValueArea;
    private JTextArea zetValueArea;

    private Controller controller;

    public MeansTestPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;

        RiTable = new TablePanel(); // Replace with your TablePanel initialization
        parametersPanel = new JPanel();
        resultPanel = new JPanel();
    
        // Set background colors for visualization
        RiTable.setBackground(Color.RED);
        parametersPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.BLUE);
    
        // Create a container panel for parametersPanel and resultPanel
        JPanel paramsAndResultsPanel = new JPanel(new GridBagLayout());
    
        // GridBagConstraints for RiTable
        GridBagConstraints riTableConstraints = new GridBagConstraints();
        riTableConstraints.gridx = 0;
        riTableConstraints.gridy = 0;
        riTableConstraints.gridwidth = 1;
        riTableConstraints.gridheight = 1;
        riTableConstraints.weightx = 0.6; // 70% width
        riTableConstraints.weighty = 1.0; // 100% height
        riTableConstraints.fill = GridBagConstraints.BOTH;
        riTableConstraints.anchor = GridBagConstraints.WEST;
        add(RiTable, riTableConstraints);
    
        // Create a container panel for components in parametersPanel
        JPanel paramsContainerPanel = new JPanel(new GridBagLayout());
    
        // Create constraints for acceptanceLevelField
        GridBagConstraints acceptanceLevelConstraints = new GridBagConstraints();
        acceptanceLevelConstraints.gridx = 0;
        acceptanceLevelConstraints.gridy = 0;
        acceptanceLevelConstraints.gridwidth = 1;
        acceptanceLevelConstraints.gridheight = 1;
        acceptanceLevelConstraints.weightx = 1.0; // Full width
        acceptanceLevelConstraints.weighty = 0.1; // 10% height
        acceptanceLevelConstraints.fill = GridBagConstraints.HORIZONTAL;
        acceptanceLevelConstraints.anchor = GridBagConstraints.CENTER;
        acceptanceLevelField = new JTextField();
        acceptanceLevelField.setBorder(new EmptyBorder(0, 10, 0, 10));
        paramsContainerPanel.add(acceptanceLevelField, acceptanceLevelConstraints);
    
        // ... Add other components to paramsContainerPanel ...
    
        // GridBagConstraints for paramsContainerPanel in parametersPanel
        GridBagConstraints paramsContainerConstraints = new GridBagConstraints();
        paramsContainerConstraints.gridx = 0;
        paramsContainerConstraints.gridy = 0;
        paramsContainerConstraints.gridwidth = 1;
        paramsContainerConstraints.gridheight = 1;
        paramsContainerConstraints.weightx = 1.0; // Full width
        paramsContainerConstraints.weighty = 0.1; // 10% height
        paramsContainerConstraints.fill = GridBagConstraints.BOTH;
        paramsContainerConstraints.anchor = GridBagConstraints.NORTH;
        parametersPanel.add(paramsContainerPanel, paramsContainerConstraints);
    
        // GridBagConstraints for resultPanel
        GridBagConstraints resultsConstraints = new GridBagConstraints();
        resultsConstraints.gridx = 0;
        resultsConstraints.gridy = 1;
        resultsConstraints.gridwidth = 1;
        resultsConstraints.gridheight = 1;
        resultsConstraints.weightx = 1.0; // Full width
        resultsConstraints.weighty = 0.3; // 30% height
        resultsConstraints.fill = GridBagConstraints.BOTH;
        paramsAndResultsPanel.add(resultPanel, resultsConstraints);
    
        // GridBagConstraints for paramsAndResultsPanel
        GridBagConstraints paramsAndResultsContainerConstraints = new GridBagConstraints();
        paramsAndResultsContainerConstraints.gridx = 1;
        paramsAndResultsContainerConstraints.gridy = 0;
        paramsAndResultsContainerConstraints.gridwidth = 1;
        paramsAndResultsContainerConstraints.gridheight = 1;
        paramsAndResultsContainerConstraints.weightx = 0.4; // 30% width
        paramsAndResultsContainerConstraints.weighty = 1.0; // 100% height
        paramsAndResultsContainerConstraints.fill = GridBagConstraints.BOTH;
        add(paramsAndResultsPanel, paramsAndResultsContainerConstraints);    

    }

    public void setRiTable(TablePanel riTable) {
        RiTable = riTable;
    }
}