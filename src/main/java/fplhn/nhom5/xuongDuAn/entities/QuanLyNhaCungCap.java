package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "NhaCungCap")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuanLyNhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TenNCC")
    private String ten;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String dienThoai;
    @Column(name = "TrangThai")
    private Integer trangThai;

}
