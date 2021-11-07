package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.service.BillService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to serve thymeleaf content
 */
@Controller
@RequestMapping(value = "/shop")
public class FruitShopController {

    BillService facturaService;
    Environment env;

    public FruitShopController(BillService facturaService, Environment env) {
        this.facturaService = facturaService;
        this.env = env;
    }

    @RequestMapping()
    public String fuitShopInterface(final Model model) {
        model.addAttribute("nombre", env.getProperty("business.name"));
        return "shop";
    }
}
