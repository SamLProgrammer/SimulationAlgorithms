package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
        setAllComponentListeners();
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

        JPanel acceptanceLevelContainer = new JPanel();
        acceptanceLevelContainer.setLayout(new BoxLayout(acceptanceLevelContainer, BoxLayout.Y_AXIS));
        JLabel acceptanceLevelLabel = new JLabel("Acceptance Level",SwingConstants.CENTER);
        acceptanceLevelLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        acceptanceLevelField = new JTextField();
        acceptanceLevelField.setFont(new Font("Oswald", Font.BOLD, 15));

        JLabel percentageLabel = new JLabel("% ");
        percentageLabel.setFont(new Font("Oswald", Font.BOLD, 15));
        acceptanceLevelContainer.setName("dude");

        JPanel percentageContainer = new JPanel(new BorderLayout());
        percentageContainer.add(percentageLabel, BorderLayout.WEST);
        percentageContainer.add(acceptanceLevelField);
        percentageContainer.setName("perC");

        // Set background colors for visualization
        RiTable.setBackground(Color.RED);
        parametersPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.BLUE);

        // Create a container panel for parametersPanel and resultPanel
        JPanel paramsAndResultsPanel = new JPanel(new GridBagLayout());

        acceptanceLevelContainer.add(acceptanceLevelLabel);
        acceptanceLevelContainer.add(Box.createRigidArea(new Dimension(0, 5)));

        acceptanceLevelContainer.add(percentageContainer);

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

    private void setAllComponentListeners() {
        setComponentListener();
        setComponentListenerOnAcceptanceRate();
        setKeyListenerOnAcceptanceRate();
    }

    private void setComponentListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JPanel targetPanel = getJPanelParentComponent(acceptanceLevelField);
                JPanel parentPanel = getJPanelParentComponent(targetPanel.getParent());

                parentPanel.setBackground(Color.red);
                int width = (int) (parentPanel.getWidth() * 0.3);
                int height = (int) targetPanel.getHeight();
                targetPanel.setMaximumSize(new Dimension(width, height));
                targetPanel.setMinimumSize(new Dimension(width, height));
            }
        });
    }

    private void setComponentListenerOnAcceptanceRate() {
        acceptanceLevelField.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JPanel targetPanel = getJPanelParentComponent(acceptanceLevelField);
                JPanel parentPanel = getJPanelParentComponent(targetPanel.getParent());

                parentPanel.setBackground(Color.red);
                int width = (int) (parentPanel.getWidth() * 0.3);
                int height = (int) targetPanel.getHeight();
                targetPanel.setMaximumSize(new Dimension(width, height));
                targetPanel.setMinimumSize(new Dimension(width, height));
            }
        });
    }

    private void setKeyListenerOnAcceptanceRate()  {
        acceptanceLevelField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int asciiCode = e.getKeyChar();
                // e.consume();
                if(!((asciiCode < 48 || asciiCode > 57) && asciiCode != 46 && asciiCode != 44 && asciiCode != 8)) {
                    invokeMeansTest();
                } else {
                    e.consume();
                }
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

    private JPanel getJPanelParentComponentByName(Component component, String name) {
        if(component == null) {
            return null;
        }

        if(component instanceof JPanel && component.getName() == name) {
            return (JPanel)component;
        } else {
            return getJPanelParentComponent(component.getParent());
        }
    }

    private void invokeMeansTest() {
        String stringValue = acceptanceLevelField.getText();
        System.out.println(stringValue);
        if(stringValue.charAt(stringValue.length()-1) == '.') {
            stringValue += '0';
        }
        System.out.println(stringValue);
        // controller.invokeMeansTest()
    }

}