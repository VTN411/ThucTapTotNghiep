package stu.tttn.backend.model.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String employeeId; // Manhanvien

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public RegisterRequest(String username, String password, String employeeId) {
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
    }

    public RegisterRequest() {
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}