package fplhn.nhom5.xuongDuAn.request;


import fplhn.nhom5.xuongDuAn.entities.QuanLyHangKhachHang;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyKhachHangVM {

    private UUID id;

    private String ma;

    private String tenKhachHang;

    private String sdt;

    private String diaChi;

    private String trangThai;

    private QuanLyHangKhachHang idHangKhachHang;
}
