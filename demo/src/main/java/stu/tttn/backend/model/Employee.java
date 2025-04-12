package stu.tttn.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "nhanvien")
public class Employee {
    @Id
    @Column(name = "Manhanvien")
    private String employeeId;
    @Column(name = "Tennhanvien", nullable = false)
    private String fullName;
    @Column(name = "Ngaysinh")
    private Date dateOfBirth;
    @Column(name = "CCCD", nullable = false, unique = true)
    private String citizenId;
    @Column(name = "Diachi")
    private String address;
    @Column(name = "SDT", unique = true)
    private String phoneNumber;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "pass")
    private String password;
    @Column(name = "Trangthailamviec")
    private String workStatus;
    @Column(name = "role", nullable = false)
    private String role;

    public Employee(String employeeId, String fullName, Date dateOfBirth, String citizenId, String address, String phoneNumber, String email, String password, String workStatus, String role) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.citizenId = citizenId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.workStatus = workStatus;
        this.role = role;
    }

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}