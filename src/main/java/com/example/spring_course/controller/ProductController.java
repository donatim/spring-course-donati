package com.example.spring_course.controller;

import com.example.spring_course.controller.model.request.ProductRequest;
import com.example.spring_course.controller.model.response.ProductResponse;
import com.example.spring_course.service.ProductAsyncService;
import com.example.spring_course.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/catalog")
public class ProductController {

    private final ProductService service;
    private final ProductAsyncService productAsyncService;

    public ProductController(ProductService service, ProductAsyncService productAsyncService) {
        this.service = service;
        this.productAsyncService = productAsyncService;
    }

    @PostMapping("/admin/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return service.create(request);
    }

    @GetMapping("/public/all")
    public List<ProductResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public ProductResponse findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/user/{id}/async")
    public CompletableFuture<ProductResponse> findByIdAsync(@PathVariable String id) {

        log.info("CONTROLLER START - thread={}", Thread.currentThread().getName());

        CompletableFuture<ProductResponse> future = productAsyncService.findById(id);

        log.info("CONTROLLER END - thread={}", Thread.currentThread().getName());

        return future;
    }

    @PutMapping("/admin/update/{id}")
    public ProductResponse update(@PathVariable String id, @Valid @RequestBody ProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/admin/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/user/category/{category}")
    public List<ProductResponse> findByCategory(@PathVariable String category) {
        return service.findByCategory(category);
    }

    @GetMapping("/user/search")
    public List<ProductResponse> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }
}
