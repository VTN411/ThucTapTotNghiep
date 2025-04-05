package stu.tttn.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class Employee {
    @Id
    @Column(name = "Manhanvien")
    private String manhanvien;

    private String tennhanvien;
    private String cccd;
    private String diachi;
    private String sdt;
    private String email;
    private String trangthailamviec;

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrangthailamviec() {
        return trangthailamviec;
    }

    public void setTrangthailamviec(String trangthailamviec) {
        this.trangthailamviec = trangthailamviec;
    }

    public Employee(String manhanvien, String tennhanvien, String cccd, String diachi, String sdt, String email, String trangthailamviec) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.cccd = cccd;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.trangthailamviec = trangthailamviec;
    }

    public Employee() {
    }

}