package com.example.send_request.request;

import com.example.send_request.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    private User user;
    private List<Long> listSubjectId = new ArrayList<>();
}
