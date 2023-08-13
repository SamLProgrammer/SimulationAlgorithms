package org.example;

import org.example.models.MiddleSquare;
import org.example.models.StatisticFunctions;

public class App {

    public static void main(String[] args) {
        StatisticFunctions sf = new StatisticFunctions();
        MiddleSquare ms = new MiddleSquare();
        ms.fecadeStartSquaresGeneration(20, "3456");
    }

    
}
