package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyLoaiSP;
import fplhn.nhom5.xuongDuAn.entities.QuanLySP;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyLoaiSPRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLySPRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyLoaiSPVM;
import fplhn.nhom5.xuongDuAn.request.QuanLySPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/san-pham")
public class QuanLySPController {
    @Autowired
    private QuanLySPRepository spRepo;

    @Autowired
    private QuanLySPVM spVM;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", spVM);
        model.addAttribute("action","/admin/san-pham/store");
        model.addAttribute("view","/views/san_pham/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") QuanLySPVM spVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/san_pham/create.jsp");
            return "layoutMenu";
        }
        QuanLySP sp = QuanLySP.builder()
                .ma(spVM.getMa())
                .ten(spVM.getTen())
                .build();

        this.spRepo.save(sp);
        return "redirect:/admin/san-pham/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<QuanLySP> sp = this.spRepo.findAll();
        model.addAttribute("data",sp);
        model.addAttribute("view","/views/san_pham/hien_thi.jsp");
        return "layoutMenu";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLySP sp){
        this.spRepo.delete(sp);
        return "redirect:/admin/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")QuanLySP sp,Model model){

        model.addAttribute("sp",sp);
        model.addAttribute("action","/admin/san-pham/update/" + sp.getId());
        model.addAttribute("view","/views/san_pham/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLySP oldValue,
                         Model model,@Valid @ModelAttribute("sp")QuanLySPVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("sp",oldValue);
            model.addAttribute("action","/admin/san-pham/update/"+ oldValue.getId());
            model.addAttribute("view","/views/san_pham/create.jsp");
            return "layoutMenu";
        }
        QuanLySP sp = QuanLySP.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.spRepo.save(sp);
        return "redirect:/admin/san-pham/index";
    }
}
