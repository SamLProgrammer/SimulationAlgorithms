package org.example.models;

import java.util.Map;

public class MeansTestResult {
    private Map<String, Double> statsMap;
    private String[][] meansTableData;

    public MeansTestResult(Map<String, Double> statMap, String[][] meansTableData) {
        this.statsMap = statMap;
        this.meansTableData = meansTableData;
    }

    public Map<String, Double> getStatsMap() {
        return statsMap;
    }

    public String[][] getMeansTableData() {
        return meansTableData;
    }
}
