package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.Fruit;
import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to access BillService
 */
@Controller
@RequestMapping(value = "/factura")
public class BillController {

    private final BillService facturaService;

    public BillController(BillService billService) {
        this.facturaService = billService;
    }

    @PostMapping(value = "/total", consumes = "application/json")
    @ResponseBody
    public Double createBill(@RequestBody List<Product> products) {

        return facturaService.createFactura(products);
    }

}
