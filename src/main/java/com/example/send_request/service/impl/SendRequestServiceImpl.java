package com.example.send_request.service.impl;

import com.example.send_request.request.RegisterUserRequest;
import com.example.send_request.request.User;
import com.example.send_request.service.SendRequestService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Service
public class SendRequestServiceImpl implements SendRequestService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    @Override
    public void sendRequest(RegisterUserRequest request) {

    }

    @Override
    public RegisterUserRequest createRequest() {
        User user = new User();
        user.setEmail("dangthehung1999@gmail.com");
        user.setName("Dang The Hung");
        user.setPhone("0969550274");
        user.setUsername(UUID.randomUUID().toString());
        Long[] subjects = {1L, 2L};
        return new RegisterUserRequest(user, new ArrayList<>(Arrays.asList(subjects)));
    }
}
