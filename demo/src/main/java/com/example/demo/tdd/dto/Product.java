package com.example.demo.tdd.dto;

// 파일 위치
// src/main/java/com/example/demo/tdd/dto/Product.java

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private Long id;
    private String name;
    private int price;
}
