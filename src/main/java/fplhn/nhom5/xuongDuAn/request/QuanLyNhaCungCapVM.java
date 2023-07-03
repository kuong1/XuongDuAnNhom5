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
public class QuanLyNhaCungCapVM {

    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Dia chi không được để trống")
    private String diaChi;

    @NotBlank(message = "Dien thoai không được để trống")
    private String dienThoai;
}
