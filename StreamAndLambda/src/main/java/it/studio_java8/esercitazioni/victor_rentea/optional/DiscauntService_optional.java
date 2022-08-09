package it.studio_java8.esercitazioni.victor_rentea.optional;

import java.util.Optional;
import it.studio_java8.esercitazioni.victor_rentea.optional.pojo.Customer;
import it.studio_java8.esercitazioni.victor_rentea.optional.pojo.MemberCard;

public class DiscauntService_optional {
    public String getDiscauntPercentage(Customer customer) {
        return customer.getMemberCard()
                .flatMap(card -> getDiscauntPercentage(card))
                .map(d -> "Discount: " + d)
                .orElse("");
    }

    private Optional<Integer> getDiscauntPercentage(MemberCard card) {
        if (card.getFedelityPoints() >= 100) {
            return Optional.of(5);
        }

        if (card.getFedelityPoints() >= 50) {
            return Optional.of(3);
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        DiscauntService_optional discauntService = new DiscauntService_optional();

        System.out.println(discauntService.getDiscauntPercentage(new Customer(new MemberCard(60))));
        System.out.println(discauntService.getDiscauntPercentage(new Customer(new MemberCard(10))));
    }
}
