package fplhn.nhom5.xuongDuAn.repositories;

import fplhn.nhom5.xuongDuAn.entities.QuanLyCuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuanLyCuaHangRepository extends JpaRepository<QuanLyCuaHang, UUID> {
}
