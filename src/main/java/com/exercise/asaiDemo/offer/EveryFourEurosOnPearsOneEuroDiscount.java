package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EveryFourEurosOnPearsOneEuroDiscount implements OfferInterface {

    @Override
    public Double calculate(final List<Product> products) {

        Integer pearsAmount = calculateAmount(products);

        Double discount = 0D;

        if( pearsAmount == 0 ){
            return discount;
        }

        Double pearsPrice = products.stream()
                .filter(p -> p.getName().equals("PEAR"))
                .findFirst()
                .map(Product::getPrice)
                .orElseThrow();

        Double pearsSpent = pearsPrice * pearsAmount;

        discount = pearsSpent / 4;

        if (discount > 0) {
            System.out.println(getDescription() + " -> " + discount + " €.");
        }

        return discount;
    }

    private Integer calculateAmount(List<Product> products) {
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
