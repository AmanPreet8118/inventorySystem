package com.inventorySystem.service.implementation;

import com.inventorySystem.exceptions.InventoryNotFoundException;
import com.inventorySystem.exceptions.ProductNotFoundException;
import com.inventorySystem.model.Inventory;
import com.inventorySystem.model.Product;
import com.inventorySystem.repository.InventoryRepository;
import com.inventorySystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public boolean addProduct(Integer inventoryId,Product product) throws InventoryNotFoundException {
        return inventoryRepository.addProduct(inventoryId,product);
    }

    @Override
    public List<Product> getAllProducts() {
        return inventoryRepository.getProductList();
    }

    @Override
    public boolean createInventory(Inventory inventory) {
        inventoryRepository.addInventory(inventory);
        return true;
    }

    @Override
    public List<Product> getProductsByInventoryId(Integer inventoryId) throws InventoryNotFoundException {
        return inventoryRepository.getProductsByInventoryId(inventoryId);
    }

    @Override
    public Product getProductById(Integer productId) throws ProductNotFoundException {
        return inventoryRepository.getProductById(productId);
    }
}
