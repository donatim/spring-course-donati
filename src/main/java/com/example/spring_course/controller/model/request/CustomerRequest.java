package com.example.spring_course.controller.model.request;

import com.example.spring_course.controller.model.response.OrderResponse;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest {
    private Long id;
    private String name;
    private List<OrderResponse> orders;
}
