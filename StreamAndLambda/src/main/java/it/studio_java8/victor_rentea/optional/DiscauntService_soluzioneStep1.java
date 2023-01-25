package it.studio_java8.victor_rentea.optional;

import it.studio_java8.esercitazioni.victor_rentea.optional.pojo.Customer;
import it.studio_java8.esercitazioni.victor_rentea.optional.pojo.MemberCard;

public class DiscauntService_soluzioneStep1 {
    public String getDiscauntPercentage(Customer customer) {

        Integer discauntPercentage = getDiscauntPercentage(customer.getMemberCard().get());

        if (discauntPercentage != null) {
            return "Discount: " + discauntPercentage;
        } else {
            return "";
        }
    }

    private Integer getDiscauntPercentage(MemberCard card) {
        if (card.getFedelityPoints() >= 100) {
            return 5;
        }

        if (card.getFedelityPoints() >= 50) {
            return 3;
        }

        return null;
    }

    public static void main(String[] args) {
        DiscauntService_soluzioneStep1 discauntService = new DiscauntService_soluzioneStep1();

        System.out.println(discauntService.getDiscauntPercentage(new Customer(new MemberCard(60))));
        System.out.println(discauntService.getDiscauntPercentage(new Customer(new MemberCard(10))));
    }
}
