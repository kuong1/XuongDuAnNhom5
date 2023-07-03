package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyChiTietDoGo;
import fplhn.nhom5.xuongDuAn.entities.QuanLyLichSuNhap;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyChiTietDoGoRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyLichSuNhapRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyLichSuNhapVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("admin/lich-su-nhap")
public class QuanLyLichSuNhapController {

    @Autowired
    QuanLyChiTietDoGoRepository chiTietDoGoRepository;

    @Autowired
    QuanLyLichSuNhapRepository lichSuNhapRepository;

    @Autowired
    QuanLyLichSuNhapVM lichSuNhapVM;

    @GetMapping("index")
    public String index(Model model) {

        List<QuanLyLichSuNhap> quanLyLichSuNhapList = this.lichSuNhapRepository.findAll();
        List<QuanLyChiTietDoGo> chiTietDoGoList = this.chiTietDoGoRepository.findAll();
        model.addAttribute("lichSuNhapList", quanLyLichSuNhapList);
        model.addAttribute("chiTietDoGoList", chiTietDoGoList);
        model.addAttribute("view", "/views/lich_su_nhap/hien_thi.jsp");

        return "layoutMenu";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("lsn", lichSuNhapVM);
        model.addAttribute("chiTietDoGoList",chiTietDoGoRepository.findAll());
        model.addAttribute("action", "/admin/lich-su-nhap/store");
        model.addAttribute("view", "/views/lich_su_nhap/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("lsn") QuanLyLichSuNhapVM lsnVM,
                        BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<QuanLyLichSuNhap> quanLyLichSuNhapList = this.lichSuNhapRepository.findAll();
            List<QuanLyChiTietDoGo> chiTietDoGoList = this.chiTietDoGoRepository.findAll();
            model.addAttribute("lichSuNhapList", quanLyLichSuNhapList);
            model.addAttribute("chiTietDoGoList", chiTietDoGoList);
            model.addAttribute("view", "/views/lich_su_nhap/create.jsp");
            return "layoutMenu";
        }
        String date = String.valueOf(LocalDate.now());
        QuanLyLichSuNhap quanLyLichSuNhap = QuanLyLichSuNhap.builder()
                .idSpNhap(lsnVM.getIdSpNhap())
                .soLongNhap(lsnVM.getSoLongNhap())
                .ngayNhap(date)
                .tongTienNhap(lsnVM.getTongTienNhap()).build();

        this.lichSuNhapRepository.save(quanLyLichSuNhap);
        return "redirect:/admin/lich-su-nhap/index";

    }

}
