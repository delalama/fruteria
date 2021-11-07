package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.ProductDTO;
import com.exercise.asaiDemo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductController {
    @Autowired
    FacturaService facturaService;

    @Autowired
    Environment env;

    @PostMapping("/saveProduct")
    public String saveDetails(@RequestParam("productName") String productName,
                              @RequestParam("productPrice") String productPrice,
                              @RequestParam("productQuantity") String productQuantity,
                              ModelMap modelMap) {
        ProductDTO product = new ProductDTO();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setQuantity(productQuantity);

        modelMap.put("employeeName", "hola");
        modelMap.put("employeeEmail", "email");
        return "viewDetails";
    }
}
