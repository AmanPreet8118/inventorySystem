package com.inventorySystem.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InventoryNotFoundException extends Exception{
    public InventoryNotFoundException(String message)
    {
        super(message);
    }
}
