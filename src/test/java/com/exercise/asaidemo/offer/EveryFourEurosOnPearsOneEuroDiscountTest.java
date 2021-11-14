package com.exercise.asaidemo.offer;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.offerImpl.EveryFourEurosOnPearsOneEuroDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class EveryFourEurosOnPearsOneEuroDiscountTest {

    final EveryFourEurosOnPearsOneEuroDiscount everyFourEurosOnPearsOneEuroDiscount = new EveryFourEurosOnPearsOneEuroDiscount();

    @Test
    public void everyFourEurosOnPearsOneEuroDiscount_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("PEAR");
        product0.setPrice(BigDecimal.valueOf(10.5));
        product0.setQuantity(10);

        List<Product> products = List.of(product0);

        // when

        BigDecimal discount = everyFourEurosOnPearsOneEuroDiscount.calculate(products);

        // then

        Assertions.assertEquals(discount, BigDecimal.valueOf(26.25));
    }
}