package it.studio_java8.interfaccia_funzionale.esercizi.trader_and_transactions;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;;

public class Esercizio {
    private Caricatore caricatore;
    private List<Transaction> transazioni;

    public Esercizio() {
        caricatore = new Caricatore();
        transazioni = caricatore.esegui();
    }

    public List<Transaction> getTransazioni() {
        return transazioni;
    }

    private void transazioni2011OrdinatePerValore() {
        System.out.println("===== Transazioni del 2011 Ordinate Per Valore");
        // @formatter:off
        getTransazioni().stream()
            .filter(e -> e.getYear() == 2011)
            .sorted(comparing(Transaction::getValue)) //.reversed())
            .forEach(System.out::println);

        // @formatter:on
    }

    private void tutteLeCitta() {
        System.out.println("===== Tutte le città");
        // @formatter:off
        getTransazioni().stream()
            .map(e -> e.getTrader().getCity())
            .distinct()
            .forEach(System.out::println);

        // @formatter:on
    }

    private void tuttiTradersDiCambridgeOrdinatiPerNome() {
        System.out.println("===== Tutti Traders Di Cambridge Ordinati Per Nome");
        // @formatter:off
        getTransazioni().stream()
            .filter(e -> e.getTrader().getCity().equals("Cambridge"))
            .sorted(comparing(e ->e.getTrader().getName()))
            .map(e -> e.getTrader().getName())
            .distinct()
            .forEach(System.out::println);

        // @formatter:on
    }


    private void stringFattaDaTuttiTradersOrdinatiPerNome() {
        System.out.println("===== Una stringa formata da Tutti Traders Ordinati Per Nome");

        // @formatter:off
        Optional<String> buffer = getTransazioni().stream()
            .map(e -> e.getTrader().getName())
            .sorted()
            .distinct()
            .reduce((a, b) -> a + ", " + b);
        
        System.out.println(buffer.get());
        
        // @formatter:on
    }

    private void esisteAlmenoUnTraderDiMilano() {
        System.out.println("===== Esiste Almeno Un Trader Di Milano");

        // @formatter:off
        Optional<Transaction> trovato = getTransazioni().stream()
            .filter(e -> e.getTrader().getCity().equals("Milan"))
            .findAny();
        
        System.out.println(trovato.get().getTrader().getName());
        
        // @formatter:on
    }

    private void tuttiValoriDiCambridge() {
        System.out.println("===== Tutti Valori Di Cambridge");

        // @formatter:off
        getTransazioni().stream()
            .filter(e -> e.getTrader().getCity().equals("Cambridge"))
            .map(e -> e.getValue())
            .forEach(System.out::println);
            ;
         // @formatter:on
    }

    private void valorePiuAlto() {
        System.out.println("===== Tutti Valori Di Cambridge");

        // @formatter:off
        OptionalLong optional = getTransazioni().stream()
            .mapToLong(e -> e.getValue())
            .max();
        
        System.out.println("il valore più grande è: " + optional.getAsLong());
        
        // @formatter:on
    }

    private void transazioneConValorePiuBasso() {
        System.out.println("===== transazione Con Valore Più Basso");

        // @formatter:off
        Optional<Transaction> optional = getTransazioni().stream()
            .reduce((a, b) -> a.getValue() < b.getValue() ? a : b);
        // @formatter:on

        System.out.println(optional.get());
    }

    public static void main(String[] args) {
        Esercizio esercizio = new Esercizio();

        esercizio.transazioni2011OrdinatePerValore();
        esercizio.tutteLeCitta();
        esercizio.tuttiTradersDiCambridgeOrdinatiPerNome();
        esercizio.stringFattaDaTuttiTradersOrdinatiPerNome();
        esercizio.esisteAlmenoUnTraderDiMilano();
        esercizio.tuttiValoriDiCambridge();
        esercizio.valorePiuAlto();
        esercizio.transazioneConValorePiuBasso();
    }
}
