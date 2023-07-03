package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyDongGo;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyDongGoRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyDongGoVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/dong-go")
public class QuanLyDongGoController {
    @Autowired
    private QuanLyDongGoRepository dgRepo;

    @Autowired
    private QuanLyDongGoVM dongGoVM;

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("dg", dongGoVM);
        model.addAttribute("action","/admin/dong-go/store");
        model.addAttribute("view","/views/dong_go/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("dg") QuanLyDongGo dongGo,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/dong_go/create.jsp");
            return "layoutMenu";
        }
        QuanLyDongGo dongGo1 = QuanLyDongGo.builder()
                .ma(dongGo.getMa())
                .ten(dongGo.getTen())
                .build();

        this.dgRepo.save(dongGo1);
        return "redirect:/admin/dong-go/index";

    }

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyDongGo> dg = this.dgRepo.findAll();
        model.addAttribute("data",dg);
        model.addAttribute("view","/views/dong_go/hien_thi.jsp");
        return "layoutMenu";

    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyDongGo dongGo){
        this.dgRepo.delete(dongGo);
        return "redirect:/admin/dong-go/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")QuanLyDongGo dongGo,Model model){

        model.addAttribute("dg",dongGo);
        model.addAttribute("action","/admin/dong-go/update/" + dongGo.getId());
        model.addAttribute("view","/views/dong_go/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") QuanLyDongGo oldValue,
                         Model model, @Valid @ModelAttribute("dg") QuanLyDongGoVM newValue, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("dvt",oldValue);
            model.addAttribute("action","/admin/dong-go/update/"+ oldValue.getId());
            model.addAttribute("view","/views/dong_go/create.jsp");
            return "layoutMenu";
        }
        QuanLyDongGo dongGo = QuanLyDongGo.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .build();
        this.dgRepo.save(dongGo);
        return "redirect:/admin/dong-go/index";
    }
}
