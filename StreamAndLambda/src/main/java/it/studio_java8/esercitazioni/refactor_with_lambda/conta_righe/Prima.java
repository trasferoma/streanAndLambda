package it.studio_java8.esercitazioni.refactor_with_lambda.conta_righe;

public class Prima {
    public static void main(String[] args) {
        String[] buffer = new String[] {"riga 1", "riga 2", "elemento 3"};

        int contatore = 0;

        for (String elemento : buffer) {
            if (elemento.contains("elemento")) {
                contatore++;
            }
        }

        System.out.println("Torvate " + contatore + " occorrenze");
    }
}
