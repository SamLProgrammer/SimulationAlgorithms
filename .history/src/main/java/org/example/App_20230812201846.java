package org.example;

import org.example.models.StatisticFunctions;

public class App {

    public static void main(String[] args) {
        StatisticFunctions sf = new StatisticFunctions();
        System.out.println(sf.getNormSINV(0.975));
    }

    
}
