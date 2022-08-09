package it.studio_java8.esercitazioni.victor_rentea.optional.pojo;

import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Customer {
    private MemberCard memberCard;

    public Optional<MemberCard> getMemberCard() {
        return Optional.ofNullable(memberCard);
    }
}
