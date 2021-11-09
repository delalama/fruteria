package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Fruit;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.fruit.BuyThreeApplesAndPayTwo;
import com.exercise.asaiDemo.offer.OfferInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OfferServiceTest {

    final List<OfferInterface> offers = List.of(new BuyThreeApplesAndPayTwo());

    final List<String> activeOffersCodes = Arrays.asList("0","1","2","3");

    final OfferService offerService = new OfferService(offers, activeOffersCodes);

    @Test
    public void offerService_test () {
        // given

        // then

        assertTrue(offerService.ACTIVE_OFFERS);

        // when

        String offers = offerService.printActiveOffers();

        // then

        Assertions.assertEquals("0 - Buy 3 Apples and pay 2",offers);

        // when

        Fruit product0 = new Fruit();
        product0.setName("APPLE");
        product0.setPrice(10.5);
        product0.setQuantity(10);


        List<Product> products = List.of(product0);

        Double discount = offerService.calculateDiscount(products);

        // then

        Assertions.assertEquals(discount, 31.5);

    }
}