package it.studio_java8.esercitazioni.victor_rentea.enumeration_with_function;

public class Test {
    enum Tipologia {
        CASO_A {
            @Override
            void azione() {
                System.out.println("caso A");
            }
        },
        CASO_B {
            @Override
            void azione() {
                System.out.println("caso B");
            }
        },
        CASO_C {
            @Override
            void azione() {
                System.out.println("caso C");
            }
        };

        abstract void azione();
    }

    public static void main(String[] args) {
        Tipologia tipo = Tipologia.CASO_A;
        tipo.azione();
    }
}
