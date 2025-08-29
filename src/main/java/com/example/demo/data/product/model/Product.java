package com.example.demo.data.product.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {
    private int id;
    private String name;
    private int price;
    private int categoryId;
}
