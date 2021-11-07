package com.exercise.asaiDemo.repository;

import com.exercise.asaiDemo.entity.Offer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * This class emulates the behaviour of a repository.
 * In this case we only want static data that we found in application.yml
 */
@Component
@ConfigurationProperties(prefix = "offer", ignoreInvalidFields = true)
@Getter
@Setter
public class OfferDao {
    private List<Offer> active;
}