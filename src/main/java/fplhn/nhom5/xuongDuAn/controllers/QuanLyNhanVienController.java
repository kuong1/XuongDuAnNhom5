package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.*;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyChucVuRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyCuaHangRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyNhanVienRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhChiTietVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyNhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/nhan-vien")
public class QuanLyNhanVienController {

    @Autowired
    private QuanLyNhanVienRepository nhanVienRepository;

    @Autowired
    private QuanLyCuaHangRepository cuaHangRepository;

    @Autowired
    private QuanLyChucVuRepository chucVuRepository;

    @Autowired
    private QuanLyNhanVienVM nhanVienVM;


    @GetMapping("index")
    public String index(Model model) {

        List<QuanLyNhanVien> nhanVienList = this.nhanVienRepository.findAll();
        List<QuanLyCuaHang> cuaHangList = this.cuaHangRepository.findAll();
        List<QuanLyChucVu> chucVuList = this.chucVuRepository.findAll();
        model.addAttribute("nhanVienList", nhanVienList);
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("chucVuList", chucVuList);
        model.addAttribute("view", "/views/nhan_vien/hien_thi.jsp");

        return "layoutMenu";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("nhanVien", nhanVienVM);
        List<QuanLyCuaHang> cuaHangList = this.cuaHangRepository.findAll();
        List<QuanLyChucVu> chucVuList = this.chucVuRepository.findAll();
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("chucVuList", chucVuList);
        model.addAttribute("action", "/admin/nhan-vien/store");
        model.addAttribute("view", "/views/nhan_vien/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("nhanVien") QuanLyNhanVienVM nhanVienVM, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<QuanLyNhanVien> nhanVienList = this.nhanVienRepository.findAll();
            List<QuanLyCuaHang> cuaHangList = this.cuaHangRepository.findAll();
            List<QuanLyChucVu> chucVuList = this.chucVuRepository.findAll();
            model.addAttribute("nhanVienList", nhanVienList);
            model.addAttribute("cuaHangList", cuaHangList);
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("view", "/views/nhan_vien/create.jsp");
            return "layoutMenu";
        }


        QuanLyNhanVien nhanVien = QuanLyNhanVien.builder()
                .ma(nhanVienVM.getMa())
                .hoTen(nhanVienVM.getHoTen())
                .sdt(nhanVienVM.getSdt())
                .diaChi(nhanVienVM.getDiaChi())
                .ngaySinh(nhanVienVM.getNgaySinh())
                .idCuaHang(nhanVienVM.getIdCuaHang())
                .idChucVu(nhanVienVM.getIdChucVu())
                .matKhau(nhanVienVM.getMatKhau())
                .trangThai(nhanVienVM.getTrangThai())
                .email(nhanVienVM.getEmail())
                .build();

        this.nhanVienRepository.save(nhanVien);
        return "redirect:/admin/nhan-vien/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyNhanVien nhanVien, Model model) {

        model.addAttribute("nhanVien", nhanVien);
        List<QuanLyCuaHang> cuaHangList = this.cuaHangRepository.findAll();
        List<QuanLyChucVu> chucVuList = this.chucVuRepository.findAll();
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("chucVuList", chucVuList);
        model.addAttribute("action", "/admin/nhan-vien/update/" + nhanVien.getId());
        model.addAttribute("view", "/views/nhan_vien/create.jsp");
        return "layoutMenu";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyNhanVien oldValue,
                         Model model, @Valid @ModelAttribute("nhanVien") QuanLyNhanVienVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            List<QuanLyCuaHang> cuaHangList = this.cuaHangRepository.findAll();
            List<QuanLyChucVu> chucVuList = this.chucVuRepository.findAll();
            model.addAttribute("cuaHangList", cuaHangList);
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("nhanVien", oldValue);
            model.addAttribute("action", "/admin/nhan-vien/update/" + oldValue.getId());
            model.addAttribute("view", "/views/nhan_vien/create.jsp");
            return "layoutMenu";
        }

        QuanLyNhanVien nhanVien = QuanLyNhanVien.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .hoTen(newValue.getHoTen())
                .sdt(newValue.getSdt())
                .diaChi(newValue.getDiaChi())
                .ngaySinh(newValue.getNgaySinh())
                .idCuaHang(newValue.getIdCuaHang())
                .idChucVu(newValue.getIdChucVu())
                .matKhau(newValue.getMatKhau())
                .trangThai(newValue.getTrangThai())
                .email(newValue.getEmail())
                .build();
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/admin/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyNhanVien nv) {
        this.nhanVienRepository.delete(nv);
        return "redirect:/admin/nhan-vien/index";
    }





}
