package com.example.demo.tdd.service;

import com.example.demo.tdd.dto.Product;
import com.example.demo.tdd.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// ProductServiceTest.java
// 파일 위치
// src/test/java/com/example/demo/tdd/service/ProductService.java

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    // Mock 어노테이션으로 생성한 가짜 객체를 ProductService에 주입한다.
    @InjectMocks
    private ProductService productService;
    // private ProductService productService = new ProductService();

    // 가짜 객체 생성
    @Mock
    private ProductRepository productRepository;

    // 각 테스트 메서드 실행 전에 먼저 실행하는 어노테이션
    @BeforeEach
    void setUp() {
        // Mockito 설정 초기화
        // Mock 객체, InjectionMock 객체 재생성
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("상품 가격을 10% 인상한다.")
    void increasePriceTest() {
        // 테스트용 Product 객체 생성
        Product product = Product.builder()
                .id(1L)
                .name("Laptop")
                .price(10000)
                .build();

        Product updatedProduct = productService.increasePriceByPercentage(product, 10);

        assertThat(updatedProduct.getPrice()).isEqualTo(11000);
        assertThat(updatedProduct.getName()).isEqualTo("Labtop");
    }

    @Test
    @DisplayName("상품을 등록하고 상품ID를 반환한다.")
    void saveProductTest() {
        Product product = Product.builder()
                .id(1L)
                .name("Laptop")
                .price(10000)
                .build();

        // Repository가 저장 후 ID가 부여된 Product 객체를 반환하도록 Mocking
        // any()는 어떤 Product 객체가 들어오든 매칭시킵니다.
        when(productRepository.save(any(Product.class)))
                .thenReturn(Product.builder()
                        .id(1L) // 저장 후 ID가 부여된 객체
                        .name("Laptop")
                        .price(10000)
                        .build());

        // saveProduct 메서드가 없으므로 당연히 실패
        long newProductId = productService.saveProduct(product);

        assertThat(newProductId).isGreaterThan(0L);
    }
}
