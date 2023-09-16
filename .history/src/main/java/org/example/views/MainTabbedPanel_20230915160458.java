package org.example.views;

import javax.swing.JTabbedPane;

import org.example.controller.Controller;

public class MainTabbedPanel extends JTabbedPane {

    private RiPanel riPanel;
    private MeansTestPanel meansTestPanel;
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
        meansTestPanel = new MeansTestPanel(controller);
        varianceTestPanel = new VarianceTestPanel(controller);
        chiSquarePanel = new ChiSquareTestPanel(controller);
        pokerTestPanel = new PokerTestPanel(controller);
        smirnovTestPanel = new SmirnovTestPanel();

        addTab("Generate Ri", riPanel);
        addTab("Means Test", meansTestPanel);
        addTab("Variance Test", varianceTestPanel);
        addTab("Chi Square Test", chiSquarePanel);
        addTab("Poker Test", pokerTestPanel);
        addTab("Smirnov Test", smirnovTestPanel);
        for (int i = 1; i < this.getTabCount(); i++) {
            this.setEnabledAt(i, false);
        }
    }

    public void updateRiTableRows(String[][] tableData) {
        riPanel.updateTableRows(tableData);
        updateTableDataOnTestPanels();
    }

    private void updateTableDataOnTestPanels() {
        //  riPanel.setRi
        //  varianceTestPanel.setRi
        //  chiSquarePanel.setRi
        //  smirnovTestPanel.setRi
        //  pokerTestPanel.setRi
    }

}