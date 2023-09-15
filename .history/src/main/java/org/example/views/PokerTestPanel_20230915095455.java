package org.example.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.example.controller.Controller;
import org.example.models.ChiSquaredResult;

public class PokerTestPanel extends JPanel {

    private Controller controller;
    private ChiTablePanel RiTable;
    private JPanel parametersPanel;
    private JPanel resultPanel;
    private JTextArea acceptanceLevelField;
    private JTextArea alphaValueArea;
    private JTextArea halfAlfaValueArea;
    private JTextArea inverseHalfAlfaValueArea;
    private JTextArea halfAlphaXValueArea;
    private JTextArea inverseHalfAlphaXValueArea;
    private JTextArea averagePane; 
    private JTextArea resultPane; 

    public PokerTestPanel(Controller controller) {
        initProperties();
        initComponents(controller);
        setAllComponentListeners();
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;

        double weightY = 1.0/7;
        RiTable = new ChiTablePanel();
        parametersPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());

        JPanel acceptanceLevelContainer = new JPanel();
        acceptanceLevelContainer.setLayout(new BoxLayout(acceptanceLevelContainer, BoxLayout.Y_AXIS));
        JLabel acceptanceLevelLabel = new JLabel("Chi\u00B2", SwingConstants.CENTER);
        acceptanceLevelLabel.setFont(new Font("Oswald", Font.BOLD, 20));
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

        JPanel resultMainContainer = new JPanel();
        resultMainContainer.setLayout(new BoxLayout(resultMainContainer, BoxLayout.Y_AXIS));
        JPanel resultContainer = new JPanel(new BorderLayout());
        JPanel averageContainer = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Result: ");
        JLabel averageLabel = new JLabel("Chi Inv: ");
        resultPane = new JTextArea(1, 6);
        resultPane.setName("result");
        averagePane = new JTextArea(1,6);
        averagePane.setName("chiInvTest");
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
        // acceptanceLevelContainer.add(Box.createRigidArea(new Dimension(0, 5)));

        // acceptanceLevelContainer.add(percentageContainer);

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
        // calculatedResultsConstraint.weighty = weightY;

        JLabel alphaLabel = new JLabel("Acceptance Rate % ", SwingConstants.CENTER);
        JPanel alphaContainer = new JPanel(new BorderLayout());
        alphaValueArea = new JTextArea(1, 3);
        alphaValueArea.setName("acceptanceRate");
        setStatsAreaProperties(alphaValueArea, true);
        alphaContainer.add(alphaLabel, BorderLayout.WEST);
        alphaContainer.add(alphaValueArea);
        parametersPanel.add(alphaContainer, calculatedResultsConstraint);

        GridBagConstraints calculatedResultsConstraint2 = new GridBagConstraints();
        calculatedResultsConstraint2.gridx = 1;
        calculatedResultsConstraint2.gridy = 1;
        calculatedResultsConstraint2.gridwidth = 1;
        calculatedResultsConstraint2.gridheight = 1;
        calculatedResultsConstraint2.weightx = 0.25;
        // calculatedResultsConstraint2.weighty = weightY;

        JLabel halfAlphaLabel = new JLabel("Intervals", SwingConstants.CENTER);
        JPanel halfAlphaContainer = new JPanel(new BorderLayout());
        halfAlfaValueArea = new JTextArea(1, 3);
        halfAlfaValueArea.setName("intervals");
        setStatsAreaProperties(halfAlfaValueArea, true);
        halfAlphaContainer.add(halfAlphaLabel, BorderLayout.WEST);
        halfAlphaContainer.add(halfAlfaValueArea);
        parametersPanel.add(halfAlphaContainer, calculatedResultsConstraint2);

        GridBagConstraints calculatedResultsConstraint3 = new GridBagConstraints();
        calculatedResultsConstraint3.gridx = 0;
        calculatedResultsConstraint3.gridy = 2;
        calculatedResultsConstraint3.gridwidth = 1;
        calculatedResultsConstraint3.gridheight = 1;
        calculatedResultsConstraint3.weightx = 0.25;
        // calculatedResultsConstraint3.weighty = weightY;

        JLabel inverseHalfAlphaLabel = new JLabel("Min", SwingConstants.CENTER);
        JPanel inverseHalfAlphaContainer = new JPanel(new BorderLayout());
        inverseHalfAlfaValueArea = new JTextArea(1, 5);
        inverseHalfAlfaValueArea.setName("min");
        setStatsAreaProperties(inverseHalfAlfaValueArea, false);
        inverseHalfAlphaContainer.add(inverseHalfAlphaLabel, BorderLayout.WEST);
        inverseHalfAlphaContainer.add(inverseHalfAlfaValueArea);
        parametersPanel.add(inverseHalfAlphaContainer, calculatedResultsConstraint3);

        // =========================================================================================

        GridBagConstraints calculatedResultsConstraint6 = new GridBagConstraints();
        calculatedResultsConstraint6.gridx = 1;
        calculatedResultsConstraint6.gridy = 2;
        calculatedResultsConstraint6.gridwidth = 1;
        calculatedResultsConstraint6.gridheight = 1;
        calculatedResultsConstraint6.weightx = 0.25;
        calculatedResultsConstraint6.weighty = weightY;

        JLabel halfAlphaXValueAreaLabel = new JLabel("Max", SwingConstants.CENTER);
        JPanel halfAlphaXContainer = new JPanel(new BorderLayout());
        halfAlphaXValueArea = new JTextArea(1, 5);
        halfAlphaXValueArea.setName("max");
        setStatsAreaProperties(halfAlphaXValueArea, false);
        halfAlphaXContainer.add(halfAlphaXValueAreaLabel, BorderLayout.WEST);
        halfAlphaXContainer.add(halfAlphaXValueArea);
        
        parametersPanel.add(halfAlphaXContainer, calculatedResultsConstraint6);

        GridBagConstraints calculatedResultsConstraint8 = new GridBagConstraints();
        calculatedResultsConstraint8.gridx = 0;
        calculatedResultsConstraint8.gridy = 3;
        calculatedResultsConstraint8.gridwidth = 1;
        calculatedResultsConstraint8.gridheight = 1;
        calculatedResultsConstraint8.weightx = 0.25;
        calculatedResultsConstraint8.weighty = weightY;

        JLabel inverseHalfAlphaXValueAreaLabel = new JLabel("Error Sum ", SwingConstants.CENTER);
        JPanel inverseHalfAlphaXValueAreaContainer = new JPanel(new BorderLayout());
        inverseHalfAlphaXValueArea = new JTextArea(1, 5);
        inverseHalfAlphaXValueArea.setName("totalError");
        setStatsAreaProperties(inverseHalfAlphaXValueArea, false);
        inverseHalfAlphaXValueAreaContainer.add(inverseHalfAlphaXValueAreaLabel, BorderLayout.WEST);
        inverseHalfAlphaXValueAreaContainer.add(inverseHalfAlphaXValueArea);
        
        parametersPanel.add(inverseHalfAlphaXValueAreaContainer, calculatedResultsConstraint8);


        GridBagConstraints calculatedResultsConstraint9 = new GridBagConstraints();
        calculatedResultsConstraint9.gridx = 1;
        calculatedResultsConstraint9.gridy = 4;
        calculatedResultsConstraint9.gridwidth = 1;
        calculatedResultsConstraint9.gridheight = 1;
        calculatedResultsConstraint9.weightx = 0.25;
        calculatedResultsConstraint9.weighty = weightY;

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
        setFontRecursively(myInstance());
    }

    public void setRiTable(ChiTablePanel riTable) {
        RiTable = riTable;
    }

    private void setAllComponentListeners() {
        setKeyListenerOnAcceptanceRate();
    }

    private void setKeyListenerOnAcceptanceRate() {
        alphaValueArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyChar());
                int asciiCode = e.getKeyChar();
                if (!((asciiCode < 48 || asciiCode > 57) && asciiCode != 46 && asciiCode != 44 && asciiCode != 8)) {
                    if (alphaValueArea.getText().length() > 0) {
                        ChiSquaredResult chiSquaredResult = invokeVarianceTest();
                        Map<String, Double> statsMap = chiSquaredResult.getParametersMap();
                        myInstance().RiTable.updateRowsTable(chiSquaredResult.getChiTableData());
                        for (Map.Entry<String, Double> entry : statsMap.entrySet()) {
                            String key = entry.getKey();
                            Double value = entry.getValue();
                            JTextArea valueHolderComponent = (JTextArea) findChildByName(key);
                            if (valueHolderComponent != null) {

                                valueHolderComponent.setText((!key.equals("result")) ? "  " + String.valueOf(value)
                                        : (value == 1.0) ? "Passed" : "Failed");
                                valueHolderComponent.setEditable(false);

                            }
                        }
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

    private ChiSquaredResult invokeVarianceTest() {
        String stringValue = alphaValueArea.getText();
        if (stringValue.charAt(stringValue.length() - 1) == '.') {
            stringValue += '0';
        }
        return controller.invokeChiSquaredTest(Double.parseDouble(stringValue), halfAlfaValueArea.getText() == null ? 10 : Integer.valueOf(halfAlfaValueArea.getText()));
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

    private PokerTestPanel myInstance() {
        return this;
    }

    private void setStatsAreaProperties(JTextArea jTextArea, boolean editable) {
        jTextArea.setFont(new Font("Oswald", Font.BOLD, 16));
        jTextArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        jTextArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setEditable(editable);
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