package it.studio_java8.esercitazioni.refactor_with_lambda.catena_di_predicati;

public class Prima {
    public static void evaluate(Applicant applicant, Evaluator evaluator) {
        String result = evaluator.evaluate(applicant) ? "accepted" : "rejected";
        System.out.println("Risultato: " + result);
    }

    public static void main(String[] args) {
        Applicant applicant = new Applicant();

        evaluate(applicant, new CreditEvaluator(new QualifiedEvaluetor()));

        evaluate(applicant, new CreditEvaluator(new EmployementEvaluator(new QualifiedEvaluetor())));

        evaluate(applicant, new CriminalRecordEvaluator(new EmployementEvaluator(new QualifiedEvaluetor())));

        evaluate(applicant, new CriminalRecordEvaluator(new CreditEvaluator(new EmployementEvaluator(new QualifiedEvaluetor()))));
    }
}


class Applicant {
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


interface Evaluator {
    boolean evaluate(Applicant applicant);
}


class QualifiedEvaluetor implements Evaluator {
    @Override
    public boolean evaluate(Applicant applicant) {
        return applicant.isCredible();
    }
}


class EvaluatorChain implements Evaluator {

    private Evaluator next;

    public EvaluatorChain(Evaluator next) {
        this.next = next;
    }

    @Override
    public boolean evaluate(Applicant applicant) {
        return this.next.evaluate(applicant);
    }
}


class CreditEvaluator extends EvaluatorChain {

    public CreditEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (applicant.getCreditScore() > 600) {
            return super.evaluate(applicant);
        }

        return false;
    }
}


class EmployementEvaluator extends EvaluatorChain {

    public EmployementEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (applicant.getEmployementYear() > 0) {
            return super.evaluate(applicant);
        }

        return false;
    }
}


class CriminalRecordEvaluator extends EvaluatorChain {
    public CriminalRecordEvaluator(Evaluator next) {
        super(next);
    }

    public boolean evaluate(Applicant applicant) {
        if (!applicant.hasCriminalRecord()) {
            return super.evaluate(applicant);
        }

        return false;
    }
}

