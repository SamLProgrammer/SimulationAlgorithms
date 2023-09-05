package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.example.controller.Controller;

public class VarianceTestPanel extends JPanel {

    private TablePanel RiTable;
    private JPanel parametersPanel;
    private JPanel resultPanel;
    private JTextArea acceptanceLevelField;
    private JTextArea alphaValueArea;
    private JTextArea halfAlfaValueArea;
    private JTextArea inverseHalfAlfaValueArea;
    private JTextArea halfAlphaXValueArea;
    private JTextArea inverseHalfAlphaXValueArea;
    private JTextArea leftLimitArea;
    private JTextArea rightLimitArea;
    private JTextArea averagePane; 
    private JTextArea resultPane; 

    private Controller controller;

    public VarianceTestPanel(Controller controller) {
        initProperties();
        initComponents(controller);
        setAllComponentListeners();
        setFontRecursively(myInstance());
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;

        double weightY = 1.0/7;
        System.out.println("weightY");
        System.out.println(weightY);
        RiTable = new TablePanel();
        parametersPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());

        JPanel acceptanceLevelContainer = new JPanel();
        acceptanceLevelContainer.setLayout(new BoxLayout(acceptanceLevelContainer, BoxLayout.Y_AXIS));
        JLabel acceptanceLevelLabel = new JLabel("Acceptance Level", SwingConstants.CENTER);
        acceptanceLevelLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        acceptanceLevelField = new JTextArea(1, 3);
        acceptanceLevelField.setFont(new Font("Oswald", Font.BOLD, 15));

        JLabel percentageLabel = new JLabel("% ");
        percentageLabel.setFont(new Font("Oswald", Font.BOLD, 15));
        acceptanceLevelContainer.setName("dude");

        JPanel percentageContainer = new JPanel(new BorderLayout());
        percentageContainer.add(percentageLabel, BorderLayout.WEST);
        percentageContainer.add(acceptanceLevelField);
        percentageContainer.setName("perC");

        RiTable.setBackground(Color.RED);
        parametersPanel.setBackground(Color.GREEN);
        resultPanel.setBackground(Color.BLUE);

        JPanel resultMainContainer = new JPanel();
        resultMainContainer.setLayout(new BoxLayout(resultMainContainer, BoxLayout.Y_AXIS));
        JPanel resultContainer = new JPanel(new BorderLayout());
        JPanel averageContainer = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Result: ");
        JLabel averageLabel = new JLabel("Average: ");
        resultPane = new JTextArea(1, 6);
        resultPane.setName("result");
        averagePane = new JTextArea(1,6);
        averagePane.setName("average");
        averageContainer.add(averageLabel, BorderLayout.WEST);
        averageContainer.add(averagePane);
        resultContainer.add(resultLabel, BorderLayout.WEST);
        resultContainer.add(resultPane);
        resultMainContainer.add(averageContainer);
        resultMainContainer.add(resultContainer);

        GridBagConstraints childConstraints = new GridBagConstraints();
        childConstraints.fill = GridBagConstraints.CENTER;

        resultPanel.add(resultMainContainer, childConstraints);

        JPanel paramsAndResultsPanel = new JPanel(new GridBagLayout());

        acceptanceLevelContainer.add(acceptanceLevelLabel);
        acceptanceLevelContainer.add(Box.createRigidArea(new Dimension(0, 5)));

        acceptanceLevelContainer.add(percentageContainer);

        GridBagConstraints riTableConstraints = new GridBagConstraints();
        riTableConstraints.gridx = 0;
        riTableConstraints.gridy = 0;
        riTableConstraints.gridwidth = 1;
        riTableConstraints.gridheight = 1;
        riTableConstraints.weightx = 0.6; 
        riTableConstraints.weighty = 1.0; 
        riTableConstraints.fill = GridBagConstraints.BOTH;
        riTableConstraints.anchor = GridBagConstraints.WEST;
        add(RiTable, riTableConstraints);


        GridBagConstraints paramsConstraints = new GridBagConstraints();
        paramsConstraints.gridx = 0;
        paramsConstraints.gridy = 0;
        paramsConstraints.gridwidth = 1;
        paramsConstraints.gridheight = 1;
        paramsConstraints.weightx = 1.0; 
        paramsConstraints.weighty = 0.7; 
        paramsConstraints.fill = GridBagConstraints.BOTH;
        paramsAndResultsPanel.add(parametersPanel, paramsConstraints);

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 0;
        textFieldConstraints.gridwidth = 2;
        textFieldConstraints.gridheight = 2;
        textFieldConstraints.weightx = 0.5; 
        textFieldConstraints.weighty = weightY;
        textFieldConstraints.fill = GridBagConstraints.CENTER;
        textFieldConstraints.anchor = GridBagConstraints.NORTH; 

        parametersPanel.add(acceptanceLevelContainer, textFieldConstraints);

        GridBagConstraints calculatedResultsConstraint = new GridBagConstraints();
        calculatedResultsConstraint.gridx = 0;
        calculatedResultsConstraint.gridy = 1;
        calculatedResultsConstraint.gridwidth = 1;
        calculatedResultsConstraint.gridheight = 1;
        calculatedResultsConstraint.weightx = 0.25;
        calculatedResultsConstraint.weighty = weightY;

        JLabel alphaLabel = new JLabel("\u03B1", SwingConstants.CENTER);
        JPanel alphaContainer = new JPanel(new BorderLayout());
        alphaValueArea = new JTextArea(1, 5);
        alphaValueArea.setName("alphaRate");
        setStatsAreaProperties(alphaValueArea);
        alphaContainer.add(alphaLabel, BorderLayout.WEST);
        alphaContainer.add(alphaValueArea);
        parametersPanel.add(alphaContainer, calculatedResultsConstraint);

        GridBagConstraints calculatedResultsConstraint2 = new GridBagConstraints();
        calculatedResultsConstraint2.gridx = 1;
        calculatedResultsConstraint2.gridy = 1;
        calculatedResultsConstraint2.gridwidth = 1;
        calculatedResultsConstraint2.gridheight = 1;
        calculatedResultsConstraint2.weightx = 0.25;
        calculatedResultsConstraint2.weighty = weightY;

        JLabel halfAlphaLabel = new JLabel("\u03B1 / 2", SwingConstants.CENTER);
        JPanel halfAlphaContainer = new JPanel(new BorderLayout());
        halfAlfaValueArea = new JTextArea(1, 5);
        halfAlfaValueArea.setName("halfAlphaRate");
        setStatsAreaProperties(halfAlfaValueArea);
        halfAlphaContainer.add(halfAlphaLabel, BorderLayout.WEST);
        halfAlphaContainer.add(halfAlfaValueArea);
        parametersPanel.add(halfAlphaContainer, calculatedResultsConstraint2);

        GridBagConstraints calculatedResultsConstraint3 = new GridBagConstraints();
        calculatedResultsConstraint3.gridx = 0;
        calculatedResultsConstraint3.gridy = 2;
        calculatedResultsConstraint3.gridwidth = 1;
        calculatedResultsConstraint3.gridheight = 1;
        calculatedResultsConstraint3.weightx = 0.25;
        calculatedResultsConstraint3.weighty = weightY;

        JLabel inverseHalfAlphaLabel = new JLabel("1 - \u03B1 / 2", SwingConstants.CENTER);
        JPanel inverseHalfAlphaContainer = new JPanel(new BorderLayout());
        inverseHalfAlfaValueArea = new JTextArea(1, 5);
        inverseHalfAlfaValueArea.setName("relativeAlphaRate");
        setStatsAreaProperties(inverseHalfAlfaValueArea);
        inverseHalfAlphaContainer.add(inverseHalfAlphaLabel, BorderLayout.WEST);
        inverseHalfAlphaContainer.add(inverseHalfAlfaValueArea);
        parametersPanel.add(inverseHalfAlphaContainer, calculatedResultsConstraint3);

        // =========================================================================================

        // GridBagConstraints calculatedResultsConstraint5 = new GridBagConstraints();
        // calculatedResultsConstraint5.gridx = 0;
        // calculatedResultsConstraint5.gridy = 3;
        // calculatedResultsConstraint5.gridwidth = 1;
        // calculatedResultsConstraint5.gridheight = 2;
        // calculatedResultsConstraint5.weightx = 0.25;
        // calculatedResultsConstraint5.weighty = weightY;

        // JLabel leftLimitLabel = new JLabel("L.L.", SwingConstants.CENTER);
        // JPanel leftLimitContainer = new JPanel(new BorderLayout());
        // leftLimitArea = new JTextArea(1, 5);
        // leftLimitArea.setName("leftLimit");
        // setStatsAreaProperties(leftLimitArea);
        // leftLimitContainer.add(leftLimitLabel, BorderLayout.WEST);
        // leftLimitContainer.add(leftLimitArea);
        // parametersPanel.add(leftLimitContainer, calculatedResultsConstraint5);

        GridBagConstraints calculatedResultsConstraint6 = new GridBagConstraints();
        calculatedResultsConstraint6.gridx = 1;
        calculatedResultsConstraint6.gridy = 3;
        calculatedResultsConstraint6.gridwidth = 1;
        calculatedResultsConstraint6.gridheight = 1;
        calculatedResultsConstraint6.weightx = 0.25;
        calculatedResultsConstraint6.weighty = weightY;

        JLabel halfAlphaXValueAreaLabel = new JLabel("H.A.", SwingConstants.CENTER);
        JPanel halfAlphaXContainer = new JPanel(new BorderLayout());
        halfAlphaXValueArea = new JTextArea(1, 5);
        halfAlphaXValueArea.setName("halfAlphaX");
        setStatsAreaProperties(halfAlphaXValueArea);
        halfAlphaXContainer.add(halfAlphaXValueAreaLabel, BorderLayout.WEST);
        halfAlphaXContainer.add(halfAlphaXValueArea);
        
        parametersPanel.add(halfAlphaXContainer, calculatedResultsConstraint6);

        GridBagConstraints calculatedResultsConstraint7 = new GridBagConstraints();
        calculatedResultsConstraint7.gridx = 0;
        calculatedResultsConstraint7.gridy = 4;
        calculatedResultsConstraint7.gridwidth = 1;
        calculatedResultsConstraint7.gridheight = 2;
        calculatedResultsConstraint7.weightx = 0.25;
        calculatedResultsConstraint7.weighty = weightY;

        // JLabel rightLimitLabel = new JLabel("R.L.", SwingConstants.CENTER);
        // JPanel rightLimitContainer = new JPanel(new BorderLayout());
        // rightLimitArea = new JTextArea(1, 5);
        // rightLimitArea.setName("rightLimit");
        // setStatsAreaProperties(rightLimitArea);
        // rightLimitContainer.add(rightLimitLabel, BorderLayout.WEST);
        // rightLimitContainer.add(rightLimitArea);
        // parametersPanel.add(rightLimitContainer, calculatedResultsConstraint7);

        // GridBagConstraints calculatedResultsConstraint8 = new GridBagConstraints();
        // calculatedResultsConstraint8.gridx = 1;
        // calculatedResultsConstraint8.gridy = 4;
        // calculatedResultsConstraint8.gridwidth = 1;
        // calculatedResultsConstraint8.gridheight = 1;
        // calculatedResultsConstraint8.weightx = 0.25;
        // calculatedResultsConstraint8.weighty = weightY;

        // JLabel inverseHalfAlphaXLabel = new JLabel("I.A.", SwingConstants.CENTER);
        // JPanel inverseHalfAlphaXContainer = new JPanel(new BorderLayout());
        // inverseHalfAlphaXValueArea = new JTextArea(1, 5);
        // inverseHalfAlphaXValueArea.setName("inverseHalfAlphaX");
        // setStatsAreaProperties(inverseHalfAlphaXValueArea);
        // inverseHalfAlphaXContainer.add(inverseHalfAlphaXLabel, BorderLayout.WEST);
        // inverseHalfAlphaXContainer.add(inverseHalfAlphaXValueArea);
        // parametersPanel.add(inverseHalfAlphaXContainer, calculatedResultsConstraint8);

        // =========================================================================================

 
        GridBagConstraints resultsConstraints = new GridBagConstraints();
        resultsConstraints.gridx = 0;
        resultsConstraints.gridy = 1;
        resultsConstraints.gridwidth = 1;
        resultsConstraints.gridheight = 1;
        resultsConstraints.weightx = 1.0; 
        resultsConstraints.weighty = 0.3; 
        resultsConstraints.fill = GridBagConstraints.BOTH;
        paramsAndResultsPanel.add(resultPanel, resultsConstraints);


        GridBagConstraints paramsAndResultsContainerConstraints = new GridBagConstraints();
        paramsAndResultsContainerConstraints.gridx = 1;
        paramsAndResultsContainerConstraints.gridy = 0;
        paramsAndResultsContainerConstraints.gridwidth = 1;
        paramsAndResultsContainerConstraints.gridheight = 1;
        paramsAndResultsContainerConstraints.weightx = 0.4;
        paramsAndResultsContainerConstraints.weighty = 0.15;
        paramsAndResultsContainerConstraints.fill = GridBagConstraints.BOTH;
        add(paramsAndResultsPanel, paramsAndResultsContainerConstraints);
    }

    public void setRiTable(TablePanel riTable) {
        RiTable = riTable;
    }

    private void setAllComponentListeners() {
        setKeyListenerOnAcceptanceRate();
    }

    private void setKeyListenerOnAcceptanceRate() {
        acceptanceLevelField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int asciiCode = e.getKeyChar();
                if (!((asciiCode < 48 || asciiCode > 57) && asciiCode != 46 && asciiCode != 44 && asciiCode != 8)) {
                    if (acceptanceLevelField.getText().length() > 0) {
                        Map<String, Double> statsMap = invokeVarianceTest();
                        System.out.println(statsMap);
                    }
                } else {
                    e.consume();
                }
            }
        });
    }

    private JPanel getJPanelParentComponent(Component component) {
        if (component == null) {
            return null;
        }

        if (component instanceof JPanel) {
            return (JPanel) component;
        } else {
            return getJPanelParentComponent(component.getParent());
        }
    }

    private Map<String, Double> invokeVarianceTest() {
        String stringValue = acceptanceLevelField.getText();
        if (stringValue.charAt(stringValue.length() - 1) == '.') {
            stringValue += '0';
        }
        return controller.invokeVarianceTest(Double.parseDouble(stringValue));
    }

    private JComponent findChildByName(String name) {
        return belowFindChildByName(myInstance(), name);
    }

    private JComponent belowFindChildByName(JComponent jComponent, String name) {
        if (jComponent.getName() != null && jComponent.getName().equals(name)) {
            return jComponent;
        }

        for (Component childComponent : jComponent.getComponents()) {
            if (childComponent instanceof JComponent) {
                JComponent found = belowFindChildByName((JComponent) childComponent, name);
                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }

    private VarianceTestPanel myInstance() {
        return this;
    }

    private void setStatsAreaProperties(JTextArea jTextArea) {
        jTextArea.setFont(new Font("Oswald", Font.BOLD, 16));
        jTextArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        jTextArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(false);
    }

    private void setFontRecursively(JComponent component) {
        component.setFont(new Font("Oswald", Font.BOLD, 16));
        for (Component child : component.getComponents()) {
            if(child instanceof JComponent) {
                setFontRecursively((JComponent)child);
            }
        }
    }
}