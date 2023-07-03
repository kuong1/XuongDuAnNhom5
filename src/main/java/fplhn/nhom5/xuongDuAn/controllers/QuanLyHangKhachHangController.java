package fplhn.nhom5.xuongDuAn.controllers;

import fplhn.nhom5.xuongDuAn.entities.QuanLyDongGo;
import fplhn.nhom5.xuongDuAn.entities.QuanLyHangKhachHang;
import fplhn.nhom5.xuongDuAn.entities.QuanLyNhaCungCap;
import fplhn.nhom5.xuongDuAn.entities.QuanLySP;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyDongGoRepository;
import fplhn.nhom5.xuongDuAn.repositories.QuanLyHangKhachHangRepository;
import fplhn.nhom5.xuongDuAn.request.QuanLyHangKhachHangVM;
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
@RequestMapping("admin/hang-khach-hang")
public class QuanLyHangKhachHangController {

    @Autowired
    private QuanLyHangKhachHangRepository hangKhachHangRepository;

    @Autowired
    private QuanLyHangKhachHangVM spVM;

    @GetMapping("index")
    public String index(Model model){
        List<QuanLyHangKhachHang> dg = this.hangKhachHangRepository.findAll();
        model.addAttribute("data",dg);
        model.addAttribute("view","/views/hang_khach_hang/hien_thi.jsp");
        return "layoutMenu";

    }


    @GetMapping("create")
    public String create(Model model){

        model.addAttribute("sp", spVM);
        model.addAttribute("action","/admin/hang-khach-hang/store");
        model.addAttribute("view","/views/hang_khach_hang/create.jsp");
        return "layoutMenu";

    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("sp") QuanLyHangKhachHang spVM,
                        BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("view","/views/hang_khach_hang/create.jsp");
            return "layoutMenu";
        }
        QuanLyHangKhachHang sp = QuanLyHangKhachHang.builder()
                .maHang(spVM.getMaHang())
                .tenHang(spVM.getTenHang())
                .moTa(spVM.getMoTa())
                .diemTichLuy(spVM.getDiemTichLuy())
                .build();

        this.hangKhachHangRepository.save(sp);
        return "redirect:/admin/hang-khach-hang/index";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")QuanLyHangKhachHang dongGo){
        this.hangKhachHangRepository.delete(dongGo);
        return "redirect:/admin/hang-khach-hang/index";
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") QuanLyHangKhachHang sp, Model model){

        model.addAttribute("sp",sp);
        model.addAttribute("action","/admin/hang-khach-hang/update/" + sp.getId());
        model.addAttribute("view","/views/hang_khach_hang/create.jsp");
        return "layoutMenu";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id")QuanLyHangKhachHang oldValue,
                         Model model, @Valid @ModelAttribute("sp") QuanLyHangKhachHangVM newValue, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("sp",oldValue);
            model.addAttribute("action","/admin/hang-khach-hang/update/"+ oldValue.getId());
            model.addAttribute("view","/views/hang_khach_hang/create.jsp");
            return "layoutMenu";
        }
        QuanLyHangKhachHang sp = QuanLyHangKhachHang.builder()
                .id(oldValue.getId())
                .maHang(newValue.getMaHang())
                .tenHang(newValue.getTenHang())
                .moTa(newValue.getMoTa())
                .diemTichLuy(Integer.parseInt(newValue.getDiemTichLuy()))
                .build();
        this.hangKhachHangRepository.save(sp);
        return "redirect:/admin/hang-khach-hang/index";
    }
}
