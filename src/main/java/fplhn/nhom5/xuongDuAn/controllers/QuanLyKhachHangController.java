package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyAnh;
import fplhn.nhom5.xuongDuAn.entities.QuanLyAnhChiTiet;
import fplhn.nhom5.xuongDuAn.entities.QuanLyHangKhachHang;
import fplhn.nhom5.xuongDuAn.entities.QuanLyKhachHang;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyHangKhachHangRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyKhachHangRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhChiTietVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyKhachHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/khach-hang")
public class QuanLyKhachHangController {


    @Autowired
    private QuanLyKhachHangRepository khachHangRepository;

    @Autowired
    private QuanLyHangKhachHangRepository hangRepository;

    @Autowired
    private QuanLyKhachHangVM khachHangVM;

    @GetMapping("index")
    public String index(Model model) {

        List<QuanLyKhachHang> khachHangList = this.khachHangRepository.findAll();
        List<QuanLyHangKhachHang> hangKhachHangList = this.hangRepository.findAll();
        model.addAttribute("khachHangList", khachHangList);
        model.addAttribute("hangKhachHangList", hangKhachHangList);
        model.addAttribute("view", "/views/khach_hang/hien_thi.jsp");

        return "layoutMenu";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("khachHang", khachHangVM);
        List<QuanLyHangKhachHang> hangKhachHangList = this.hangRepository.findAll();
        model.addAttribute("hangKhachHangList", hangKhachHangList);
        model.addAttribute("action", "/admin/khach-hang/store");
        model.addAttribute("view", "/views/khach_hang/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("khachHang") QuanLyKhachHangVM khachHangVM, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<QuanLyKhachHang> khachHangList = this.khachHangRepository.findAll();
            List<QuanLyHangKhachHang> hangKhachHangList = this.hangRepository.findAll();
            model.addAttribute("khachHangList", khachHangList);
            model.addAttribute("hangKhachHangList", hangKhachHangList);
            model.addAttribute("view", "/views/khach_hang/create.jsp");
            return "layoutMenu";
        }


        QuanLyKhachHang kh = QuanLyKhachHang.builder()
                .ma(khachHangVM.getMa())
                .tenKhachHang(khachHangVM.getTenKhachHang())
                .sdt(khachHangVM.getSdt())
                .diaChi(khachHangVM.getDiaChi())
                .trangThai(khachHangVM.getTrangThai())
                .idHangKhachHang(khachHangVM.getIdHangKhachHang())
                .build();


        this.khachHangRepository.save(kh);
        return "redirect:/admin/khach-hang/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyKhachHang khachHang, Model model) {

        model.addAttribute("khachHang", khachHang);
        List<QuanLyHangKhachHang> hangKhachHangList = this.hangRepository.findAll();
        model.addAttribute("hangKhachHangList", hangKhachHangList);
        model.addAttribute("action", "/admin/khach-hang/update/" + khachHang.getId());
        model.addAttribute("view", "/views/khach_hang/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyKhachHang oldValue,
                         Model model, @Valid @ModelAttribute("khachHang") QuanLyKhachHangVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            List<QuanLyHangKhachHang> hangKhachHangList = this.hangRepository.findAll();
            model.addAttribute("hangKhachHangList", hangKhachHangList);
            model.addAttribute("khachHang", oldValue);
            model.addAttribute("action", "/admin/khach-hang/update/" + oldValue.getId());
            model.addAttribute("view", "/views/khach_hang/create.jsp");
            return "layoutMenu";
        }

        QuanLyKhachHang kh = QuanLyKhachHang.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .tenKhachHang(newValue.getTenKhachHang())
                .sdt(newValue.getSdt())
                .diaChi(newValue.getDiaChi())
                .trangThai(newValue.getTrangThai())
                .idHangKhachHang(newValue.getIdHangKhachHang())
                .build();

        this.khachHangRepository.save(kh);
        return "redirect:/admin/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyKhachHang khachHang) {
        this.khachHangRepository.delete(khachHang);
        return "redirect:/admin/khach-hang/index";
    }


}
