package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyAnh;
import fplhn.nhom5.xuongDuAn.entities.QuanLyKhuyenMai;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyKhuyenMaiRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyKhuyenMaiVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("admin/khuyen-mai")
public class QuanLyKhuyenMaiController {

    @Autowired
    private QuanLyKhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    private QuanLyKhuyenMaiVM khuyenMaiVM;

    @GetMapping("index")
    public String index(Model model) {
        List<QuanLyKhuyenMai> khuyenMaiList = this.khuyenMaiRepository.findAll();
        model.addAttribute("khuyenMaiList", khuyenMaiList);
        model.addAttribute("view", "/views/khuyen_mai/hien_thi.jsp");
        return "layoutMenu";

    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("khuyenMai", khuyenMaiVM);
        model.addAttribute("action", "/admin/khuyen-mai/store");
        model.addAttribute("view", "/views/khuyen_mai/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("khuyenMai") QuanLyKhuyenMaiVM khuyenMaiVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/khuyen_mai/create.jsp");
            return "layoutMenu";
        }
        String date = String.valueOf(LocalDate.now());
        QuanLyKhuyenMai khuyenMai = QuanLyKhuyenMai.builder()
                .ma(khuyenMaiVM.getMa())
                .tenKhuyenMai(khuyenMaiVM.getTenKhuyenMai())
                .ngayBatDau(date)
                .ngayKetThuc(khuyenMaiVM.getNgayKetThuc())
                .trangThai(khuyenMaiVM.getTrangThai())
                .phanTramKM(khuyenMaiVM.getPhanTramKM())
                .build();

        this.khuyenMaiRepository.save(khuyenMai);
        return "redirect:/admin/khuyen-mai/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyKhuyenMai khuyenMai, Model model) {

        model.addAttribute("khuyenMai", khuyenMai);
        model.addAttribute("action", "/admin/khuyen-mai/update/" + khuyenMai.getId());
        model.addAttribute("view", "/views/khuyen_mai/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyKhuyenMai oldValue,
                         Model model, @Valid @ModelAttribute("anh") QuanLyKhuyenMaiVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("khuyenMai", oldValue);
            model.addAttribute("action", "/admin/khuyen-mai/update/" + oldValue.getId());
            model.addAttribute("view", "/views/khuyen_mai/create.jsp");
            return "layoutMenu";
        }

        String date = String.valueOf(LocalDate.now());
        QuanLyKhuyenMai khuyenMai = QuanLyKhuyenMai.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .tenKhuyenMai(newValue.getTenKhuyenMai())
                .ngayBatDau(date)
                .ngayKetThuc(newValue.getNgayKetThuc())
                .trangThai(newValue.getTrangThai())
                .phanTramKM(newValue.getPhanTramKM())
                .build();

        this.khuyenMaiRepository.save(khuyenMai);
        return "redirect:/admin/khuyen-mai/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyKhuyenMai khuyenMai) {
        this.khuyenMaiRepository.delete(khuyenMai);
        return "redirect:/admin/khuyen-mai/index";
    }



}
