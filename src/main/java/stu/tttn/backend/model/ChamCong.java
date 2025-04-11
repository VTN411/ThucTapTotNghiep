package stu.tttn.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ChamCong {
    private String maNV;
    private String tenNhanVien;
    private LocalDate ngayCham;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private String trangThai;
    private String ghiChu;

    // Constructors
    public ChamCong() {
    }

    public ChamCong(String maNV, String tenNhanVien, LocalDate ngayCham, LocalTime gioVao, LocalTime gioRa, String trangThai, String ghiChu) {
        this.maNV = maNV;
        this.tenNhanVien = tenNhanVien;
        this.ngayCham = ngayCham;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public LocalDate getNgayCham() {
        return ngayCham;
    }

    public void setNgayCham(LocalDate ngayCham) {
        this.ngayCham = ngayCham;
    }

    public LocalTime getGioVao() {
        return gioVao;
    }

    public void setGioVao(LocalTime gioVao) {
        this.gioVao = gioVao;
    }

    public LocalTime getGioRa() {
        return gioRa;
    }

    public void setGioRa(LocalTime gioRa) {
        this.gioRa = gioRa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}