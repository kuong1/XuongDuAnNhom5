package fplhn.nhom5.xuongDuAn.controllers;


import fplhn.nhom5.xuongDuAn.entities.QuanLyAnh;
import fplhn.nhom5.xuongDuAn.entities.QuanLyAnhChiTiet;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyAnhChiTietRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyAnhRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhChiTietVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/anh-chi-tiet")
public class QuanLyAnhChiTietController {

    @Autowired
    private QuanLyAnhRepository anhRepository;

    @Autowired
    private QuanLyAnhChiTietRepository anhChiTietRepository;

    @Autowired
    private QuanLyAnhChiTietVM anhChiTietVM;

    @GetMapping("index")
    public String index(Model model) {

        List<QuanLyAnh> anhList = this.anhRepository.findAll();
        List<QuanLyAnhChiTiet> anhChiTietList = this.anhChiTietRepository.findAll();
        model.addAttribute("anhList", anhList);
        model.addAttribute("anhChiTietList", anhChiTietList);
        model.addAttribute("view", "/views/anh_chi_tiet/hien_thi.jsp");

        return "layoutMenu";
    }


    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("anh", anhChiTietVM);
        List<QuanLyAnh> anhList = this.anhRepository.findAll();
        model.addAttribute("anhList", anhList);
        model.addAttribute("action", "/admin/anh-chi-tiet/store");
        model.addAttribute("view", "/views/anh_chi_tiet/create.jsp");
        return "layoutMenu";
    }


    @PostMapping("store")
    public String store(@Valid @ModelAttribute("anh") QuanLyAnhChiTietVM anhChiTietVM, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<QuanLyAnh> anhList = this.anhRepository.findAll();
            List<QuanLyAnhChiTiet> anhChiTietList = this.anhChiTietRepository.findAll();
            model.addAttribute("anhList", anhList);
            model.addAttribute("anhChiTietList", anhChiTietList);
            model.addAttribute("view", "/views/anh_chi_tiet/create.jsp");
            return "layoutMenu";
        }


        QuanLyAnhChiTiet anhChiTiet = QuanLyAnhChiTiet.builder()
                .idAnh(anhChiTietVM.getIdAnh())
                .image(anhChiTietVM.getImage())
                .ma(anhChiTietVM.getMa())
                .trangThai(anhChiTietVM.getTrangThai())
                .build();

        this.anhChiTietRepository.save(anhChiTiet);
        return "redirect:/admin/anh-chi-tiet/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyAnhChiTiet anhChiTiet, Model model) {

        model.addAttribute("anh", anhChiTiet);
        List<QuanLyAnh> anhList = this.anhRepository.findAll();
        model.addAttribute("anhList", anhList);
        model.addAttribute("action", "/admin/anh-chi-tiet/update/" + anhChiTiet.getId());
        model.addAttribute("view", "/views/anh_chi_tiet/create.jsp");
        return "layoutMenu";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyAnhChiTiet oldValue,
                         Model model, @Valid @ModelAttribute("anh") QuanLyAnhChiTietVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            List<QuanLyAnh> anhList = this.anhRepository.findAll();
            model.addAttribute("anhList", anhList);
            model.addAttribute("anh", oldValue);
            model.addAttribute("action", "/admin/anh-chi-tiet/update/" + oldValue.getId());
            model.addAttribute("view", "/views/anh_chi_tiet/create.jsp");
            return "layoutMenu";
        }

        QuanLyAnhChiTiet quanLyAnhChiTiet = QuanLyAnhChiTiet.builder()
                .id(oldValue.getId())
                .idAnh(newValue.getIdAnh())
                .ma(newValue.getMa())
                .image(newValue.getImage())
                .trangThai(newValue.getTrangThai())
                .build();

        this.anhChiTietRepository.save(quanLyAnhChiTiet);
        return "redirect:/admin/anh-chi-tiet/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyAnhChiTiet anhChiTiet) {
        this.anhChiTietRepository.delete(anhChiTiet);
        return "redirect:/admin/anh-chi-tiet/index";
    }




}
