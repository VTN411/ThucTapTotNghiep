package stu.tttn.backend.services;

import stu.tttn.backend.model.dto.LoginRequest;
import stu.tttn.backend.model.dto.LoginResponse;
import stu.tttn.backend.model.dto.RegisterRequest;

public interface AuthService {
    LoginResponse authenticateUser(LoginRequest loginRequest);
    String registerUser(RegisterRequest registerRequest);
}