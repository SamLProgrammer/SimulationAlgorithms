package org.example.models;

public class PokerRow {
    
    private String handName;
    private int occurrences;
    private double probability;
    private double mappedProbability;
    private double error;

    public PokerRow(String handName, int occurrences, double probability, double mappedProbability, double error) {
        this.handName = handName;
        this.occurrences = occurrences;
        this.probability = probability;
        this.mappedProbability = mappedProbability;
        this.error = error;
    }
}
