package com.example.spring_course.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private Long id;

    private BigDecimal total;

    private CustomerDTO customers;
}
