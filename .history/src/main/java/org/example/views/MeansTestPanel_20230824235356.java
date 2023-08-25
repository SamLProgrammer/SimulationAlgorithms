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


public class MeansTestPanel extends JPanel{
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
        
        // Create components
        RiTable = new TablePanel(); // Replace with your TablePanel initialization
        parametersPanel = new JPanel();
        resultPanel = new JPanel();

        // Set background colors for visualization
        RiTable.setBackground(Color.RED);
        parametersPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.BLUE);

        // Create a container panel for parametersPanel and resultPanel
        JPanel paramsAndResultsPanel = new JPanel(new GridBagLayout());

        // Create labels for text fields
        JLabel acceptanceLevelLabel = new JLabel("Acceptance Level:");
        JLabel alfaValueLabel = new JLabel("Alfa Value:");
        JLabel halfAlfaValueLabel = new JLabel("Half Alfa Value:");
        JLabel inverseHalfAlfaValueLabel = new JLabel("Inverse Half Alfa Value:");
        JLabel zetValueLabel = new JLabel("Zet Value:");

        // Create components
        acceptanceLevelField = new JTextField();
        alfaValueArea = new JTextArea();
        halfAlfaValueArea = new JTextArea();
        inverseHalfAlfaValueArea = new JTextArea();
        zetValueArea = new JTextArea();

        // Set layout and borders
        parametersPanel.setLayout(new GridBagLayout());
        acceptanceLevelField.setBorder(new EmptyBorder(0, 10, 0, 10));

        // GridBagConstraints for acceptanceLevelField
        GridBagConstraints acceptanceLevelConstraints = new GridBagConstraints();
        acceptanceLevelConstraints.gridx = 0;
        acceptanceLevelConstraints.gridy = 0;
        acceptanceLevelConstraints.gridwidth = 1;
        acceptanceLevelConstraints.gridheight = 1;
        acceptanceLevelConstraints.weightx = 1.0; // Full width
        acceptanceLevelConstraints.weighty = 0.1; // 10% height
        acceptanceLevelConstraints.fill = GridBagConstraints.HORIZONTAL;
        acceptanceLevelConstraints.anchor = GridBagConstraints.PAGE_START;
        parametersPanel.add(acceptanceLevelLabel, acceptanceLevelConstraints);

        // ... other constraints for the rest of the fields ...

        // GridBagConstraints for alfaValueArea
        GridBagConstraints alfaValueConstraints = new GridBagConstraints();
        alfaValueConstraints.gridx = 0;
        alfaValueConstraints.gridy = 1;
        alfaValueConstraints.gridwidth = 1;
        alfaValueConstraints.gridheight = 1;
        alfaValueConstraints.weightx = 1.0; // Full width
        alfaValueConstraints.weighty = 0.2; // 20% height
        alfaValueConstraints.fill = GridBagConstraints.BOTH;
        parametersPanel.add(alfaValueArea, alfaValueConstraints);

        // ... other constraints for the rest of the fields ...

        // GridBagConstraints for paramsAndResultsPanel
        GridBagConstraints paramsAndResultsContainerConstraints = new GridBagConstraints();
        paramsAndResultsContainerConstraints.gridx = 1;
        paramsAndResultsContainerConstraints.gridy = 0;
        paramsAndResultsContainerConstraints.gridwidth = 1;
        paramsAndResultsContainerConstraints.gridheight = 1;
        paramsAndResultsContainerConstraints.weightx = 0.4; // 30% width
        paramsAndResultsContainerConstraints.weighty = 1.0; // 100% height
        paramsAndResultsContainerConstraints.fill = GridBagConstraints.BOTH;
        paramsAndResultsPanel.add(parametersPanel, paramsAndResultsContainerConstraints);
        // ... other constraints for the resultPanel ...

        // Add the components to the main panel
        GridBagConstraints riTableConstraints = new GridBagConstraints();
        riTableConstraints.gridx = 0;
        riTableConstraints.gridy = 0;
        riTableConstraints.gridwidth = 1;
        riTableConstraints.gridheight = 1;
        riTableConstraints.weightx = 0.6; // 60% width
        riTableConstraints.weighty = 1.0; // 100% height
        riTableConstraints.fill = GridBagConstraints.BOTH;
        riTableConstraints.anchor = GridBagConstraints.WEST;
        add(RiTable, riTableConstraints);

        GridBagConstraints paramsAndResultsConstraints = new GridBagConstraints();
        paramsAndResultsConstraints.gridx = 1;
        paramsAndResultsConstraints.gridy = 0;
        paramsAndResultsConstraints.gridwidth = 1;
        paramsAndResultsConstraints.gridheight = 1;
        paramsAndResultsConstraints.weightx = 0.4; // 40% width
        paramsAndResultsConstraints.weighty = 1.0; // 100% height
        paramsAndResultsConstraints.fill = GridBagConstraints.BOTH;
        add(paramsAndResultsPanel, paramsAndResultsConstraints);
    }

    public void setRiTable(TablePanel riTable) {
        RiTable = riTable;
    }
}