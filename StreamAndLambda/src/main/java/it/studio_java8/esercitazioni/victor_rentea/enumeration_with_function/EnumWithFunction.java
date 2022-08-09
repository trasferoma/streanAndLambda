package it.studio_java8.esercitazioni.victor_rentea.enumeration_with_function;

import java.util.function.BiFunction;
import it.studio_java8.esercitazioni.victor_rentea.enumeration_with_function.EnumWithFunction.Type;

public class EnumWithFunction {
    enum Type {
        // @formatter:off
        REGULAR((service, day) -> service.computeRegular(day)), 
        NEW_RELEASE((service, day) -> service.computeNewRelease(day)), 
        CHILDREN(MyService::computeChildren);
        // @formatter:on

        public BiFunction<MyService, Integer, Integer> algoritmo;

        private Type(BiFunction<MyService, Integer, Integer> algoritmo) {
            this.algoritmo = algoritmo;
        }
    }

    public Type type;

    public EnumWithFunction(Type type) {
        super();
        this.type = type;
    }

    public static void main(String[] args) {

        MyService myService = new MyService();

        System.out.println("=====: " + myService.computePrice(EnumWithFunction.Type.REGULAR, 3));
        System.out.println("=====: " + myService.computePrice(EnumWithFunction.Type.NEW_RELEASE, 3));
        System.out.println("=====: " + myService.computePrice(EnumWithFunction.Type.CHILDREN, 3));
    }
}


class MyService {
    public int computeRegular(int day) {
        return day + 1;
    }

    public int computeNewRelease(int day) {
        return day * 2;
    }

    public int computeChildren(int day) {
        return 5;
    }

    public int computePrice(Type type, int day) {
        return type.algoritmo.apply(this, day);
    }
}
