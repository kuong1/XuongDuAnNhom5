package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyChucVu;
import fplhn.nhom5.xuongDuAn.entities.QuanLyDongGo;
import fplhn.nhom5.xuongDuAn.entities.QuanLyNhaCungCap;
import fplhn.nhom5.xuongDuAn.entities.QuanLySP;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyChucVuRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyDongGoRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyChucVuVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyDongGoVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyNhaCungCapVM;
import fplhn.nhom5.xuongDuAn.request.QuanLySPVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/chuc-vu")
public class QuanLyChucVuController {

    @Autowired
    private QuanLyChucVuRepository chucVuRepository;

    @Autowired
    private QuanLyChucVuVM spVM;

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyChucVu> dg = this.chucVuRepository.findAll();
        model.addAttribute("data",dg);
        model.addAttribute("view","/views/chuc_vu/hien_thi.jsp");
        return "layoutMenu";

    }


    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", spVM);
        model.addAttribute("action","/admin/chuc-vu/store");
        model.addAttribute("view","/views/chuc_vu/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") QuanLyChucVuVM spVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/chuc_vu/create.jsp");
            return "layoutMenu";
        }
        QuanLyChucVu sp = QuanLyChucVu.builder()
                .ma(spVM.getMa())
                .ten(spVM.getTenChucVu())

                .build();

        this.chucVuRepository.save(sp);
        return "redirect:/admin/chuc-vu/index";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyChucVu dongGo){
        this.chucVuRepository.delete(dongGo);
        return "redirect:/admin/chuc-vu/index";
    }



    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyChucVu sp, Model model){

        model.addAttribute("sp",sp);
        model.addAttribute("action","/admin/chuc-vu/update/" + sp.getId());
        model.addAttribute("view","/views/chuc_vu/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyChucVu oldValue,
                         Model model, @Valid @ModelAttribute("sp") QuanLyChucVuVM newValue, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("sp",oldValue);
            model.addAttribute("action","/admin/chuc-vu/update/"+ oldValue.getId());
            model.addAttribute("view","/views/chuc_vu/create.jsp");
            return "layoutMenu";
        }
        QuanLyChucVu sp = QuanLyChucVu.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTenChucVu())
                .build();
        this.chucVuRepository.save(sp);
        return "redirect:/admin/chuc-vu/index";
    }



}
