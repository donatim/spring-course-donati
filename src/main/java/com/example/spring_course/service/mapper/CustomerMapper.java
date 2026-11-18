package com.example.spring_course.service.mapper;

import com.example.spring_course.controller.model.response.CustomerResponse;
import com.example.spring_course.controller.model.response.OrderResponse;
import com.example.spring_course.repository.model.CustomerEntity;
import com.example.spring_course.service.dto.CustomerDTO;
import com.example.spring_course.service.dto.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    public CustomerResponse toCustomerResponse(CustomerDTO customerDTO) {
        List<OrderResponse> orders = customerDTO.getOrders()
                .stream()
                .map(orderDTO -> {
                    OrderResponse orderResponse = new OrderResponse();
                    orderResponse.setId(orderDTO.getId());
                    orderResponse.setTotal(orderDTO.getTotal().toString());
                    return orderResponse;
                })
                .toList();

        return new CustomerResponse(customerDTO.getId(), customerDTO.getName(), orders);
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        List<OrderDTO> orders = customerEntity.getOrders()
                .stream()
                .map(orderEntity -> {
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setId(orderEntity.getId());
                    orderDTO.setTotal(orderEntity.getTotal());
                    return orderDTO;
                })
                .toList();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setOrders(orders);

        return customerDTO;
    }
}
