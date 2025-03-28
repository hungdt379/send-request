package com.example.send_request.worker;

import com.example.send_request.request.RegisterUserRequest;
import com.example.send_request.service.SendRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecuteWorker implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteWorker.class);

    @Autowired
    SendRequestService sendRequestService;

    @Override
    public void run() {
        RegisterUserRequest request = sendRequestService.createRequest();
        logger.info("[START]::SEND REQUEST: {}", request.getUser().getUsername());
        sendRequestService.sendRequest(request);
        logger.info("[END  ]::SEND REQUEST: {}", request.getUser().getUsername());
    }
}
