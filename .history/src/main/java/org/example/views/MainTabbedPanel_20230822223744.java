package org.example.views;

import javax.swing.JTabbedPane;

public class MainTabbedPanel extends JTabbedPane{

    private RIPanel riPanel;
    private VarianceTestPanel varianceTestPanel;
    private ChiSquareTestPanel chiSquarePanel;
    private SmirnovTestPanel smirnovTestPanel;
    private PokerTestPanel pokerTestPanel;

    public MainTabbedPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {

    }

    private void initComponents() {
        // addTab(TOOL_TIP_TEXT_KEY, null, VarianceTestPanel, TOOL_TIP_TEXT_KEY);
        addTab("Generate Ri",riPanel);
        addTab("Variance Test", varianceTestPanel);
        addTab("Chi Square Test", chiSquarePanel);
        addTab("Smirnov Test", smirnovTestPanel);
        addTab("Poker Test", pokerTestPanel);
    }

}