package com.exercise.asaidemo.offer.offerImpl;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j(topic = "FRUIT SHOP")
public class EveryFourEurosOnPearsOneEuroDiscount implements OfferInterface {

    @Override
    public <T extends Product> BigDecimal calculate(final List<T> products) {

        Integer pearsAmount = calculateAmount(products);

        BigDecimal discount = BigDecimal.ZERO;

        if (pearsAmount == 0) {
            return discount;
        }

        BigDecimal pearsPrice = products.stream()
                .filter(p -> p.getName().equals("PEAR"))
                .findFirst()
                .map(Product::getPrice)
                .orElseThrow();

        BigDecimal pearsSpent = pearsPrice.multiply(BigDecimal.valueOf(pearsAmount));

        discount = pearsSpent.divide(BigDecimal.valueOf(4));

        if (discount.compareTo(BigDecimal.ZERO) == 1) {
            log.info(getDescription() + " -> " + discount + " €.");
        }

        return discount;
    }

    private <T extends Product> Integer calculateAmount(List<T> products) {
        return products.stream()
                .filter(p -> p.getName().equals("PEAR"))
                .map(Product::getQuantity)
                .reduce(0, Integer::sum);
    }

    @Override
    public String getCode() {
        return "1";
    }

    @Override
    public String getName() {
        return "For every 4 € spent on Pears, we will deduct one euro from your final invoice";
    }
}
