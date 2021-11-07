package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.repository.ProductDao;
import com.exercise.asaiDemo.entity.Bill;
import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service to isolate bill operations.
 * OfferService has been extracted in order to only have one place to
 * develop offers logic.
 */
@Service
public class BillService {

    ProductDao productDao;
    OfferService offerService;

    public BillService(ProductDao productDao, OfferService offerService) {
        this.productDao = productDao;
        this.offerService = offerService;
    }

    public Double createFactura(List<Product> products) {
        Double total = new Bill(products).getTotalPrice();

        return offerService.applyActiveOffers(products, total);
    }

}
