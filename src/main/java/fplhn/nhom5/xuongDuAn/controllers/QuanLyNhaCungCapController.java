package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyDongGo;
import fplhn.nhom5.xuongDuAn.entities.QuanLyNhaCungCap;
import fplhn.nhom5.xuongDuAn.entities.QuanLySP;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyDongGoRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyNhaCungCapRepository;
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
@RequestMapping("admin/nha-cung-cap")
public class QuanLyNhaCungCapController {

    @Autowired
    private QuanLyNhaCungCapRepository nhaCungCapRepository;

    @Autowired
    private QuanLyNhaCungCapVM spVM;

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyNhaCungCap> dg = this.nhaCungCapRepository.findAll();
        model.addAttribute("data",dg);
        model.addAttribute("view","/views/nha_cung_cap/hien_thi.jsp");
        return "layoutMenu";

    }

    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", spVM);
        model.addAttribute("action","/admin/nha-cung-cap/store");
        model.addAttribute("view","/views/nha_cung_cap/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") QuanLyNhaCungCapVM spVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/nha_cung_cap/create.jsp");
            return "layoutMenu";
        }
        QuanLyNhaCungCap sp = QuanLyNhaCungCap.builder()
                .ma(spVM.getMa())
                .ten(spVM.getTen())
                .diaChi(spVM.getDiaChi())
                .dienThoai(spVM.getDienThoai())
                .build();

        this.nhaCungCapRepository.save(sp);
        return "redirect:/admin/nha-cung-cap/index";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyNhaCungCap dongGo){
        this.nhaCungCapRepository.delete(dongGo);
        return "redirect:/admin/nha-cung-cap/index";
    }



    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id")QuanLyNhaCungCap sp,Model model){

        model.addAttribute("sp",sp);
        model.addAttribute("action","/admin/nha-cung-cap/update/" + sp.getId());
        model.addAttribute("view","/views/nha_cung_cap/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyNhaCungCap oldValue,
                         Model model,@Valid @ModelAttribute("sp")QuanLyNhaCungCapVM newValue,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("sp",oldValue);
            model.addAttribute("action","/admin/nha-cung-cap/update/"+ oldValue.getId());
            model.addAttribute("view","/views/nha_cung_cap/create.jsp");
            return "layoutMenu";
        }
        QuanLyNhaCungCap sp = QuanLyNhaCungCap.builder()
                .id(oldValue.getId())
                .ma(newValue.getMa())
                .ten(newValue.getTen())
                .diaChi(newValue.getDiaChi())
                .dienThoai(newValue.getDienThoai())
                .build();
        this.nhaCungCapRepository.save(sp);
        return "redirect:/admin/nha-cung-cap/index";
    }
}
