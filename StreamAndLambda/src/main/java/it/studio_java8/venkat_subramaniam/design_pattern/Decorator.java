package it.studio_java8.venkat_subramaniam.design_pattern;

import java.util.function.Function;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class Decorator {
    //    public static void main(String[] args) {
    //        Function<Integer, Integer> incrementa = e -> e + 1;
    //        Function<Integer, Integer> raddoppia = e -> e * 2;
    //
    //        esegui(3, "incrementa e raddoppia", incrementa.andThen(raddoppia));
    //    }
    //
    //    private static void esegui(int n, String msg, Function<Integer, Integer> func) {
    //        System.out.println(String.format("%d %s %d", n, msg, func.apply(n)));
    //    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Color {
        private int r;
        private int v;
        private int b;

        public Color schiarisci() {
            r -= 5;
            v -= 5;
            b -= 5;

            return this;
        }

        public Color scurisci() {
            r += 15;
            v += 15;
            b += 15;

            return this;
        }
    }

    public static class Camera {
        private Function<Color, Color> filtro;

        public Camera(Function<Color, Color>... filtri) {

            // Prima soluzione Imperativa
            //            filtro = input -> input;
            //
            //            for (Function<Color, Color> elemento : filtri) {
            //                filtro = filtro.andThen(elemento);
            //            }

            // seconda soluzione funzionale
            //            filtro = Stream.of(filtri)
            //                    .reduce(input -> input, (elemento, result) -> result.andThen(elemento));

            // ottimizzazione soluzione funzionale
            filtro = Stream.of(filtri)
                    .reduce(Function.identity(), Function::andThen);

        }

        public Color scatta(Color input) {
            return filtro.apply(input);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        printCamera(new Camera(Color::schiarisci));
        printCamera(new Camera(Color::scurisci));
        printCamera(new Camera(Color::schiarisci, Color::scurisci));
    }

    private static void printCamera(Camera camera) {
        System.out.println(camera.scatta(new Color(100, 100, 100)));

    }
}
