package stu.tttn.backend.model.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private String role;
    private String employeeId;
    private String employeeName;

    public LoginResponse(String token, String username, String role, String employeeId, String employeeName) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public LoginResponse() {
    }
}