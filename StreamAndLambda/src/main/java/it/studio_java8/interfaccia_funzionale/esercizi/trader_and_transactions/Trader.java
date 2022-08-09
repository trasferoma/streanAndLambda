package it.studio_java8.interfaccia_funzionale.esercizi.trader_and_transactions;

public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader [name=" + name + ", city=" + city + "]";
    }
}
