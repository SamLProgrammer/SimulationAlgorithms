package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MeansTest {
    private StatisticFunctions statisticFunctions;
    private double acceptanceRate;
    private double alphaRate;
    private double halfAlphaRate;
    private double relativeAlphaRate;
    private double zet;
    private double leftLimit;
    private double rightLimit;
    private final double MEAN = 0.5;

    public MeansTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    public Map<String, Double> executeTest(double acceptanceRate , int n, ArrayList<Double> randomsList) {
        this.acceptanceRate = acceptanceRate;
        double result = calculateVariables(n, calculateAverage(randomsList));
        Map<String, Double> statsMap = new HashMap<String, Double>();
        statsMap.put("alphaRate", alphaRate);
        statsMap.put("halfAlphaRate", halfAlphaRate);
        statsMap.put("relativeAlphaRate", relativeAlphaRate);
        statsMap.put("zet", zet);
        statsMap.put("leftLimit", leftLimit);
        statsMap.put("rightLimit", rightLimit);
        statsMap.put("result", result);
        return statsMap;
    }

    private double calculateAverage(ArrayList<Double> randomsList) {
        double average = 0;
        for(double random : randomsList) {
            average += random;
        }

        return average / randomsList.size();
    }

    private double calculateVariables(int n, double average) {
        alphaRate = 100 - acceptanceRate;
        halfAlphaRate = alphaRate/200;
        relativeAlphaRate = 1.0 - halfAlphaRate;
        zet = Double.parseDouble(statisticFunctions.getNormSINV(relativeAlphaRate).replace(',', '.'));
        leftLimit = MEAN - ( zet * ( 1 / Math.sqrt( 12 * n ) ) );
        rightLimit = MEAN + ( zet * ( 1 / Math.sqrt( 12 * n ) ) );
        rightLimit = formatDouble(rightLimit);
        leftLimit = formatDouble(leftLimit);
        return (leftLimit <= average && rightLimit >= average) ? 1.0 : 0.0;
    }

    private Double formatDouble(double value) {
        String valueString = String.valueOf(value);
        String decimalSide = valueString.split("\\.")[1];
        int remainingDecimals = 0;
        if(decimalSide.length() > 5) {
            remainingDecimals = decimalSide.length() - 5;
        }
        return Double.parseDouble(valueString.substring(0, valueString.length()-remainingDecimals));
    }

}
