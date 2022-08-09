package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.List;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Verifica se esistono traders a milano

public class EsisteQualcheTraderSuMilano {

    @Getter
    private List<Transaction> transazioni = null;

    public EsisteQualcheTraderSuMilano() {
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
        EsisteQualcheTraderSuMilano esercizio = new EsisteQualcheTraderSuMilano();

        boolean trovato = esercizio.getTransazioni()
                .stream()
                .anyMatch(e -> e.getTrader().getCity().equals("Milano"));

        System.out.println(trovato);
    }
}
