package com.exercise.asaidemo.controller;

import com.exercise.asaidemo.entity.Fruit;
import com.exercise.asaidemo.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller to access BillService
 */
@Controller
@RequestMapping(value = "/factura")
@AllArgsConstructor
public class BillController {

    private final BillService facturaService;

    @PostMapping(value = "/total", consumes = "application/json")
    @ResponseBody
    public BigDecimal createBill(@RequestBody List<Fruit> products) {

        return facturaService.createFactura(products);
    }

}
