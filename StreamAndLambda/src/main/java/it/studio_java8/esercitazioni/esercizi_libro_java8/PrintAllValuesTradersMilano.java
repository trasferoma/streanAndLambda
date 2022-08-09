package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.List;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Print tutti i valori dei traders di Milano.

public class PrintAllValuesTradersMilano {

    @Getter
    private List<Transaction> transazioni = null;

    public PrintAllValuesTradersMilano() {
        caricaListaTranzazioni();
    }

    public void caricaListaTranzazioni() {
        transazioni = Arrays.asList(
                new Transaction(2011, 10, new Trader("BBBB", "Roma")),
                new Transaction(2011, 10, new Trader("BBBB", "Milano")),
                new Transaction(2012, 1, new Trader("AAAA", "Roma")),
                new Transaction(2013, 2, new Trader("CCC", "Milano")),
                new Transaction(2014, 3, new Trader("DDD", "Bari")),
                new Transaction(2011, 1, new Trader("EEEE", "Milano")));
    }

    public static void main(String[] args) {
        PrintAllValuesTradersMilano esercizio = new PrintAllValuesTradersMilano();

        esercizio.getTransazioni()
                .stream()
                .filter(e -> e.getTrader().getCity().equals("Milano"))
                .map(e -> e.getValue())
                .forEach(System.out::println);
    }
}
