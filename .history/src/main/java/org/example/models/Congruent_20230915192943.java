package org.example.models;

import java.util.ArrayList;

public class Congruent {

    public ArrayList<Double> fecadeStartCongruentGeneration(int x0, int k, int c, int g, int iteration, char type) {
        switch (type) {
            case 'a':
                return startCongruentGeneration(x0, k, c, Math.pow(2, g), iteration, new ArrayList<Double>());
            case 'l':
                return startCongruentGeneration(x0, (1 + 2 * k), c, Math.pow(2, g), iteration, new ArrayList<Double>());
            case 'm':
                return startCongruentGeneration(x0, (5 + 8 * k), c, Math.pow(2, g), iteration, new ArrayList<Double>());
        }
        return startCongruentGeneration(x0, (1 + 2 * k), c, Math.pow(2, g), iteration, new ArrayList<Double>());
    }

    public ArrayList<Double> startCongruentGeneration(double xi, double a, double c, double m, int iteration,
            ArrayList<Double> risList) {
        if (iteration > 0) {
            double nextSeed = (xi * a + c) % m;
            risList.add(nextSeed / (m));
            return startCongruentGeneration(nextSeed, a, c, m, iteration - 1, risList);
        }
        return risList;
    }

    public ArrayList<Double> concatArrays(ArrayList<Double> arr1, ArrayList<Double> arr2) {
        for (Double d : arr2) {
            arr1.add(d);
        }
        return arr1;
    }

    public ArrayList<Double> copyArray(ArrayList<Double> arr1) {
        ArrayList<Double> newArray = new ArrayList<>();
        for (Double d : arr1) {
            newArray.add(d);
        }
        return newArray;
    }
}
