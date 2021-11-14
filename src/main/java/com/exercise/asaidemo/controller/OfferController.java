package com.exercise.asaidemo.controller;

import com.exercise.asaidemo.entity.Offer;
import com.exercise.asaidemo.repository.OfferRepository;
import org.apache.poi.ss.formula.functions.Odd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @GetMapping("/Offers")
    public ResponseEntity<List<Offer>> getAllOffers(@RequestParam(required = false) String title) {
        try {
            List<Offer> offers = new ArrayList<Offer>();

            offerRepository.findAll().stream()
                            .forEach(o -> offers.add(o));

            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Offers/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") long id) {
        Optional<Offer> OfferData = offerRepository.findById(id);

        if (OfferData.isPresent()) {
            return new ResponseEntity<>(OfferData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Offers")
    public ResponseEntity<Offer> createOffer(@RequestBody Offer Offer) {
        try {
            Offer _Offer = offerRepository
                    .save(new Offer(Offer.getId(), Offer.getName(), Offer.getFact(), Offer.getConsequence()));
            return new ResponseEntity<>(_Offer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id") long id, @RequestBody Offer offer) {
        Optional<Offer> OfferData = offerRepository.findById(id);

        if (OfferData.isPresent()) {
            Offer _Offer = OfferData.get();
            _Offer.setName(offer.getName());
            _Offer.setFact(offer.getFact());
            _Offer.setConsequence(offer.getConsequence());
            return new ResponseEntity<>(offerRepository.save(_Offer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Offers/{id}")
    public ResponseEntity<HttpStatus> deleteOffer(@PathVariable("id") long id) {
        try {
            offerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Offers")
    public ResponseEntity<HttpStatus> deleteAllOffers() {
        try {
            offerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/Offers/published")
    public ResponseEntity<List<Offer>> findByPublished() {
        try {
            List<Offer> offers = offerRepository.findByName("ThreePerTwo");

            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}