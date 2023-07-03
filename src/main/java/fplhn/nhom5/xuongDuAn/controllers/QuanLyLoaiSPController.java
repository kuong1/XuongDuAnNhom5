package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyLoaiSP;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyLoaiSPRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyLoaiSPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/loai-sp")
public class QuanLyLoaiSPController {
    @Autowired
    private QuanLyLoaiSPRepository lspRepo;

    @Autowired
    private QuanLyLoaiSPVM loaiSPVM;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("lsp", loaiSPVM);
        model.addAttribute("action","/admin/loai-sp/store");
        model.addAttribute("view","/views/loai_sp/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("lsp") QuanLyLoaiSPVM loaiSPVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/loai_sp/create.jsp");
            return "layoutMenu";
        }
        QuanLyLoaiSP loaiSP = QuanLyLoaiSP.builder()
                .ma(loaiSPVM.getMa())
                .ten(loaiSPVM.getTen())
                .build();

        this.lspRepo.save(loaiSP);
        return "redirect:/admin/loai-sp/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyLoaiSP> lsp = this.lspRepo.findAll();
        model.addAttribute("data",lsp);
        model.addAttribute("view","/views/loai_sp/hien_thi.jsp");
        return "layoutMenu";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyLoaiSP loaiSP){
        this.lspRepo.delete(loaiSP);
        return "redirect:/admin/loai-sp/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")QuanLyLoaiSP loaiSP,Model model){

        model.addAttribute("lsp",loaiSP);
        model.addAttribute("action","/admin/loai-sp/update/" + loaiSP.getId());
        model.addAttribute("view","/views/loai_sp/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyLoaiSP oldValue,
                         Model model,@Valid @ModelAttribute("lsp")QuanLyLoaiSPVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("lsp",oldValue);
            model.addAttribute("action","/admin/loai-sp/update/"+ oldValue.getId());
            model.addAttribute("view","/views/loai_sp/create.jsp");
            return "layoutMenu";
        }
        QuanLyLoaiSP loaiSP = QuanLyLoaiSP.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.lspRepo.save(loaiSP);
        return "redirect:/admin/loai-sp/index";
    }
}
