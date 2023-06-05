package com.inventorySystem.service;

import com.inventorySystem.exceptions.InventoryNotFoundException;
import com.inventorySystem.exceptions.ProductNotFoundException;
import com.inventorySystem.model.Inventory;
import com.inventorySystem.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    boolean addProduct(Integer inventoryId,Product product) throws InventoryNotFoundException;
    List<Product> getAllProducts();
    boolean createInventory(Inventory inventory);

    List<Product> getProductsByInventoryId(Integer inventoryId) throws InventoryNotFoundException;

    Product getProductById(Integer productId) throws ProductNotFoundException;
}
