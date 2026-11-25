package com.example.spring_course.service;


import com.example.spring_course.controller.model.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ProductAsyncService {

    private final ProductService productService;

    public ProductAsyncService(ProductService productService) {
        this.productService = productService;
    }

    @Async("taskExecutor")
    public CompletableFuture<ProductResponse> findById(String id) {
        log.info("ASYNC START - productId={}, thread={}", id, Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.failedFuture(e);
        }

        ProductResponse response = productService.findById(id);

        log.info("ASYNC END - productId={}, thread={}", id, Thread.currentThread().getName());

        return CompletableFuture.completedFuture(response);
    }
}
