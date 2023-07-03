package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NhanVien")
public class QuanLyNhanVien {
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
    @Column(name = "HoTen", length = 50)
    private String hoTen;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Sdt", length = 50)
    private String sdt;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCuaHang")
    private QuanLyCuaHang idCuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChucVu")
    private QuanLyChucVu idChucVu;

    @Size(max = 50)
    @Nationalized
    @Column(name = "MatKhau", length = 50)
    private String matKhau;

    @Column(name = "TrangThai")
    private String trangThai;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

}