package com.exercise.asaidemo.repository;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.entity.Price;
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
@ConfigurationProperties(prefix = "productprices", ignoreInvalidFields = true)
@Getter
@Setter
public class PriceRepository {

    private List<Price> prices;

    public PriceRepository(List<Price> prices) {
        this.prices = prices;
    }

    public PriceRepository() {
    }
}

