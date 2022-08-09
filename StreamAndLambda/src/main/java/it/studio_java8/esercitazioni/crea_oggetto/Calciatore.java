package it.studio_java8.esercitazioni.crea_oggetto;

import java.util.function.Consumer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Calciatore {
    private int tiro;
    private int corsa;

    public Calciatore tiro(int valore) {
        tiro = valore;
        return this;
    }

    public Calciatore corsa(int valore) {
        corsa = valore;
        return this;
    }

    public static Calciatore crea(Consumer<Calciatore> block) {
        Calciatore calciatore = new Calciatore();
        block.accept(calciatore);
        return calciatore;
    }

    public static void main(String[] args) {

        Calciatore calciatore = Calciatore.crea(c -> c.tiro(10).corsa(6));
        Calciatore calciatore2 = Calciatore.crea(c -> c.corsa(9));

        System.out.println(calciatore);
        System.out.println(calciatore2);
    }
}
