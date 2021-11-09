package com.exercise.asaiDemo.repository;

import com.exercise.asaiDemo.entity.Product;
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
@ConfigurationProperties(prefix = "purchase", ignoreInvalidFields = true)
@Getter
@Setter
public class ProductRepository {

    private List<Product> products;
}