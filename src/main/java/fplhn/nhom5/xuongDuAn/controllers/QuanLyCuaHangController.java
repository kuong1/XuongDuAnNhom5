package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyChucVu;
import fplhn.nhom5.xuongDuAn.entities.QuanLyCuaHang;
import fplhn.nhom5.xuongDuAn.entities.QuanLyDongGo;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyChucVuRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyCuaHangRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyChucVuVM;
import fplhn.nhom5.xuongDuAn.request.QuanLyCuaHangVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/cua-hang")
public class QuanLyCuaHangController {

    @Autowired
    private QuanLyCuaHangRepository quanLyCuaHangRepository;

    @Autowired
    private QuanLyCuaHangVM spVM;

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyCuaHang> dg = this.quanLyCuaHangRepository.findAll();
        model.addAttribute("data",dg);
        model.addAttribute("view","/views/cua_hang/hien_thi.jsp");
        return "layoutMenu";

    }


    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", spVM);
        model.addAttribute("action","/admin/cua-hang/store");
        model.addAttribute("view","/views/cua_hang/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") QuanLyCuaHangVM spVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/cua_hang/create.jsp");
            return "layoutMenu";
        }
        QuanLyCuaHang sp = QuanLyCuaHang.builder()
                .ma(spVM.getMa())
                .ten(spVM.getTen())
                .diaChi(spVM.getDiaChi())

                .build();

        this.quanLyCuaHangRepository.save(sp);
        return "redirect:/admin/cua-hang/index";

    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") QuanLyCuaHang dongGo){
        this.quanLyCuaHangRepository.delete(dongGo);
        return "redirect:/admin/cua-hang/index";
    }
}
