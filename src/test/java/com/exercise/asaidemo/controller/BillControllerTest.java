package com.exercise.asaidemo.controller;

import com.exercise.asaidemo.entity.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BillControllerTest {

    @Autowired
    BillController billController ;

    @Test
    public void BillController_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("ORANGE");
        product0.setQuantity(11);
        product0.setPrice(BigDecimal.valueOf(10.0));

        List<Fruit> products = List.of(product0);

        // when

        BigDecimal total = billController.createBill(products);

        // then

        Assertions.assertTrue(total.equals(BigDecimal.valueOf(110.0)));
    }
}