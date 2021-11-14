package com.exercise.asaidemo.service;

import com.exercise.asaidemo.entity.Offer;
import com.exercise.asaidemo.entity.Product;
import com.exercise.asaidemo.offer.OfferInterface;
import com.exercise.asaidemo.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to implement Offers logic.
 */
@Service
public class OfferService {

    private final List<OfferInterface> offers;
    public final boolean ACTIVE_OFFERS;
    private final OfferRepository offerRepository;

    public OfferService(final List<OfferInterface> offers,
                        @Value("${active-offers}") final List<String> activeOffersCodes,
                        OfferRepository offerRepository) {

        // Just use active rules declared in application.properties
        this.offers = offers.stream()
                .filter(offer -> activeOffersCodes.contains(offer.getCode()))
                .collect(Collectors.toList());

        ACTIVE_OFFERS = offers.size() > 0;

        this.offerRepository = offerRepository;
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

    public List<Offer> getAllOffers() {
        List<Offer> offers = new ArrayList<>();
        offerRepository.findAll().stream()
                .forEach(o -> offers.add(o));

        return offers.isEmpty() ?
                new ArrayList<Offer>()
                : offers;
    }

    public Offer getOffersById(long id) {
        Offer offer = offerRepository.findById(id).get();

        return offer == null ?
                null : offer;
    }

    public Offer postOffer(Offer offer) {
        Offer _offer = offerRepository
                .save(offer);

        return _offer == null ?
                null : _offer;
    }
}
