package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "DonViTinh")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class QuanLyDonViTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "DonViTinh")
    private String donViTinh;


}
