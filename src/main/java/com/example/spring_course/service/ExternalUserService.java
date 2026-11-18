package com.example.spring_course.service;

import com.example.spring_course.client.ExternalUserClient;
import com.example.spring_course.controller.model.response.ExternalUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalUserService {

    private final ExternalUserClient externalUserClient;

    public ExternalUserResponse findUser(Long id){
        return externalUserClient.findUser(id);
    }
}
