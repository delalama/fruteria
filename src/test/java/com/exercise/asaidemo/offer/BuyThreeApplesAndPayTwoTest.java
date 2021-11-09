package com.exercise.asaidemo.offer;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.fruit.BuyThreeApplesAndPayTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class BuyThreeApplesAndPayTwoTest {

    final BuyThreeApplesAndPayTwo buyThreeApplesAndPayTwo = new BuyThreeApplesAndPayTwo();

    @Test
    public void buyThreeApplesAndPayTwo_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("APPLE");
        product0.setPrice(BigDecimal.valueOf(10.5));
        product0.setQuantity(10);

        List<Product> products = List.of(product0);

        // when

        BigDecimal discount = buyThreeApplesAndPayTwo.calculate(products);

        // then

        Assertions.assertTrue(discount.equals(BigDecimal.valueOf(31.5)));
    }
}