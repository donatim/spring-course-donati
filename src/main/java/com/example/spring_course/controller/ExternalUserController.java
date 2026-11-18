package com.example.spring_course.controller;

import com.example.spring_course.controller.model.response.ExternalUserResponse;
import com.example.spring_course.service.ExternalUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external-users")
@RequiredArgsConstructor
public class ExternalUserController {

    private final ExternalUserService externalUserService;

    @GetMapping("/{id}")
    public ExternalUserResponse findUser(@PathVariable Long id){
        return externalUserService.findUser(id);
    }
}
