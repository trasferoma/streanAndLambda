package it.studio_java8.esercitazioni.refactor_with_lambda.catena_di_predicati;

import java.util.function.Predicate;

public class Dopo {
    public static void evaluate(DaValutare applicant, Predicate<DaValutare> evaluator) {
        String result = evaluator.test(applicant) ? "accepted" : "rejected";
        System.out.println("Risultato: " + result);
    }

    public static void main(String[] args) {
        DaValutare applicant = new DaValutare();

        Predicate<DaValutare> creditEvaluator = a -> a.getCreditScore() > 600;
        Predicate<DaValutare> criminalEvaluator = a -> !a.hasCriminalRecord();
        Predicate<DaValutare> employerEvaluator = a -> a.getEmployementYear() > 0;
        Predicate<DaValutare> qualifierEvaluator = a -> a.isCredible();

        evaluate(applicant, creditEvaluator.and(qualifierEvaluator));
        evaluate(applicant, creditEvaluator.and(employerEvaluator).and(qualifierEvaluator));
        evaluate(applicant, criminalEvaluator.and(employerEvaluator).and(qualifierEvaluator));
        evaluate(applicant, criminalEvaluator.and(criminalEvaluator).and(employerEvaluator).and(qualifierEvaluator));
    }
}


class DaValutare {
    public boolean isCredible() {
        return true;
    }

    public int getCreditScore() {
        return 700;
    }

    public int getEmployementYear() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }
}
