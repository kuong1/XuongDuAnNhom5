package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyDonViTinh;
import fplhn.nhom5.xuongDuAn.entities.QuanLyNguonGoc;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyNguonGocRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyDonViTinhVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyNguonGocVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/nguon-goc")
public class QuanLyNguonGocController {
    @Autowired
    private QuanLyNguonGocRepository ngRepo;
    @Autowired
    private QuanLyNguonGocVM nguonGocVM;
    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("ng", nguonGocVM);
        model.addAttribute("action","/admin/nguon-goc/store");
        model.addAttribute("view","/views/nguon_goc/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("ng") QuanLyNguonGocVM nguonGocVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/nguon_goc/create.jsp");
            return "layoutMenu";
        }
        QuanLyNguonGoc nguonGoc = QuanLyNguonGoc.builder()
                .ma(nguonGocVM.getMa())
                .quocGia(nguonGocVM.getQuocGia())
                .build();

        this.ngRepo.save(nguonGoc);
        return "redirect:/admin/nguon-goc/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyNguonGoc> ng= this.ngRepo.findAll();
        model.addAttribute("data",ng);
        model.addAttribute("view","/views/nguon_goc/hien_thi.jsp");
        return "layoutMenu";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyNguonGoc nguonGoc){
        this.ngRepo.delete(nguonGoc);
        return "redirect:/admin/nguon-goc/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")QuanLyNguonGoc nguonGoc,Model model){

        model.addAttribute("ng",nguonGoc);
        model.addAttribute("action","/admin/nguon-goc/update/" + nguonGoc.getId());
        model.addAttribute("view","/views/nguon_goc/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyNguonGoc oldValue,
                         Model model,@Valid @ModelAttribute("ng")QuanLyNguonGocVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("ng",oldValue);
            model.addAttribute("action","/admin/nguon-goc/update/"+ oldValue.getId());
            model.addAttribute("view","/views/nguon_goc/create.jsp");
            return "layoutMenu";
        }
        QuanLyNguonGoc nguonGoc = QuanLyNguonGoc.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .quocGia(newValue.getQuocGia())
                .build();
        this.ngRepo.save(nguonGoc);
        return "redirect:/admin/nguon-goc/index";
    }


}
