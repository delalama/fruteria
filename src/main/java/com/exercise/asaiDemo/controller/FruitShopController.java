package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.service.BillService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to serve thymeleaf content
 */
@Controller
@RequestMapping(value = "/shop")
public class FruitShopController {

    private final BillService facturaService;
    private final String businessName;

    public FruitShopController(BillService facturaService, @Value("${business.name}") String businessName) {
        this.facturaService = facturaService;
        this.businessName = businessName;
    }

    @RequestMapping()
    public String fuitShopInterface(final Model model) {

        model.addAttribute("nombre", businessName);
        return "shop";
    }
}
