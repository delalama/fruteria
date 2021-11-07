package com.exercise.asaiDemo.repository;

import com.exercise.asaiDemo.entity.Offer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "offer", ignoreInvalidFields = true)
@Getter
@Setter
public class OfferDao {
    private List<Offer> active;
}