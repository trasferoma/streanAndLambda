package it.studio_java8.interfaccia_funzionale.prove;

public class CostruisciOggettoConLamda {
    public static void main(String[] args) {


    }

    class Utente {
        public String nome;
        public String cognome;
        public String indirizzo;

        private Utente() {
            super();
        }

        public Utente crea(String nome, String cognome, String indirizzo) {
            // @formatter:off
            return new Utente()
                    .setNome(nome)
                    .setCognome(cognome)
                    .setIndirizzo(indirizzo);
            // @formatter:on
        }

        public String getNome() {
            return nome;
        }

        private Utente setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public String getCognome() {
            return cognome;
        }

        private Utente setCognome(String cognome) {
            this.cognome = cognome;
            return this;
        }

        public String getIndirizzo() {
            return indirizzo;
        }

        private Utente setIndirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }
    }
}
