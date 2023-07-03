package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "LichSuNhap")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuanLyLichSuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "IdNhap", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSpNhap")
    private QuanLyChiTietDoGo idSpNhap;

    @Column(name = "SoLongNhap")
    private String soLongNhap;

    @Column(name = "NgayNhap")
    private String ngayNhap;

//    @Column(name = "TrangThai")
//    @NotNull(message = "Không để trống trạng thái")
//    private Integer trangThai;

    @Column(name = "TongTienNhap", precision = 18)
    private String tongTienNhap;

}
