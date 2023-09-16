package org.example.models;

import java.util.Map;

public class VarianceTestResult {
    private Map<String, Double> statsMap;
    private String[][] varianceTableData;

    public VarianceTestResult(Map<String, Double> statMap, String[][] varianceTableData) {
        this.statsMap = statMap;
        this.varianceTableData = varianceTableData;
    }

    public Map<String, Double> getStatsMap() {
        return statsMap;
    }

    public String[][] getVarianceTableData() {
        return varianceTableData;
    }
}
