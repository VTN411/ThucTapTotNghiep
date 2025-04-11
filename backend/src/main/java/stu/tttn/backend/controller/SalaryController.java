package stu.tttn.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stu.tttn.backend.model.Salary;
import stu.tttn.backend.services.SalaryService;


import java.sql.SQLException;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    // Create Salary
    @PostMapping("/add")
    public ResponseEntity<String> addSalary(@RequestBody Salary salary) {
        try {
            salaryService.addSalary(salary);
            return ResponseEntity.status(HttpStatus.CREATED).body("Salary created successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating salary");
        }
    }

    // Get Salary by ID
    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalary(@PathVariable String id) {
        try {
            Salary salary = salaryService.getSalary(id);
            if (salary != null) {
                return ResponseEntity.status(HttpStatus.OK).body(salary);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Update Salary
    @PutMapping("/update")
    public ResponseEntity<String> updateSalary(@RequestBody Salary salary) {
        try {
            salaryService.updateSalary(salary);
            return ResponseEntity.status(HttpStatus.OK).body("Salary updated successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating salary");
        }
    }

    // Delete Salary
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable String id) {
        try {
            salaryService.deleteSalary(id);
            return ResponseEntity.status(HttpStatus.OK).body("Salary deleted successfully");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting salary");
        }
    }
    @GetMapping("/calculate-salary")
    public ResponseEntity<String> calculateSalary(
            @RequestParam double baseSalary,
            @RequestParam double overtimeHours,
            @RequestParam double overtimeRate) {
        try {
            double overtimePay = overtimeHours * overtimeRate;
            double totalSalary = baseSalary + overtimePay;
            return ResponseEntity.status(HttpStatus.OK).body("Tổng Lương: " + totalSalary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error calculating salary");
        }
    }
}
