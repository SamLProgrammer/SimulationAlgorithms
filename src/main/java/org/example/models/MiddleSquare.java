package org.example.models;

import java.util.ArrayList;

public class MiddleSquare {

    public int getSeed(int length) {
        int random;
        do {
            random = (int)(Math.random()*Math.pow(10,length));
        }while(String.valueOf(random).length() < 4);
        return random;
    }

    public int intToSquare(int number) {
        return number*number;
    }

    public ArrayList<Double> fecadeStartSquaresGeneration(int iterations, String seed) {
        ArrayList<Double> risList = new ArrayList<>();
        return startSquaresGeneration(seed, iterations, risList);
    }
    public ArrayList<Double> startSquaresGeneration(String seedString, int iterations, ArrayList<Double> risList) {
        if(iterations > 0) {
            int seed = Integer.valueOf(seedString);
            int sqrdSeed = intToSquare(seed);
            sqrdSeed = (sqrdSeed < 1) ? sqrdSeed*-1 : sqrdSeed;
            String stringSqrdSeed = String.valueOf(sqrdSeed);

            while(stringSqrdSeed.length() < (seedString.length() * 2)) {
                stringSqrdSeed = '0' + stringSqrdSeed;
            }
            int firstPointer = stringSqrdSeed.length() / 2 - seedString.length() / 2;
            int secondPointer = firstPointer + seedString.length();

            String nextSeed = "";
            for (int i = firstPointer; i < secondPointer; i++) {
                nextSeed += stringSqrdSeed.charAt(i);
            }
            risList.add(Double.valueOf(nextSeed)/Math.pow(10,nextSeed.length()));

            return startSquaresGeneration(nextSeed, iterations-1, risList);
        }
        return risList;
    }
}

