package org.inventorySystem.Model.account;

import org.inventorySystem.Model.inventory.Inventory;
import org.inventorySystem.Model.inventory.Product;
import org.inventorySystem.exceptions.InvalidInventoryException;
import org.inventorySystem.exceptions.InvalidProductException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin extends Account {

    private ArrayList<Inventory> inventoryList;
    private HashMap<String,ArrayList<Product>> inventoryProductHashMap;

    public Admin()
    {
        inventoryList=new ArrayList<>();
    }
    public ArrayList<Product> getInventoryProduct(Inventory inventory)
    {
        return inventory.showProducts();
    }
    public HashMap<String,ArrayList<Product> >getInventoriesProducts()
    {
        HashMap<String,ArrayList<Product>> productArrayList=new HashMap<>();
        for(Map.Entry<String,ArrayList<Product>> e: inventoryProductHashMap.entrySet())
            productArrayList.put(e.getKey(),e.getValue());


        return productArrayList;
    }
    public Inventory createInventory(String ID)
    {
        Inventory inventory=new Inventory(ID);
        inventoryProductHashMap=new HashMap<>();
        inventoryList=new ArrayList<>();
        inventoryProductHashMap.put(ID,new ArrayList<>());
        inventoryList.add(inventory);
        return inventory;
    }
    public ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }
    public boolean deleteInventory(Inventory inventory) throws InvalidInventoryException{
        if(inventory==null)
            throw new InvalidInventoryException("Invalid Inventory");
        if (inventoryList.contains(inventory) == true) {
            return inventoryList.remove(inventory);
        }
        return false;
    }

    public boolean addProductToInventory(Inventory inventory,Product product) throws InvalidInventoryException, InvalidProductException
    {
        if(inventory==null)
            throw new InvalidInventoryException("Invalid Inventory");
        if(product==null)
            throw new InvalidProductException("Invalid Product");
        if(inventory.addProduct(product))
        {
            inventoryProductHashMap.put(inventory.getInventoryID(),inventory.getInventoryProductList());
            return true;
        }
        return false;
    }
    public boolean deleteProductFromInventory(Inventory inventory,Product product) throws InvalidInventoryException, InvalidProductException
    {
        if(inventory==null)
                throw new InvalidInventoryException("Invalid Inventory");
        if(product==null)
                throw new InvalidProductException("Invalid Product");
        if(inventory.deleteProduct(product))
        {
            inventoryProductHashMap.put(inventory.getInventoryID(),inventory.getInventoryProductList());
            return true;
        }
        return false;
    }
}
