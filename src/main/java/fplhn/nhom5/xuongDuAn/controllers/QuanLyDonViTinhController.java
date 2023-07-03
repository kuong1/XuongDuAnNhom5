package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyDonViTinh;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyDonViTinhRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyDonViTinhVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/don-vi-tinh")
public class QuanLyDonViTinhController {
    @Autowired
    private QuanLyDonViTinhRepository qldvtRepo;

    @Autowired
    private QuanLyDonViTinhVM dvt;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("dvt", dvt);
        model.addAttribute("action","/admin/don-vi-tinh/store");
        model.addAttribute("view","/views/don_vi_tinh/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("dvt") QuanLyDonViTinhVM donViTinhVM,
                        BindingResult result,Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/don_vi_tinh/create.jsp");
            return "layoutMenu";
        }
        QuanLyDonViTinh donViTinh = QuanLyDonViTinh.builder()
                .ma(donViTinhVM.getMa())
                .donViTinh(donViTinhVM.getDonViTinh())
                .build();

        this.qldvtRepo.save(donViTinh);
        return "redirect:/admin/don-vi-tinh/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyDonViTinh> dvt = this.qldvtRepo.findAll();
        model.addAttribute("data",dvt);
        model.addAttribute("view","/views/don_vi_tinh/hien_thi.jsp");
        return "layoutMenu";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyDonViTinh donViTinh){
        this.qldvtRepo.delete(donViTinh);
        return "redirect:/admin/don-vi-tinh/index";
    }
    @GetMapping("edit/{id}")
        public String edit(@PathVariable("id")QuanLyDonViTinh donViTinh,Model model){

        model.addAttribute("dvt",dvt);
        model.addAttribute("action","/admin/dong-vi-tinh/update/" + donViTinh.getId());
        model.addAttribute("view","/views/don_vi_tinh/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyDonViTinh oldValue,
                         Model model,@Valid @ModelAttribute("dvt")QuanLyDonViTinhVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("dvt",oldValue);
            model.addAttribute("action","/admin/don-vi-tinh/update/"+ oldValue.getId());
            model.addAttribute("view","/views/don_vi_tinh/create.jsp");
            return "layoutMenu";
        }
        QuanLyDonViTinh donViTinh = QuanLyDonViTinh.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .donViTinh(newValue.getDonViTinh())
                .build();
        this.qldvtRepo.save(donViTinh);
        return "redirect:/admin/don-vi-tinh/index";
    }


}
