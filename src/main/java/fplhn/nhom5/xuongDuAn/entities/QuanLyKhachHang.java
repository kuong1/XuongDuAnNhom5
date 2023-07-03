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
@Table(name = "KhachHang")
public class QuanLyKhachHang {
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
    @Column(name = "TenKhachHang", length = 50)
    private String tenKhachHang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Sdt", length = 50)
    private String sdt;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHangKhachHang")
    private QuanLyHangKhachHang idHangKhachHang;

}