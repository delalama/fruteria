package com.exercise.asaiDemo.service;

import com.exercise.asaiDemo.repository.ProductDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
class FacturaServiceTest {

    ProductDao testProperties = new ProductDao();
    OfferService offerService = new OfferService();

    BillService facturaService = new BillService(testProperties, offerService);

    @Test
    public void factura_test() {
        //given

        //when
//        Factura factura = facturaService.createFactura();

        //then
//        Assertions.assertNotNull(factura);
    }

}