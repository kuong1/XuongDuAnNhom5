package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;


import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "KhuyenMai")
public class QuanLyKhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ma", length = 50)
    private String ma;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenKhuyenMai", length = 50)
    private String tenKhuyenMai;

    @Column(name = "NgayBatDau")
    private String ngayBatDau;

    @Column(name = "NgayKetThuc")
    private String ngayKetThuc;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "PhanTramKM")
    private String phanTramKM;

}