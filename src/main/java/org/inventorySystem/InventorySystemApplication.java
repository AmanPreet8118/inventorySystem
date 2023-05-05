package org.inventorySystem;

import org.inventorySystem.Model.account.*;
import org.inventorySystem.Model.inventory.Inventory;
import org.inventorySystem.Model.inventory.Product;
import org.inventorySystem.exceptions.InvalidInventoryException;
import org.inventorySystem.exceptions.InvalidProductException;

import java.util.ArrayList;
import java.util.UUID;


public class InventorySystemApplication {
    public static void main(String[] args) throws InvalidProductException, InvalidInventoryException {
        Address address=new Address();
        address.setStreetAddress("ABC");
        address.setCountry("PQRS");
        address.setCity("XYZ");
        address.setZipCode("1234");

        PersonalInfo personalInfo=new PersonalInfo();
        personalInfo.setDob("05-05-2023");
        personalInfo.setName("QWERTY");

        Contact contact=new Contact();
        contact.setEmail("abc@gmail.com");
        contact.setPhone("123456789");
        contact.setPersonalInfo(personalInfo);

        //Creating a new admin
        Account admin=new Admin();

        admin.setId(UUID.randomUUID().toString());
        admin.setAddress(address);
        admin.setContact(contact);
        admin.setUserName("Admin1");
        admin.setPassword("admin");

        //Creating new inventory
        Inventory inventory1=((Admin)admin).createInventory(UUID.randomUUID().toString());

        Product product1=new Product();
        product1.setProductID("1");
        product1.setProductName("A");
        product1.setPrice(20.0);

        Product product2=new Product();
        product2.setProductID("2");
        product2.setProductName("B");
        product2.setPrice(10.0);

        //Adding new product(s) to inventory1
        ((Admin)admin).addProductToInventory(inventory1,product1);
        ((Admin)admin).addProductToInventory(inventory1,product2);

        //Getting Product List Of Inventory1
        ArrayList<Product> inventoryArrayList=((Admin)admin).getInventoryProduct(inventory1);

        //Printing the Available Products
        for(int i=0;i<inventoryArrayList.size();i++)
            System.out.println("Product ID=" + inventoryArrayList.get(i).getProductID() + ", Product Name=" + inventoryArrayList.get(i).getProductName());

        //Deleting product from inventory1
        ((Admin)admin).deleteProductFromInventory(inventory1,product1);
        inventoryArrayList=((Admin)admin).getInventoryProduct(inventory1);

        //Printing the products after deletion
        for(int i=0;i<inventoryArrayList.size();i++)
        {
            System.out.println("Inventory1 after deletion of product A");
            System.out.println("Product ID=" + inventoryArrayList.get(i).getProductID() + ", Product Name=" + inventoryArrayList.get(i).getProductName());
        }

        System.out.println("Inventories List");
        ArrayList<Inventory> inventoryArrayList1=new ArrayList<>();
        inventoryArrayList1=((Admin)admin).getInventoryList();

        for(int i=0;i<inventoryArrayList1.size();i++)
        {
            System.out.println(inventoryArrayList1.get(i).getInventoryID());
        }
    }
}
