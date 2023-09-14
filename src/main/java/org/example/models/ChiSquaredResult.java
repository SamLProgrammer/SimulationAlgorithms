package org.example.models;

import java.util.Map;

public class ChiSquaredResult {
    private Map<String, Double> parametersMap;
    private String[][] chiTableData;

    public ChiSquaredResult(Map<String, Double> parametersMap, String[][] chiTableData, int intervalsAmount) {
        initComponents(parametersMap, chiTableData, intervalsAmount);
    }

    private void initComponents(Map<String, Double> parametersMap, String[][] chiTableData, int intervalsAmount) {
        this.parametersMap = parametersMap;
        this.chiTableData = chiTableData;
    }

    public String[][] getChiTableData() {
        return chiTableData;
    }

    public Map<String, Double> getParametersMap() {
        return parametersMap;
    }
}
