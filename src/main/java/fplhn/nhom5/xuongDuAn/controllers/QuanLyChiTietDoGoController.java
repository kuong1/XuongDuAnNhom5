package fplhn.nhom5.xuongDuAn.controllers;


import fplhn.nhom5.xuongDuAn.entities.*;
import fplhn.nhom5.xuongDuAn.repositories.*;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhChiTietVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyChiTietDoGoVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/chi-tiet-do-go")
public class QuanLyChiTietDoGoController {

    @Autowired
    private QuanLyChiTietDoGoRepository chiTietDoGoRepository;

    @Autowired
    private QuanLySPRepository spRepository;

    @Autowired
    private QuanLyLoaiSPRepository loaiSPRepository;

    @Autowired
    private QuanLyDongGoRepository dongGoRepository;

    @Autowired
    private QuanLyNhaCungCapRepository nhaCungCapRepository;

    @Autowired
    private QuanLyNguonGocRepository nguonGocRepository;

    @Autowired
    private QuanLyDonViTinhRepository donViTinhRepository;

    @Autowired
    private QuanLyAnhRepository anhRepository;

    @Autowired
    private QuanLyChiTietDoGoVM chiTietDoGoVM;

    @GetMapping("index")
    public String index(Model model) {

        List<QuanLyChiTietDoGo> chiTietDoGoList = this.chiTietDoGoRepository.findAll();
        List<QuanLySP> spList = this.spRepository.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("chiTietDoGoList", chiTietDoGoList);
        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("view", "/views/chi_tiet_do_go/hien_thi.jsp");

        return "layoutMenu";
    }


    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("chiTietDoGo", chiTietDoGoVM);
        List<QuanLySP> spList = this.spRepository.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGoVM chiTietDoGoVM, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<QuanLyChiTietDoGo> chiTietDoGoList = this.chiTietDoGoRepository.findAll();
            List<QuanLySP> spList = this.spRepository.findAll();
            List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
            List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
            List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
            List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
            List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
            List<QuanLyAnh> anhList = this.anhRepository.findAll();

            model.addAttribute("chiTietDoGoList", chiTietDoGoList);
            model.addAttribute("spList", spList);
            model.addAttribute("loaiSPList", loaiSPList);
            model.addAttribute("dongGoList", dongGoList);
            model.addAttribute("nhaCungCapList", nhaCungCapList);
            model.addAttribute("nguonGocList", nguonGocList);
            model.addAttribute("donViTinhList", donViTinhList);
            model.addAttribute("anhList", anhList);


            model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
            return "layoutMenu";
        }


        QuanLyChiTietDoGo chiTietDoGo = QuanLyChiTietDoGo.builder()
                .idSanPham(chiTietDoGoVM.getIdSanPham())
                .idLoaiSP(chiTietDoGoVM.getIdLoaiSP())
                .idDongGo(chiTietDoGoVM.getIdDongGo())
                .idNhaCungCap(chiTietDoGoVM.getIdNhaCungCap())
                .idNguonGoc(chiTietDoGoVM.getIdNguonGoc())
                .idDonViTinh(chiTietDoGoVM.getIdDonViTinh())
                .idAnh(chiTietDoGoVM.getIdAnh())
                .tenSP(chiTietDoGoVM.getTenSP())
                .soLuong(chiTietDoGoVM.getSoLuong())
                .giaNhap(chiTietDoGoVM.getGiaNhap())
                .giaBan(chiTietDoGoVM.getGiaBan())
                .moTa(chiTietDoGoVM.getMoTa())
                .trangThai(chiTietDoGoVM.getTrangThai())
                .build();

        this.chiTietDoGoRepository.save(chiTietDoGo);
        return "redirect:/admin/chi-tiet-do-go/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyChiTietDoGo chiTietDoGo, Model model) {

        model.addAttribute("chiTietDoGo", chiTietDoGo);


        List<QuanLySP> spList = this.spRepository.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/update/" + chiTietDoGo.getId());
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyChiTietDoGo oldValue,
                         Model model, @Valid @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGoVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("chiTietDoGo", oldValue);
            List<QuanLySP> spList = this.spRepository.findAll();
            List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
            List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
            List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
            List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
            List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
            List<QuanLyAnh> anhList = this.anhRepository.findAll();

            model.addAttribute("spList", spList);
            model.addAttribute("loaiSPList", loaiSPList);
            model.addAttribute("dongGoList", dongGoList);
            model.addAttribute("nhaCungCapList", nhaCungCapList);
            model.addAttribute("nguonGocList", nguonGocList);
            model.addAttribute("donViTinhList", donViTinhList);
            model.addAttribute("anhList", anhList);
            model.addAttribute("action", "/admin/chi-tiet-do-go/update/" + oldValue.getId());
            model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
            return "layoutMenu";
        }

        QuanLyChiTietDoGo chiTietDoGo = QuanLyChiTietDoGo.builder()
                .id(oldValue.getId())
                .idSanPham(newValue.getIdSanPham())
                .idLoaiSP(newValue.getIdLoaiSP())
                .idDongGo(newValue.getIdDongGo())
                .idNhaCungCap(newValue.getIdNhaCungCap())
                .idNguonGoc(newValue.getIdNguonGoc())
                .idDonViTinh(newValue.getIdDonViTinh())
                .idAnh(newValue.getIdAnh())
                .tenSP(newValue.getTenSP())
                .soLuong(newValue.getSoLuong())
                .giaNhap(newValue.getGiaNhap())
                .giaBan(newValue.getGiaBan())
                .moTa(newValue.getMoTa())
                .trangThai(newValue.getTrangThai())
                .build();

        this.chiTietDoGoRepository.save(chiTietDoGo);
        return "redirect:/admin/chi-tiet-do-go/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyChiTietDoGo chiTietDoGo) {
        this.chiTietDoGoRepository.delete(chiTietDoGo);
        return "redirect:/admin/chi-tiet-do-go/index";
    }


}


