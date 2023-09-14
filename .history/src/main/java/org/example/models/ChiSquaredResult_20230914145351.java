package org.example.models;

import java.util.Map;

public class ChiSquaredResult {
    private Map<String, String> parametersMap;
    private String[][] chiTableData;

    public ChiSquaredResult(Map<String,String> parametersMap, String[][] chiTableData, int intervalsAmount) {
        initComponents(parametersMap, chiTableData, intervalsAmount);
    }

    private void initComponents(Map<String,String> parametersMap, String[][] chiTableData, int intervalsAmount) {
        this.parametersMap = parametersMap;
        this.chiTableData = chiTableData;
        initChiTableData(intervalsAmount);
    }

    private void initChiTableData(int intervalsAmount) {
        this.chiTableData = new String[intervalsAmount][6];
    }

    
}
