package stu.tttn.backend.dao;

import org.springframework.stereotype.Repository;
import stu.tttn.backend.model.Salary;

import java.sql.*;

@Repository
public class SalaryDAO {
    private Connection getConnection() throws SQLException {
        // Connection logic to the database (using JDBC or connection pool)
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/thuctap", "root", "");
    }

    // Create Salary
    public void createSalary(Salary salary) throws SQLException {
        String sql = "INSERT INTO luong (Maluong, Thangluong, Tonggiolam, Luongcoban, Tangca, Thuongphat, Phucap, Tienthue, Tienbaohiem, Phucloi, Manhanvien, Maphucloi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salary.getMaLuong());
            stmt.setInt(2, salary.getThangLuong());
            stmt.setInt(3, salary.getTongGioLam());
            stmt.setDouble(4, salary.getLuongCoBan());
            stmt.setDouble(5, salary.getTangCa());
            stmt.setDouble(6, salary.getThuongPhat());
            stmt.setDouble(7, salary.getPhuCap());
            stmt.setDouble(8, salary.getTienThue());
            stmt.setDouble(9, salary.getTienBaoHiem());
            stmt.setDouble(10, salary.getPhucLoi());
            stmt.setString(11, salary.getMaNhanVien());
            stmt.setString(12, salary.getMaPhucLoi());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw e;
        }
    }

    // Get Salary by ID
    public Salary getSalary(String maLuong) throws SQLException {
        String sql = "SELECT * FROM luong WHERE Maluong = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maLuong);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Salary salary = new Salary();
                salary.setMaLuong(rs.getString("Maluong"));
                salary.setThangLuong(rs.getInt("Thangluong"));
                salary.setTongGioLam(rs.getInt("Tonggiolam"));
                salary.setLuongCoBan(rs.getDouble("Luongcoban"));
                salary.setTangCa(rs.getDouble("Tangca"));
                salary.setThuongPhat(rs.getDouble("Thuongphat"));
                salary.setPhuCap(rs.getDouble("Phucap"));
                salary.setTienThue(rs.getDouble("Tienthue"));
                salary.setTienBaoHiem(rs.getDouble("Tienbaohiem"));
                salary.setPhucLoi(rs.getDouble("Phucloi"));
                salary.setMaNhanVien(rs.getString("Manhanvien"));
                salary.setMaPhucLoi(rs.getString("Maphucloi"));
                return salary;
            }
        }
        return null;
    }

    // Update Salary
    public void updateSalary(Salary salary) throws SQLException {
        String sql = "UPDATE luong SET Thangluong = ?, Tonggiolam = ?, Luongcoban = ?, Tangca = ?, Thuongphat = ?, Phucap = ?, Tienthue = ?, Tienbaohiem = ?, Phucloi = ?, Manhanvien = ?, Maphucloi = ? WHERE Maluong = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salary.getThangLuong());
            stmt.setInt(2, salary.getTongGioLam());
            stmt.setDouble(3, salary.getLuongCoBan());
            stmt.setDouble(4, salary.getTangCa());
            stmt.setDouble(5, salary.getThuongPhat());
            stmt.setDouble(6, salary.getPhuCap());
            stmt.setDouble(7, salary.getTienThue());
            stmt.setDouble(8, salary.getTienBaoHiem());
            stmt.setDouble(9, salary.getPhucLoi());
            stmt.setString(10, salary.getMaNhanVien());
            stmt.setString(11, salary.getMaPhucLoi());
            stmt.setString(12, salary.getMaLuong());
            stmt.executeUpdate();
        }
    }

    // Delete Salary by ID
    public void deleteSalary(String maLuong) throws SQLException {
        String sql = "DELETE FROM luong WHERE Maluong = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maLuong);
            stmt.executeUpdate();
        }
    }
}
