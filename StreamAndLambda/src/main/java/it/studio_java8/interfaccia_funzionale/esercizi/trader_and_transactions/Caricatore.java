package it.studio_java8.interfaccia_funzionale.esercizi.trader_and_transactions;

import java.util.Arrays;
import java.util.List;

public class Caricatore {
    public List<Transaction> esegui() {
        Trader raol = new Trader("Raol", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        // @formatter:off
        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raol, 2012, 1000),
                new Transaction(raol, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
                );
        // @formatter:on
    }
}
