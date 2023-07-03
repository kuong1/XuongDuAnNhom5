package fplhn.nhom5.xuongDuAn.request;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class QuanLyNguonGocVM {

    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Quốc Gia không được để trống")
    private String quocGia;


}
