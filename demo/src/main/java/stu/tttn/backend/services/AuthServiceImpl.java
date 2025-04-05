package stu.tttn.backend.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import stu.tttn.backend.dao.UserRepository;
import stu.tttn.backend.model.User;
import stu.tttn.backend.model.Employee;
import stu.tttn.backend.model.dto.LoginRequest;
import stu.tttn.backend.model.dto.LoginResponse;
import stu.tttn.backend.model.dto.RegisterRequest;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByTendangnhap(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new LoginResponse(
                "GeneratedJWTToken",
                user.getTendangnhap(),
                user.getQuyenhan(),
                user.getEmployee().getManhanvien(),
                user.getEmployee().getTennhanvien()
        );
    }

    @Override
    public String registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByTendangnhap(registerRequest.getUsername())) {
            return "Error: Username is already taken!";
        }

        User user = new User();
        user.setTendangnhap(registerRequest.getUsername());
        user.setMatkhau(passwordEncoder.encode(registerRequest.getPassword()));
        user.setQuyenhan("ROLE_USER");
        user.setTrangthai(true);

        Employee employee = new Employee();
        employee.setManhanvien(registerRequest.getEmployeeId());
        user.setEmployee(employee);

        userRepository.save(user);
        return "User registered successfully!";
    }
}