package fplhn.nhom5.xuongDuAn.request;

import fplhn.nhom5.xuongDuAn.entities.*;
import lombok.*;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyChiTietDoGoVM {

    private UUID id;

    private QuanLySP idSanPham;

    private QuanLyLoaiSP idLoaiSP;

    private QuanLyDongGo idDongGo;

    private QuanLyNhaCungCap idNhaCungCap;

    private QuanLyNguonGoc idNguonGoc;

    private QuanLyDonViTinh idDonViTinh;

    private String tenSP;

    private String soLuong;

    private String giaNhap;

    private String giaBan;

    private String moTa;

    private String trangThai;


    private QuanLyAnh idAnh;
}
