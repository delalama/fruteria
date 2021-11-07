package com.exercise.asaiDemo.controller;

import com.exercise.asaiDemo.entity.Product;
import com.exercise.asaiDemo.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to access BillService
 */
@Controller()
@RequestMapping(value = "/factura")
public class BillController {

    BillService facturaService;

    public BillController(BillService billService) {
        this.facturaService = billService;
    }

    @RequestMapping(value = "/total", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Double sendPostMessage(@RequestBody List<Product> products) {
        return facturaService.createFactura(products);
    }

}
