package com.elkabani.firstspringboot.dtos;
import lombok.Data;

@Data
public class ProductDto {
    int id;
    String name;
    String description;
    double price;
    int categoryId;

}
