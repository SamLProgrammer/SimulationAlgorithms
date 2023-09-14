package org.example.models;

import java.util.Map;

public class ChiSquaredResult {
    private Map<String, String> parametersMap;
    private String[][] chiTableData;

    public ChiSquaredResult(Map<String,String> parametersMap, String[][] chiTableData) {
        initComponents(parametersMap, chiTableData);
    }

    private void initComponents(Map<String,String> parametersMap, String[][] chiTableData) {
        this.parametersMap = parametersMap;
        this.chiTableData = chiTableData;
    }

}
