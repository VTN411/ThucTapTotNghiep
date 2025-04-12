package stu.tttn.backend.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import stu.tttn.backend.dao.EmployeeRepository;
import stu.tttn.backend.model.Employee;
import stu.tttn.backend.services.AuthService;
import stu.tttn.backend.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthService authService, JwtTokenProvider jwtTokenProvider,
                          EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.authService = authService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String email = credentials.get("username");
            String password = credentials.get("password");

            Employee employee = authService.authenticate(email, password);
            String token = jwtTokenProvider.generateToken(employee);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("employeeId", employee.getEmployeeId());
            response.put("employeeName", employee.getFullName());
            response.put("email", employee.getEmail());
            // Thêm các thông tin khác nếu cần

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}