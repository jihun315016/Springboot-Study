package com.example.demo.tdd.repository;

import com.example.demo.tdd.dto.Product;

// ProductRepository.java
// 파일 위치
// src/main/java/com/example/demo/tdd/repository/ProductRepository.java

public interface ProductRepository {
    Product save(Product product);
}
