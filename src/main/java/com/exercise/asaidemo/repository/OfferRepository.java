package com.exercise.asaidemo.repository;

import com.exercise.asaidemo.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByName(String name);

    List<Offer> findByFact(String fact);

    Iterable<Object> findByNameContaining(String title);
}
