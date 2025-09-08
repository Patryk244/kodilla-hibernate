package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InvoiceDaoTestSuite {
    @Autowired
    private  InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        Product product1 = new Product("Laptop");
        Product product2 = new Product("Mouse");
        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal("2500.00"), 1, new BigDecimal("2500.00"));
        Item item2 = new Item(product2, new BigDecimal("100.00"), 2, new BigDecimal("200.00"));

        Invoice invoice = new Invoice("FV/2025/09/01");
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        invoiceDao.save(invoice);
        int id = invoice.getId();

        assertTrue(id > 0);
        assertEquals(2, invoice.getItems().size());


        invoiceDao.deleteById(id);
        productDao.deleteAll();

    }
}