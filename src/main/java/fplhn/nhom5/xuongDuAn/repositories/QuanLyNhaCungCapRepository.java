package fplhn.nhom5.xuongDuAn.repositories;

import fplhn.nhom5.xuongDuAn.entities.QuanLyNhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuanLyNhaCungCapRepository extends JpaRepository<QuanLyNhaCungCap, UUID> {
}
