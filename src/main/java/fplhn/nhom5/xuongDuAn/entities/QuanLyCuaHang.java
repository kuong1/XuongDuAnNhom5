package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuanLyCuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TenCuaHang")
    private String ten;

    @Column(name = "DiaChi")
    private String diaChi;


    @Column(name = "TrangThai")
    private Integer trangThai;
}
