package it.studio_java8.esercitazioni.refactor_with_lambda.is_prime;

public class Prima {
    public static boolean isPrimo(int numero) {
        for (int i = 2; i < numero; i++) {
            if (numero % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Prima.isPrimo(1));
        System.out.println(Prima.isPrimo(2));
        System.out.println(Prima.isPrimo(3));
        System.out.println(Prima.isPrimo(4));
        System.out.println(Prima.isPrimo(5));
        System.out.println(Prima.isPrimo(6));
        System.out.println(Prima.isPrimo(7));
    }
}
