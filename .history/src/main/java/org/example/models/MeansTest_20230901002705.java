package org.example.models;

public class MeansTest {
    private StatisticFunctions statisticFunctions;
    private double acceptanceRate;
    private double alphaRate;
    private double halfAlphaRate;
    private double relativeAlphaRate;
    private double zet;

    public MeansTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    public double[] executeTest(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
        calculateVariables();
        double[] statsVector = new double[]{alphaRate, halfAlphaRate, relativeAlphaRate, zet};
        return statsVector;
    }

    private void calculateVariables() {
        alphaRate = 100 - acceptanceRate;
        halfAlphaRate = alphaRate/200;
        relativeAlphaRate = 1.0 - halfAlphaRate;
        zet = Double.parseDouble(statisticFunctions.getNormSINV(relativeAlphaRate).replace(',', '.'));
    }

}
