package org.example.models;

import java.util.ArrayList;
import java.util.Map;

public class PokerResult {
    private Map<String, Double> parametersMap;
    private String[][] pokerTableData;
    private String[][] labeledPokerTableData;
    private ArrayList<String> labeledData;

    public PokerResult(Map<String, Double> parametersMap, String[][] pokerTableData, ArrayList<String> labeledData) {
        initComponents(parametersMap, pokerTableData, labeledData);
    }

    private void initComponents(Map<String, Double> parametersMap, String[][] pokerTableData, ArrayList<String> labeledData) {
        this.parametersMap = parametersMap;
        this.pokerTableData = pokerTableData;
        this.labeledData = labeledData;
    }

    public String[][] getpokerTableData() {
        return pokerTableData;
    }

    public Map<String, Double> getParametersMap() {
        return parametersMap;
    }

    public String[][] getLabeledPokerTableData() {
        return labeledPokerTableData;
    }

    public void setLabeledPokerTableData(String[][] labeledPokerTableData) {
        this.labeledPokerTableData = labeledPokerTableData;
    }
}
