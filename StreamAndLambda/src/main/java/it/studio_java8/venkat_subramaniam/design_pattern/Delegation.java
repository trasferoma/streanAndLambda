package it.studio_java8.venkat_subramaniam.design_pattern;

import java.util.function.Supplier;

public class Delegation {

    static class Lazy<T> {
        private T cache;
        private Supplier<T> supplier;

        public Lazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        public T get() {
            if (cache == null) {
                cache = supplier.get();
            }

            return cache;
        }
    }

    public static void main(String[] args) {

        int x = 14;

        Lazy<Integer> lazy = new Lazy<>(() -> compute(x));

        if (x > 4 && lazy.get() > 7) {
            System.out.println("Path A " + lazy.get());
        } else {
            System.out.println("Path B");
        }

    }

    private static int compute(int x) {
        System.out.println("Chiamato....");
        return x * 2;
    }
}
