package it.studio_java8.esercitazioni.utils;

import java.util.Random;

public class GeneratoreDouble {
    public static double get() {
        Random r = new Random();
        int rangeMin = 10;
        int rangeMax = 1000;

        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
}
