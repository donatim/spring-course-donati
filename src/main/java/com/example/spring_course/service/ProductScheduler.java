package com.example.spring_course.service;

import com.example.spring_course.repository.ProductMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductScheduler {

    private final ProductMongoRepository productRepository;

    public ProductScheduler(ProductMongoRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Scheduled(
            fixedRateString = "${app.scheduler.product-stats.fixed-rate:60000}",
            initialDelayString = "${app.scheduler.product-stats.initial-delay:10000}"
    )
    public void logProductStatistics() {
        long totalProducts = productRepository.count();

        log.info(
                "SCHEDULED - catalog statistics: totalProducts={}, thread={}",
                totalProducts,
                Thread.currentThread().getName()
        );
    }
}
