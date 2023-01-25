package it.studio_java8.venkat_subramaniam.fluent_by_lambda;

import java.util.function.Consumer;
import lombok.ToString;

public class Esempio {
    @ToString
    static class Mailer {
        private String soggetto;
        private String body;
        private String from;
        private String to;

        private Mailer() {}

        public Mailer subject(String st) {
            soggetto = st;
            return this;
        }

        public Mailer body(String st) {
            body = st;
            return this;
        }

        public Mailer from(String st) {
            from = st;
            return this;
        }

        public Mailer to(String st) {
            to = st;
            return this;
        }

        public static void send(Consumer<Mailer> consumer) {
            Mailer m = new Mailer();
            consumer.accept(m);

            System.out.println("Invio: " + m);
        }
    }

    public static void main(String[] args) {
        Mailer.send(mailer -> mailer.from("xx@xx.xx")
                .to("yy@yy.yy")
                .subject("xxxxx")
                .body("testo"));
    }
}
