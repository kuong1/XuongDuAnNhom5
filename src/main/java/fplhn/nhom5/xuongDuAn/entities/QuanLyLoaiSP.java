package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "LoaiSP")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuanLyLoaiSP {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="TenDongSP")
    private String ten;


}
