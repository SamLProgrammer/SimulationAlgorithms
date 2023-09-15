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
        this.probability = probability;
        this.mappedProbability = mappedProbability;
    }

    public double calculateError() {
        return error = ((occurrences - mappedProbability) * (occurrences - mappedProbability)) / mappedProbability;
    }

    public String[] getTableRow() {
        String[] tableRow = {handName, 
            String.valueOf(occurrences), 
            String.valueOf(probability), 
            String.valueOf(mappedProbability),
            String.valueOf(error)};
        return tableRow;
    }
}
