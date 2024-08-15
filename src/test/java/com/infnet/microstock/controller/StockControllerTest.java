package com.infnet.microstock.controller;

import com.infnet.microstock.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockControllerTest {

    @Test
    void checkStockAvailable() {
        StockController stockController = new StockController();
        boolean isAvailable = stockController.checkStock("PROD001", 10);
        assertTrue(isAvailable, "Produto deveria estar disponível no estoque.");
    }

    @Test
    void decreaseStock() {
        StockController stockController = new StockController();
        stockController.decreaseStock("PROD001", 10);
        Product product = stockController.getStock().get("PROD001");
        assertEquals(90, product.getQuantity(), "Quantidade do produto deveria ser reduzida.");
    }
}