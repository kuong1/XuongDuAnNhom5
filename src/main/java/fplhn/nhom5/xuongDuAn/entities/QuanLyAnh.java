package fplhn.nhom5.xuongDuAn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Anh")
@Component
@Builder
@ToString
public class QuanLyAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Nationalized
    @Column(name = "Ma")
    private String ma;

    @Column(name = "TrangThai")
    private String trangThai;

}