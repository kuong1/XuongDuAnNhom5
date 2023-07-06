package fplhn.nhom5.xuongDuAn.controllers;


import fplhn.nhom5.xuongDuAn.entities.*;
import fplhn.nhom5.xuongDuAn.repositories.*;
import fplhn.nhom5.xuongDuAn.request.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ThemNhanhController {

    @Autowired
    private QuanLySPRepository spRepo;

    @Autowired
    private QuanLySPVM spVM;

    @Autowired
    private QuanLyChiTietDoGoRepository chiTietDoGoRepository;


    @Autowired
    private QuanLyLoaiSPRepository loaiSPRepository;

    @Autowired
    private QuanLyLoaiSPVM loaiSPVM;

    @Autowired
    private QuanLyDongGoRepository dongGoRepository;

    @Autowired
    private QuanLyDongGoVM dongGoVM;

    @Autowired
    private QuanLyNhaCungCapRepository nhaCungCapRepository;

    @Autowired
    private QuanLyNhaCungCapVM nhaCungCapVM;

    @Autowired
    private QuanLyNguonGocRepository nguonGocRepository;

    @Autowired
    private QuanLyNguonGocVM nguonGocVM;

    @Autowired
    private QuanLyDonViTinhRepository donViTinhRepository;

    @Autowired
    private QuanLyDonViTinhVM donViTinhVM;

    @Autowired
    private QuanLyAnhRepository anhRepository;

    @Autowired
    private QuanLyAnhVM anhVM;

    @Autowired
    private QuanLyChiTietDoGoVM chiTietDoGoVM;

    private static QuanLyChiTietDoGo dogodd = new QuanLyChiTietDoGo();


    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-sp", method = RequestMethod.POST)
    public String sanPham(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("sp", spVM);
        model.addAttribute("action", "/admin/them-nhanh/san-pham/store");
        model.addAttribute("view", "/views/san_pham/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/san-pham/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("sp") QuanLySPVM spVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/san-pham/store?");
            model.addAttribute("view", "/views/san_pham/create.jsp");
            return "layoutMenu";
        }
        QuanLySP sp = QuanLySP.builder()
                .ma(spVM.getMa())
                .ten(spVM.getTen())
                .build();

        this.spRepo.save(sp);
        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }


    //Them nhanh loai san pham:
    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-lsp", method = RequestMethod.POST)
    public String loaiSP(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("lsp", loaiSPVM);
        model.addAttribute("action", "/admin/them-nhanh/loai-san-pham/store");
        model.addAttribute("view", "/views/loai_sp/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/loai-san-pham/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("lsp") QuanLyLoaiSPVM loaiSPVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/loai-san-pham/store?");
            model.addAttribute("view", "/views/loai_sp/create.jsp");
            return "layoutMenu";
        }

        QuanLyLoaiSP loaiSP = QuanLyLoaiSP.builder()
                .ma(loaiSPVM.getMa())
                .ten(loaiSPVM.getTen())
                .build();

        this.loaiSPRepository.save(loaiSP);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }

    //Them nhanh dong go:

    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-dongGo", method = RequestMethod.POST)
    public String dongGo(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("dg", dongGoVM);
        model.addAttribute("action", "/admin/them-nhanh/dong-go/store");
        model.addAttribute("view", "/views/dong_go/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/dong-go/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("dg") QuanLyDongGoVM dongGoVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/dong-go/store?");
            model.addAttribute("view", "/views/dong_go/create.jsp");
            return "layoutMenu";
        }

        QuanLyDongGo dongGo = QuanLyDongGo.builder()
                .ma(dongGoVM.getMa())
                .ten(dongGoVM.getTen())
                .build();

        this.dongGoRepository.save(dongGo);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }


    //Them nhanh Nha Cung Cấp:
    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-ncc", method = RequestMethod.POST)
    public String nhaCungCap(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("sp", nhaCungCapVM);
        model.addAttribute("action", "/admin/them-nhanh/ncc/store");
        model.addAttribute("view", "/views/nha_cung_cap/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/ncc/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("sp") QuanLyNhaCungCapVM nhaCungCapVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/ncc/store?");
            model.addAttribute("view", "/views/nha_cung_cap/create.jsp");
            return "layoutMenu";
        }

        QuanLyNhaCungCap nhaCungCap = QuanLyNhaCungCap.builder()
                .ma(nhaCungCapVM.getMa())
                .ten(nhaCungCapVM.getTen())
                .diaChi(nhaCungCapVM.getDiaChi())
                .dienThoai(nhaCungCapVM.getDienThoai())
                .build();

        this.nhaCungCapRepository.save(nhaCungCap);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }

    //Them nhanh nguon goc:
    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-nguon-goc", method = RequestMethod.POST)
    public String nguonGoc(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("ng", nguonGocVM);
        model.addAttribute("action", "/admin/them-nhanh/nguon-goc/store");
        model.addAttribute("view", "/views/nguon_goc/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/nguon-goc/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("ng") QuanLyNguonGocVM nguonGocVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/nguon-goc/store?");
            model.addAttribute("view", "/views/nguon_goc/create.jsp");
            return "layoutMenu";
        }

        QuanLyNguonGoc nguonGoc = QuanLyNguonGoc.builder()
                .ma(nguonGocVM.getMa())
                .quocGia(nguonGocVM.getQuocGia())
                .build();

        this.nguonGocRepository.save(nguonGoc);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }

    //Them nhanh Don Vi Tinh:
    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-DVT", method = RequestMethod.POST)
    public String donViTinh(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("dvt", donViTinhVM);
        model.addAttribute("action", "/admin/them-nhanh/DVT/store");
        model.addAttribute("view", "/views/don_vi_tinh/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/DVT/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("dvt") QuanLyDonViTinhVM donViTinhVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/DVT/store?");
            model.addAttribute("view", "/views/don_vi_tinh/create.jsp");
            return "layoutMenu";
        }

        QuanLyDonViTinh donViTinh = QuanLyDonViTinh.builder()
                .ma(donViTinhVM.getMa())
                .donViTinh(donViTinhVM.getDonViTinh())
                .build();

        this.donViTinhRepository.save(donViTinh);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }

    //Them nhanh Anh:
    @RequestMapping(value = "/admin/chi-tiet-do-go/store", params = "them-nhanh-anh", method = RequestMethod.POST)
    public String anh(Model model, @ModelAttribute("chiTietDoGo") QuanLyChiTietDoGo dogo) {
        dogodd = dogo;
        model.addAttribute("anh", anhVM);
        model.addAttribute("action", "/admin/them-nhanh/anh/store");
        model.addAttribute("view", "/views/anh/create.jsp");
        return "layoutMenu";
    }

    @RequestMapping(value = "/admin/them-nhanh/anh/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("anh") QuanLyAnhVM anhVM,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/them-nhanh/anh/store?");
            model.addAttribute("view", "/views/anh/create.jsp");
            return "layoutMenu";
        }

        QuanLyAnh quanLyAnh = QuanLyAnh.builder()
                .ma(anhVM.getMa())
                .trangThai(anhVM.getTrangThai())
                .build();

        this.anhRepository.save(quanLyAnh);

        model.addAttribute("chiTietDoGo", dogodd);
        List<QuanLySP> spList = this.spRepo.findAll();
        List<QuanLyLoaiSP> loaiSPList = this.loaiSPRepository.findAll();
        List<QuanLyDongGo> dongGoList = this.dongGoRepository.findAll();
        List<QuanLyNhaCungCap> nhaCungCapList = this.nhaCungCapRepository.findAll();
        List<QuanLyNguonGoc> nguonGocList = this.nguonGocRepository.findAll();
        List<QuanLyDonViTinh> donViTinhList = this.donViTinhRepository.findAll();
        List<QuanLyAnh> anhList = this.anhRepository.findAll();

        model.addAttribute("spList", spList);
        model.addAttribute("loaiSPList", loaiSPList);
        model.addAttribute("dongGoList", dongGoList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("nguonGocList", nguonGocList);
        model.addAttribute("donViTinhList", donViTinhList);
        model.addAttribute("anhList", anhList);

        model.addAttribute("action", "/admin/chi-tiet-do-go/store");
        model.addAttribute("view", "/views/chi_tiet_do_go/create.jsp");
        return "layoutMenu";


    }






}

