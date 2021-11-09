package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuyThreeApplesAndPayTwo implements OfferInterface {

    @Override
    public Double calculate(final List<Product> products) {
        Integer applesAmount = calculateAmount(products);

        Double discount = 0D;

        if( applesAmount == 0 ){
            return discount;
        }

        List<Product> apples = products.stream()
                .filter(p -> p.getName().equals("APPLE"))
                .collect(Collectors.toList());

        discount = (applesAmount / 3) * apples.get(0).getPrice();

        if (discount > 0) {
            System.out.println(getDescription() + " -> " + discount + " €.");
        }

        return discount;
    }

    private Integer calculateAmount(List<Product> products) {
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
