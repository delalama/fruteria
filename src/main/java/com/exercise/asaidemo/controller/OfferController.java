package com.exercise.asaidemo.controller;

import com.exercise.asaidemo.entity.Offer;
import com.exercise.asaidemo.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OfferController {

    OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/Offers")
    public ResponseEntity<List<Offer>> getAllOffers() {
        try {
            List<Offer> offers = offerService.getAllOffers();

            return offers.isEmpty() ?
                    new ResponseEntity<>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(offers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Offers/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") long id) {
        Offer offer = offerService.getOffersById(id);

        return offer == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(offer, HttpStatus.OK);

    }

    @PostMapping("/Offers")
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer postedOffer = offerService.postOffer(offer);

        return postedOffer == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(offer, HttpStatus.OK);
    }

//    @PutMapping("/Offers/{id}")
//    public ResponseEntity<Offer> updateOffer(@PathVariable("id") long id, @RequestBody Offer offer) {
//        Optional<Offer> OfferData = offerRepository.findById(id);
//
//        if (OfferData.isPresent()) {
//            Offer _Offer = OfferData.get();
//            _Offer.setName(offer.getName());
//            _Offer.setFact(offer.getFact());
//            _Offer.setConsequence(offer.getConsequence());
//            return new ResponseEntity<>(offerRepository.save(_Offer), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/Offers/{id}")
//    public ResponseEntity<HttpStatus> deleteOffer(@PathVariable("id") long id) {
//        try {
//            offerRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/Offers")
//    public ResponseEntity<HttpStatus> deleteAllOffers() {
//        try {
//            offerRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @GetMapping("/Offers/published")
//    public ResponseEntity<List<Offer>> findByPublished() {
//        try {
//            List<Offer> offers = offerRepository.findByName("ThreePerTwo");
//
//            if (offers.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(offers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}