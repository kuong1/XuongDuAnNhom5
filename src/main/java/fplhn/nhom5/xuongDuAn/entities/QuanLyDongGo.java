package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "DongGo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuanLyDongGo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="TenLoaiGo")
    private String ten;

    @Column(name="TrangThai")
    private int trangThai;
}
