package org.example;

import java.util.ArrayList;

import org.example.models.MiddleSquare;
import org.example.models.StatisticFunctions;

public class App {

    public static void main(String[] args) {
        StatisticFunctions sf = new StatisticFunctions();
        MiddleSquare ms = new MiddleSquare();
        ArrayList<Double> uniformNumbersList = ms.fecadeStartSquaresGeneration(20, "7351");
        printArrayList(uniformNumbersList);

    }

    public static void printArrayList(ArrayList<Double> arrayList) {
        for (Double double1 : arrayList) {
            System.out.println(double1);
        }
    }

    
}
