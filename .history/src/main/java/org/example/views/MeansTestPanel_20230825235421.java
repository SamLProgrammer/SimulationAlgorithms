package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        setComponentListener();
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;
        
        // Create components
        RiTable = new TablePanel(); // Replace with your TablePanel initialization
        parametersPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel();

        JPanel acceptanceLevelContainer = new JPanel(new GridBagLayout());
        JLabel acceptanceLevelLabel = new JLabel("Acceptance Level",SwingConstants.CENTER);
        acceptanceLevelLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        acceptanceLevelField = new JTextField();
        acceptanceLevelContainer.setName("dude");

        // Set background colors for visualization
        RiTable.setBackground(Color.RED);
        parametersPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.BLUE);

        // Create a container panel for parametersPanel and resultPanel
        JPanel paramsAndResultsPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.weightx = 1.0; // Expand horizontally
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = 3;
        acceptanceLevelContainer.add(acceptanceLevelLabel, gbc);

        gbc.gridx = 1; // Center column
        gbc.gridy = 1; // Second row
        gbc.gridwidth = 1; // Reset grid width
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        acceptanceLevelContainer.add(acceptanceLevelField, gbc);

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

        // GridBagConstraints for parametersPanel
        GridBagConstraints paramsConstraints = new GridBagConstraints();
        paramsConstraints.gridx = 0;
        paramsConstraints.gridy = 0;
        paramsConstraints.gridwidth = 1;
        paramsConstraints.gridheight = 1;
        paramsConstraints.weightx = 1.0; // Full width
        paramsConstraints.weighty = 0.7; // 50% height
        paramsConstraints.fill = GridBagConstraints.BOTH;
        paramsAndResultsPanel.add(parametersPanel, paramsConstraints);

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
            textFieldConstraints.gridx = 0;
            textFieldConstraints.gridy = 0;
            textFieldConstraints.gridwidth = 1;
            textFieldConstraints.gridheight = 1;
            textFieldConstraints.weightx = 0.5; // 50% width
            textFieldConstraints.weighty = 0.1; // 10% height
            textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
            textFieldConstraints.anchor = GridBagConstraints.NORTH; // Align to top

            parametersPanel.add(acceptanceLevelContainer, textFieldConstraints);

        // GridBagConstraints for resultPanel
        GridBagConstraints resultsConstraints = new GridBagConstraints();
        resultsConstraints.gridx = 0;
        resultsConstraints.gridy = 1;
        resultsConstraints.gridwidth = 1;
        resultsConstraints.gridheight = 1;
        resultsConstraints.weightx = 1.0; // Full width
        resultsConstraints.weighty = 0.3; // 50% height
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

    private void setComponentListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JPanel parentPanel = getJPanelParentComponent(acceptanceLevelField);
                int width = (int) (parentPanel.getWidth() * 0.25);
                parentPanel.setPreferredSize(new Dimension(acceptanceLevelField.getHeight(), width));
            }
        });
    }

    private JPanel getJPanelParentComponent(Component component) {
        if(component == null) {
            return null;
        }

        if(component instanceof JPanel) {
            return (JPanel)component;
        } else {
            return getJPanelParentComponent(component.getParent());
        }
    }

}