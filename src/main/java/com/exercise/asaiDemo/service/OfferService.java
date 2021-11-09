package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.offer.OfferInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to implement Offers logic.
 */
@Service
public class OfferService {

    private final List<OfferInterface> offers;
    public boolean ACTIVE_OFFERS;
    public OfferService(final List<OfferInterface> offers, @Value("${active-offers}") final List<String> activeOffersCodes) {

        // Just use active rules declared in application.properties
        this.offers = offers.stream()
                .filter(offer -> activeOffersCodes.contains(offer.getCode()))
                .collect(Collectors.toList());

        ACTIVE_OFFERS = offers.size() > 0;
    }

    public String printActiveOffers() {

        return offers.stream()
                .map(OfferInterface::getDescription)
                .collect(Collectors.joining(System.getProperty("line.separator")));
    }

    public Double calculateDiscount(List<Product> products) {

        return offers.stream()
                .mapToDouble(offer -> offer.calculate(products))
                .sum();
    }

}
