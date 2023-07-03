package fplhn.nhom5.xuongDuAn.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietDoGo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuanLyChiTietDoGo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSanPham")
    private QuanLySP idSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLoaiSP")
    private QuanLyLoaiSP idLoaiSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongGo")
    private QuanLyDongGo idDongGo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhaCungCap")
    private QuanLyNhaCungCap idNhaCungCap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNguonGoc")
    private QuanLyNguonGoc idNguonGoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDonViTinh")
    private QuanLyDonViTinh idDonViTinh;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenSP", length = 50)
    private String tenSP;

    @Column(name = "SoLuong")
    private String soLuong;

    @Column(name = "GiaNhap", precision = 18)
    private String giaNhap;

    @Column(name = "GiaBan", precision = 18)
    private String giaBan;

    @Size(max = 50)
    @Nationalized
    @Column(name = "MoTa", length = 50)
    private String moTa;

    @Column(name = "TrangThai")
    private String trangThai;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAnh")
    private QuanLyAnh idAnh;

}
