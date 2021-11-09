package com.exercise.asaidemo.offer.fruit;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class BuyThreeApplesAndPayTwo implements OfferInterface {

    public <T extends Product> BigDecimal calculate(final List<T> products) {
        Integer applesAmount = calculateAmount(products);

        BigDecimal discount = BigDecimal.valueOf(0);

        if( applesAmount == 0 ){
            return discount;
        }

        List<Product> apples = products.stream()
                .filter(p -> p.getName().equals("APPLE"))
                .collect(Collectors.toList());

        discount = BigDecimal.valueOf(applesAmount / 3).multiply(apples.get(0).getPrice());

        if (discount.compareTo(BigDecimal.ZERO) == 1 ) {
            log.info(getDescription() + " -> " + discount + " €.");
        }

        return discount;
    }

    private <T extends Product> Integer calculateAmount(List<T> products) {
        return products.stream()
                .filter(p -> p.getName().equals("APPLE"))
                .map(Product::getQuantity)
                .reduce(0, Integer::sum);
    }

    @Override
    public String getCode() {
        return "0";
    }

    @Override
    public String getName() {
        return "Buy 3 Apples and pay 2";
    }

}
