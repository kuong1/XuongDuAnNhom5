package fplhn.nhom5.xuongDuAn.request;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyKhuyenMaiVM {
    private UUID id;

    private String ma;

    private String tenKhuyenMai;

    private String ngayBatDau;

    private String ngayKetThuc;

    private String trangThai;

    private String phanTramKM;
}
