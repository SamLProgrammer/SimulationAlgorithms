package org.example;

import java.util.ArrayList;

import org.example.controller.Controller;
import org.example.models.Congruent;
import org.example.models.MiddleSquare;
import org.example.models.StatisticFunctions;

public class App {

    public static void main(String[] args) {
        // StatisticFunctions sf = new StatisticFunctions();
        // MiddleSquare ms = new MiddleSquare();
        // Congruent cg = new Congruent();
        // // ArrayList<Double> uniformNumbersList = ms.fecadeStartSquaresGeneration(20, "7351");
        // ArrayList<Double> uniformNumbersList = cg.fecadeStartCongruentGeneration(6, 8, 5, 10, 50, 'l');
        // printArrayList(uniformNumbersList);

        new Controller();

    }

    public static void printArrayList(ArrayList<Double> arrayList) {
        for (Double double1 : arrayList) {
            System.out.println(double1);
        }
    }

    
}
