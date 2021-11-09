package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OneEuroIfThreeDifferentProducts implements OfferInterface {

    public Double calculate(final List<Product> products) {

        final long differentItems = products.stream()
                .filter(fruit -> fruit.getQuantity() > 0 )
                .map(Product::getName)
                .distinct()
                .count();

        Double discount = 0D ;
        if (differentItems >= 3) {
            discount += 1D;
            System.out.println(getDescription() + " -> " + discount + " €.");
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
