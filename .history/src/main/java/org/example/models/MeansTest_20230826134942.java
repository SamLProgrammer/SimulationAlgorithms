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

    public void executeTest(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
        calculateVariables();
    }

    private void calculateVariables() {
        alphaRate = 100 - acceptanceRate;
        System.out.println("alphaRate");
        System.out.println(alphaRate);
        halfAlphaRate = alphaRate/200;
        System.out.println("halfAlphaRate");
        System.out.println(halfAlphaRate);
        relativeAlphaRate = 1.0 - halfAlphaRate;
        System.out.println("relativeAlphaRate");
        System.out.println(relativeAlphaRate);
        System.out.println("Zet");
        // zet = 
        System.out.println("====================");
    }

}
