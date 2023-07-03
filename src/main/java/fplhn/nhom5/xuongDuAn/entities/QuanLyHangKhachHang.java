package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "HangKhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuanLyHangKhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "MaHang")
    private String maHang;
    @Column(name = "TenHang")
    private String tenHang;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy;
    @Column(name = "TrangThai")
    private Integer trangThai;
}
