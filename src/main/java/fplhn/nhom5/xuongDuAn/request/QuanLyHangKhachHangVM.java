package fplhn.nhom5.xuongDuAn.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyHangKhachHangVM {

    @NotBlank(message = "Mã không được để trống")
    private String maHang;

    @NotBlank(message = "Tên không được để trống")
    private String tenHang;

    @NotBlank(message = "Mo ta không được để trống")
    private String moTa;

    @NotBlank(message = "Diem tich luy không được để trống")
    private String diemTichLuy;
}
