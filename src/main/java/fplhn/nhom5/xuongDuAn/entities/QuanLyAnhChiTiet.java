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
@Table(name = "AnhChiTiet")
public class QuanLyAnhChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAnh")
    private QuanLyAnh idAnh;

    @Column(name = "Image")
    private String image;

    @Column(name = "TrangThai")
    private String trangThai;

    @Column(name = "Ma")
    private String ma;

}