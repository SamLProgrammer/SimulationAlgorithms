package org.example.models;

import java.util.ArrayList;

public class RandomAlgorithms {

    private MiddleSquare middleSquare;
    private Congruent congruent;

    public RandomAlgorithms() {
        initComponents();
    }

    private void initComponents() {
        middleSquare = new MiddleSquare();
        congruent = new Congruent();
    }

    public ArrayList<Double> generateWithMiddleSquare(int iterations, String seed) {
        return middleSquare.fecadeStartSquaresGeneration(iterations, seed);
    }

    public ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        return congruent.fecadeStartCongruentGeneration(x0, k, c, g, iterations, type);
    }
}
