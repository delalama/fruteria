package com.exercise.asaidemo.service;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BillServiceTest {

    @Autowired
    BillService billService;

    @Test
    public void BillService_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("ORANGE");
        product0.setQuantity(11);
        product0.setPrice(BigDecimal.valueOf(10.0));

        List<Product> products = List.of(product0);

        // when

        BigDecimal total = billService.createFactura(products);

        // then

        Assertions.assertTrue(total.equals(BigDecimal.valueOf(38.5)));
    }
}