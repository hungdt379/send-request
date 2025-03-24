package com.example.send_request.service;


import com.example.send_request.request.RegisterUserRequest;

public interface SendRequestService {
    void sendRequest(RegisterUserRequest request);

    RegisterUserRequest createRequest();
}
