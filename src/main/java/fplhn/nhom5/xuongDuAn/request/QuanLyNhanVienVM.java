package fplhn.nhom5.xuongDuAn.request;

import fplhn.nhom5.xuongDuAn.entities.QuanLyChucVu;
import fplhn.nhom5.xuongDuAn.entities.QuanLyCuaHang;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyNhanVienVM {
    private UUID id;

    private String ma;

    private String hoTen;

    private String sdt;

    private String diaChi;

    private String ngaySinh;

    private QuanLyCuaHang idCuaHang;

    private QuanLyChucVu idChucVu;

    private String matKhau;

    private String trangThai;

    private String email;
}
