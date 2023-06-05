package com.inventorySystem.repository;

import com.inventorySystem.exceptions.InventoryNotFoundException;
import com.inventorySystem.exceptions.ProductNotFoundException;
import com.inventorySystem.model.Inventory;
import com.inventorySystem.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InventoryRepository {
    private HashMap<Integer, List<Product> >inventoryProductHashMap;
    List<Product> productList;
    List<Inventory> inventoryList;
    public InventoryRepository()
    {
        productList=new ArrayList<>();
        inventoryList=new ArrayList<>();
        inventoryProductHashMap=new HashMap<>();
    }

    public boolean addProduct(Integer inventoryId,Product product) throws InventoryNotFoundException
    {
        if(inventoryProductHashMap.containsKey(inventoryId)==false)
             throw new InventoryNotFoundException("Inventory Does Not Exist");

        productList.add(product);
        inventoryProductHashMap.get(inventoryId).add(product);
        return true;
    }
    public List<Product> getProductList() {
        return productList;
    }

    public boolean addInventory(Inventory inventory)
    {
        inventoryList.add(inventory);
        inventoryProductHashMap.put(inventory.getId(),new ArrayList<>());
        return true;
    }

    public List<Product> getProductsByInventoryId(Integer inventoryId) throws InventoryNotFoundException {
        if(inventoryProductHashMap.containsKey(inventoryId)==false)
                throw new InventoryNotFoundException("Invalid inventory");

        return inventoryProductHashMap.get(inventoryId);
    }

    public Product getProductById(Integer productId) throws ProductNotFoundException {
        for(Product product:productList)
        {
            if(product.getId()==productId)
                    return product;
        }
        throw new ProductNotFoundException("Invalid Product Id");
    }
}
