package com.example.spring_course.controller.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;

    private String total;

    private CustomerResponse customers;
}
