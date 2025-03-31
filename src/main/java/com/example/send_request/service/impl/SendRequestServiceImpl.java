package com.example.send_request.service.impl;

import com.example.send_request.entity.Log;
import com.example.send_request.repository.SendRequestRepository;
import com.example.send_request.request.RegisterUserRequest;
import com.example.send_request.entity.User;
import com.example.send_request.service.SendRequestService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Service
public class SendRequestServiceImpl implements SendRequestService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    @Value("${register.service.url}")
    private String registerServiceUrl;

    @Autowired
    SendRequestRepository sendRequestRepository;

    private static final Logger logger = LoggerFactory.getLogger(SendRequestServiceImpl.class);

    @Override
    public void sendRequest(RegisterUserRequest request) {
        Log log = new Log();
        log.setStartTime(LocalDateTime.now().toString());
        log.setRequestBody(gson.toJson(request));
        logger.info(log.getRequestBody());
        String response = restTemplate.postForObject(registerServiceUrl + "/api/register", request, String.class);
        log.setEndTime(LocalDateTime.now().toString());
        log.setResponse(response);
        logger.info(response);
        sendRequestRepository.save(log);
        logger.info(gson.toJson(log));
    }

    @Override
    public RegisterUserRequest createRequest() {
        User user = new User();
        user.setEmail("test.hungdt379@gmail.com");
        user.setName("Dang The Hung");
        user.setPhone("0969550274");
        user.setUsername(UUID.randomUUID().toString());
        Long[] subjects = {1L, 2L};
        return new RegisterUserRequest(user, new ArrayList<>(Arrays.asList(subjects)));
    }
}
