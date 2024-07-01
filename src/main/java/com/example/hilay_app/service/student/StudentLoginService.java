package com.example.hilay_app.service.student;

import com.example.hilay_app.request.login.StudentLoginRequest;
import com.example.hilay_app.response.login.StudentLoginResponse;
import com.example.hilay_app.util.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLoginService {

    private final AuthenticationService authenticationService;

    public StudentLoginResponse login(StudentLoginRequest loginRequest) {
        return authenticationService.authenticateAndGetLoginResponse(loginRequest);
    }

}
