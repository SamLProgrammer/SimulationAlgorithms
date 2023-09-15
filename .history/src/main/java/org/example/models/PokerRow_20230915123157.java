package org.example.models;

public class PokerRow {
    
    private String handName;
    private int occurrences;
    private double probability;
    private double mappedProbability;
    private double error;

    public PokerRow(String handName, int occurrences, double probability, double mappedProbability) {
        this.handName = handName;
        this.occurrences = occurrences;
        this.probability = formatDouble(probability);
        this.mappedProbability = formatDouble(mappedProbability);
        calculateError();
    }

    private double calculateError() {
        return error = ((occurrences - mappedProbability) * (occurrences - mappedProbability)) / mappedProbability;
    }

    public String[] getTableRow() {
        String[] tableRow = {handName, 
            String.valueOf(occurrences), 
            String.valueOf(probability), 
            String.valueOf(mappedProbability),
            String.valueOf(formatDouble(error))};
        return tableRow;
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
