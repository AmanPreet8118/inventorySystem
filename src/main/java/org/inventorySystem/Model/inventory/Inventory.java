package org.inventorySystem.Model.inventory;

import org.inventorySystem.exceptions.InvalidProductException;

import java.util.ArrayList;

public class Inventory {

    private String inventoryID;
    private ArrayList<Product> inventoryProductList;

    public ArrayList<Product> getInventoryProductList() {
        return inventoryProductList;
    }

    public Inventory(String id)
    {
        this.inventoryID=id;
        inventoryProductList=new ArrayList<>();
    }
    public String getInventoryID() {
        return inventoryID;
    }
    public boolean addProduct(Product product) throws InvalidProductException
    {
        if(product==null)
            throw new InvalidProductException("Invalid Product");

        if(inventoryProductList.add(product)) {
            return true;
        }

        return false;
    }

    public boolean deleteProduct(Product product) throws InvalidProductException
    {
        if(product==null)
                throw new InvalidProductException("Invalid Product Deletion");

        if(inventoryProductList.contains(product)) {
            inventoryProductList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList showProducts()
    {
        return inventoryProductList;
    }
}
