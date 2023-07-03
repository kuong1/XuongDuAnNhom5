package fplhn.nhom5.xuongDuAn.request;

import fplhn.nhom5.xuongDuAn.entities.QuanLyAnh;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyAnhChiTietVM {
    private UUID id;

    private QuanLyAnh idAnh;

    private String image;

    private String trangThai;

    private String ma;
}
