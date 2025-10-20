package com.example.demo.tdd.service;

// 파일 위치
// src/main/java/com/example/demo/tdd/service/ProductService.java

import com.example.demo.tdd.dto.Product;
import com.example.demo.tdd.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product increasePriceByPercentage(Product product, int percentage) {
        // Red 단계에서 테스트가 실패하도록 의도적으로 잘못된 값 반환
        return product; // 가격 인상이 적용되지 않은 원래 Product
    }

    public long saveProduct(Product product) {
        // Mocking한 productRepository.save(product)를 호출하면
        // Mock 객체가 when(...)에서 설정한 대로 ID=1L인 객체를 반환합니다.
        Product savedProduct = productRepository.save(product);

        // 테스트에서 기대한 대로 ID를 반환합니다.
        return savedProduct.getId();
    }
}
