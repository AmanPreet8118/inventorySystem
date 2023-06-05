package com.inventorySystem.controller;

import com.inventorySystem.exceptions.InventoryNotFoundException;
import com.inventorySystem.exceptions.ProductNotFoundException;
import com.inventorySystem.model.Inventory;
import com.inventorySystem.model.Product;
import com.inventorySystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestParam Integer inventoryId, @RequestBody Product product) throws InventoryNotFoundException {
        return adminService.addProduct(inventoryId,product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return adminService.getAllProducts();
    }

    @GetMapping("/inventoryProducts")
    public List<Product> getProductsByInventoryId(@RequestParam Integer inventoryId) throws InventoryNotFoundException {
        return adminService.getProductsByInventoryId(inventoryId);
    }

    @GetMapping("/getProduct/{productId}")
    public Product getProductById(@PathVariable int productId) throws ProductNotFoundException {
        return adminService.getProductById(productId);
    }
    @PostMapping("/createInventory")
    public boolean createInventory(@RequestBody Inventory inventory)
    {
        return adminService.createInventory(inventory);
    }
}
