package org.example;

import org.example.controller.Controller;

public class App {

    public static void main(String[] args) {

        Controller c = new Controller();
        c.generateWithCongruent(111, 251, 257, 13, 50, 'm', 5);
        c.invokePokerTest(95)
    }
}
