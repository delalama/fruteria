package com.exercise.asaidemo.offer;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.offerImpl.FreeOrangePerTwoPears;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class FreeOrangePerTwoPearsTest {

    final FreeOrangePerTwoPears freeOrangePerTwoPears = new FreeOrangePerTwoPears();

    @Test
    public void freeOrangePerTwoPears_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("PEAR");
        product0.setPrice(BigDecimal.valueOf(10.5));
        product0.setQuantity(10);

        List<Product> products = List.of(product0);

        // when

        BigDecimal discount = freeOrangePerTwoPears.calculate(products);

        // then

        Assertions.assertTrue(discount.equals(BigDecimal.ZERO));

        // given
        Fruit product1 = new Fruit();
        product1.setName("ORANGE");
        product1.setPrice(BigDecimal.valueOf(10.5));
        product1.setQuantity(10);

        // when

        List<Product> products2 = Arrays.asList(product0, product1);

        BigDecimal discount2 = freeOrangePerTwoPears.calculate(products2);

        // then

        Assertions.assertTrue(discount2.equals(BigDecimal.valueOf(52.5)));

    }
}