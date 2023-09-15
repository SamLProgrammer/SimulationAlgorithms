package org.example.models;

import java.util.Map;

public class PokerResult {
    private Map<String, Double> parametersMap;
    private String[][] pokerTableData;

    public PokerResult(Map<String, Double> parametersMap, String[][] pokerTableData) {
        initComponents(parametersMap, pokerTableData);
    }

    private void initComponents(Map<String, Double> parametersMap, String[][] pokerTableData) {
        this.parametersMap = parametersMap;
        this.pokerTableData = pokerTableData;
    }

    public String[][] getpokerTableData() {
        return pokerTableData;
    }

    public Map<String, Double> getParametersMap() {
        return parametersMap;
    }
}
