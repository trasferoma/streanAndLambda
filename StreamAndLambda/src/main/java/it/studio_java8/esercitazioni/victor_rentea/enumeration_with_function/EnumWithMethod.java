package it.studio_java8.esercitazioni.victor_rentea.enumeration_with_function;

public class EnumWithMethod {
    enum Type {
        REGULAR {
            @Override
            public int computePrice(int day) {
                return day + 1;
            }
        },
        NEW_RELEASE {
            @Override
            public int computePrice(int day) {
                return day * 2;
            }
        },
        CHILDREN {
            @Override
            public int computePrice(int day) {
                return 5;
            }
        };

        abstract public int computePrice(int day);
    }

    private Type type;

    public EnumWithMethod(Type type) {
        super();
        this.type = type;
    }

    public int computePrice(int day) {
        return type.computePrice(day);
    }

    public static void main(String[] args) {
        int prezzo = (new EnumWithMethod(EnumWithMethod.Type.REGULAR)).computePrice(5);

        System.out.println("=====: " + prezzo);
    }
}
