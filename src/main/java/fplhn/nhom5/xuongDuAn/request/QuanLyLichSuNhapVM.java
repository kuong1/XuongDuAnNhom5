package fplhn.nhom5.xuongDuAn.request;

import fplhn.nhom5.xuongDuAn.entities.QuanLyChiTietDoGo;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyLichSuNhapVM {
    private UUID id;


    private QuanLyChiTietDoGo idSpNhap;

    private String soLongNhap;

    private String ngayNhap;

    private String trangThai;

    private String tongTienNhap;
}
