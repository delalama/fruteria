package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.repository.OfferDao;
import com.exercise.asaiDemo.repository.ProductDao;
import com.exercise.asaiDemo.entity.Factura;
import com.exercise.asaiDemo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    ProductDao productDao;
    OfferService offerService;

    public FacturaService(ProductDao productDao, OfferService offerService) {
        this.productDao = productDao;
        this.offerService = offerService;
    }

    public Double createFactura(List<Product> products) {
        Double total = new Factura(products).getTotalPrice();

        return offerService.applyActiveOffers(products, total);
    }

}
