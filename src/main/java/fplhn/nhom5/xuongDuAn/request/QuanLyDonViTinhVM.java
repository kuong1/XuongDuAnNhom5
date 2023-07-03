package fplhn.nhom5.xuongDuAn.request;

import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Component
@ToString
public class QuanLyDonViTinhVM {
    private UUID id;

    private String ma;

    private String donViTinh;



}
