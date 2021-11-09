package com.exercise.asaidemo.offer.fruit;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
public class FreeOrangePerTwoPears implements OfferInterface {

    @Override
    public <T extends Product> BigDecimal calculate(final List<T> products) {

        Integer orangesAmount = getAmount(products, "ORANGE");

        BigDecimal discount = BigDecimal.ZERO;

        if(orangesAmount == 0){
            return discount;
        }

        Integer pearsAmount = getAmount(products, "PEAR");

        if (pearsAmount > 1 ) {
            Integer freeOranges = pearsAmount / 2;

            BigDecimal orangesPrice = getOrangePrice(products);

            if (orangesAmount >= freeOranges) {
                discount = orangesPrice.multiply(BigDecimal.valueOf(freeOranges)) ;
            } else {
                discount = BigDecimal.valueOf(orangesAmount).multiply(orangesPrice);
            }
            log.info(getDescription() + " -> " + discount + " €.");

        }
        return discount;
    }

    private <T extends Product> BigDecimal getOrangePrice(List<T> products) {
        return products.stream()
                .filter(p -> p.getName().equals("ORANGE"))
                .map(Product::getPrice)
                .findFirst()
                .orElseThrow();
    }

    private <T extends Product> Integer getAmount(List<T> products, String orange) {
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
