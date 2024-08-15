package com.infnet.microstock.controller;

import com.infnet.microstock.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {

    private Map<String, Product> stock = new HashMap<>();

    // Inicializa alguns produtos no estoque
    public StockController() {
        stock.put("PROD001", new Product("PROD001", "Product 1", 100));
        stock.put("PROD002", new Product("PROD002", "Product 2", 200));
    }

    @GetMapping("/check")
    public boolean checkStock(@RequestParam String productCode, @RequestParam int quantity) {
        Product product = stock.get(productCode);
        return product != null && product.getQuantity() >= quantity;
    }

    @PostMapping("/decrease")
    public void decreaseStock(@RequestParam String productCode, @RequestParam int quantity) {
        Product product = stock.get(productCode);
        if (product != null && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
        }
    }

    @GetMapping("/quantity")
    public int getQuantity(@RequestParam String productCode) {
        Product product = stock.get(productCode);
        if (product != null) {
            return product.getQuantity();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    public Map<String, Product> getStock() {
        return stock;
    }
}
