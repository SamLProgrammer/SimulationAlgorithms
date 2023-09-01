package org.example.models;

import java.util.ArrayList;

public class RandomAlgorithms {

    private MiddleSquare middleSquare;
    private Congruent congruent;
    private int n;

    public RandomAlgorithms() {
        initComponents();
    }

    private void initComponents() {
        middleSquare = new MiddleSquare();
        congruent = new Congruent();
    }

    public ArrayList<Double> generateWithMiddleSquare(int iterations, String seed) {
        int n = iterations;
        return middleSquare.fecadeStartSquaresGeneration(iterations, seed);
    }

    public ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        int n = iterations;
        return congruent.fecadeStartCongruentGeneration(x0, k, c, g, iterations, type);
    }

    public int getN() {
        return n;
    }
}
