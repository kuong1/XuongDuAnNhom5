package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyAnh;
import fplhn.nhom5.xuongDuAn.entities.QuanLyChucVu;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyAnhRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyAnhVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyChucVuVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/anh")
public class QuanLyAnhController {

    @Autowired
    private QuanLyAnhRepository anhRepository;

    @Autowired
    private QuanLyAnhVM anhVM;

    @GetMapping("index")
    public String index(Model model) {
        List<QuanLyAnh> listAnh = this.anhRepository.findAll();
        model.addAttribute("listAnh", listAnh);
        model.addAttribute("view", "/views/anh/hien_thi.jsp");
        return "layoutMenu";

    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("anh", anhVM);
        model.addAttribute("action", "/admin/anh/store");
        model.addAttribute("view", "/views/anh/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("anh") QuanLyAnhVM anhVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/anh/create.jsp");
            return "layoutMenu";
        }

        QuanLyAnh anh = QuanLyAnh.builder()
                .ma(anhVM.getMa())
                .trangThai(anhVM.getTrangThai())
                .build();

        this.anhRepository.save(anh);
        return "redirect:/admin/anh/index";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyAnh anh, Model model) {

        model.addAttribute("anh", anh);
        model.addAttribute("action", "/admin/anh/update/" + anh.getId());
        model.addAttribute("view", "/views/anh/create.jsp");
        return "layoutMenu";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyAnh oldValue,
                         Model model, @Valid @ModelAttribute("anh") QuanLyAnhVM newValue, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("anh", oldValue);
            model.addAttribute("action", "/admin/anh/update/" + oldValue.getId());
            model.addAttribute("view", "/views/anh/create.jsp");
            return "layoutMenu";
        }

        QuanLyAnh quanLyAnh = QuanLyAnh.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .trangThai(newValue.getTrangThai())
                .build();

        this.anhRepository.save(quanLyAnh);
        return "redirect:/admin/anh/index";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyAnh anh) {
        this.anhRepository.delete(anh);
        return "redirect:/admin/anh/index";
    }


}
