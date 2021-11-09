package com.exercise.asaiDemo.offer;

import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FreeOrangePerTwoPears implements OfferInterface {

    @Override
    public Double calculate(final List<Product> products) {

        Integer orangesAmount = getAmount(products, "ORANGE");

        Double discount = 0D;

        if(orangesAmount == 0){
            return discount;
        }

        Integer pearsAmount = getAmount(products, "PEAR");

        if (pearsAmount > 1 ) {
            Integer freeOranges = pearsAmount / 2;

            Double orangesPrice = getOrangePrice(products);

            if (orangesAmount >= freeOranges) {
                discount = freeOranges * orangesPrice;
            } else {
                discount = orangesAmount * orangesPrice;
            }
            System.out.println(getDescription() + " -> " + discount + " €.");

        }
        return discount;
    }

    private Double getOrangePrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.getName().equals("ORANGE"))
                .map(Product::getPrice)
                .findFirst()
                .orElseThrow();
    }

    private Integer getAmount(List<Product> products, String orange) {
        return products.stream()
                .filter(p -> p.getName().equals(orange))
                .map(Product::getQuantity)
                .reduce(0, Integer::sum);
    }

    @Override
    public String getCode() {
        return "2";
    }

    @Override
    public String getName() {
        return "Free Orange for every 2 Pears you buy";
    }
}
