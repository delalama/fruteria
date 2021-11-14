package com.exercise.asaidemo.offer.offerImpl;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j(topic = "FRUIT SHOP")
public class OneEuroIfThreeDifferentProducts implements OfferInterface {

    public <T extends Product> BigDecimal calculate(final List<T> products) {

        final long differentItems = products.stream()
                .filter(fruit -> fruit.getQuantity() > 0)
                .map(Product::getName)
                .distinct()
                .count();

        BigDecimal discount = BigDecimal.ZERO;
        if (differentItems >= 3) {
            discount = BigDecimal.ONE;
            log.info(getDescription() + " -> " + discount + " €.");
        }

        return discount;
    }

    @Override
    public String getCode() {
        return "3";
    }

    @Override
    public String getName() {
        return "One Euro If Three Different Products";
    }
}
