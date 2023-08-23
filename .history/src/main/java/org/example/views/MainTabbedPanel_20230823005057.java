package org.example.views;

import javax.swing.JTabbedPane;

import org.example.controller.Controller;

public class MainTabbedPanel extends JTabbedPane{

    private RiPanel riPanel;
    private VarianceTestPanel varianceTestPanel;
    private ChiSquareTestPanel chiSquarePanel;
    private SmirnovTestPanel smirnovTestPanel;
    private PokerTestPanel pokerTestPanel;

    public MainTabbedPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {

    }

    private void initComponents(Controller controller) {
        // addTab(TOOL_TIP_TEXT_KEY, null, VarianceTestPanel, TOOL_TIP_TEXT_KEY);
        riPanel = new RiPanel(controller);
        varianceTestPanel = new VarianceTestPanel();
        chiSquarePanel = new ChiSquareTestPanel();
        smirnovTestPanel = new SmirnovTestPanel();
        pokerTestPanel = new PokerTestPanel();

        addTab("Generate Ri",riPanel);
        addTab("Variance Test", varianceTestPanel);
        addTab("Chi Square Test", chiSquarePanel);
        addTab("Smirnov Test", smirnovTestPanel);
        addTab("Poker Test", pokerTestPanel);
    }

    public void updateRiTableRows(String[][] tableData) {
        riPanel.updateTableRows(tableData);
    }

}