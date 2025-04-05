package stu.tttn.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "taikhoan")
public class User {
    @Id
    @Column(name = "Mataikhoan")
    private String mataikhoan;

    @OneToOne
    @JoinColumn(name = "Manhanvien",
            referencedColumnName = "Manhanvien")
    private Employee employee;

    @Column(name = "Tendangnhap")
    private String tendangnhap;

    @Column(name = "Matkhau")
    private String matkhau;

    @Column(name = "Quyenhan")
    private String quyenhan;

    @Column(name = "Trangthai")
    private boolean trangthai;

    public String getMataikhoan() {
        return mataikhoan;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getQuyenhan() {
        return quyenhan;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setMataikhoan(String mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setQuyenhan(String quyenhan) {
        this.quyenhan = quyenhan;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public User(String mataikhoan, Employee employee, String tendangnhap, String matkhau, String quyenhan, boolean trangthai) {
        this.mataikhoan = mataikhoan;
        this.employee = employee;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.quyenhan = quyenhan;
        this.trangthai = trangthai;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "mataikhoan='" + mataikhoan + '\'' +
                ", employee=" + employee +
                ", tendangnhap='" + tendangnhap + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", quyenhan='" + quyenhan + '\'' +
                ", trangthai=" + trangthai +
                '}';
    }
}