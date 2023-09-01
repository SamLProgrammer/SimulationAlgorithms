package org.example.models;

import java.util.ArrayList;

public class RandomAlgorithms {

    private MiddleSquare middleSquare;
    private Congruent congruent;
    private ArrayList<Double> currentRandomList;

    public RandomAlgorithms() {
        initComponents();
    }

    private void initComponents() {
        middleSquare = new MiddleSquare();
        congruent = new Congruent();
    }

    public void generateWithMiddleSquare(int iterations, String seed) {
        currentRandomList = middleSquare.fecadeStartSquaresGeneration(iterations, seed);
    }

    public void generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        currentRandomList = congruent.fecadeStartCongruentGeneration(x0, k, c, g, iterations, type);
    }

    public int getN() {
        return currentRandomList.size();
    }

    public ArrayList<Double> getCurrentRandomList() {
        return currentRandomList;
    }
}
