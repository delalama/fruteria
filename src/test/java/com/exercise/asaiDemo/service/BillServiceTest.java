package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Fruit;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.fruit.BuyThreeApplesAndPayTwo;
import com.exercise.asaiDemo.offer.OfferInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

class BillServiceTest {

    final List<OfferInterface> offers = List.of(new BuyThreeApplesAndPayTwo());

    @Value("${active-offers}")
    final List<String> activeOffersCodes = Arrays.asList("0","1","2","3");

    final OfferService offerService = new OfferService(offers, activeOffersCodes);

    final BillService billService = new BillService(offerService) ;

    @Test
    public void BillService_test() {
        // given

        Fruit product0 = new Fruit();
        product0.setName("ORANGE");
        product0.setQuantity(11);
        product0.setPrice(10.0);

        List<Product> products = List.of(product0);

        // when

        Double total = billService.createFactura(products);

        // then

        Assertions.assertEquals(total, 110);
    }
}