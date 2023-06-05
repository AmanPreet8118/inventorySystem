package com.inventorySystem.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private int id;
    private String description;
    private BigDecimal price;
}
