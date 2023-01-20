package it.studio_java8.esercitazioni.esempio_lambda;

class EsempioEnumAbstract {
    public static void main(String[] args) {

        EnumEsempio tipoCalciatore = EnumEsempio.ATTACCANTE;
        tipoCalciatore.calcola();

    }

    public enum EnumEsempio {

        PORTIERE {
            @Override
            void calcola() {
                System.out.println("portiere");
            }
        },
        ATTACCANTE {
            @Override
            void calcola() {
                System.out.println("attaccante");
            }
        };

        abstract void calcola();
    }
}
