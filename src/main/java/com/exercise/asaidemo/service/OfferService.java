package com.exercise.asaidemo.service;

import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to implement Offers logic.
 */
@Service
public class OfferService {

    private final List<OfferInterface> offers;
    public final boolean ACTIVE_OFFERS;

    public OfferService(final List<OfferInterface> offers,
                        @Value("${active-offers}") final List<String> activeOffersCodes) {

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

    public <T extends Product> BigDecimal calculateDiscount(List<T> products) {

        return offers.stream()
                .map(offer -> offer.calculate((List<Product>) products))
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

}
