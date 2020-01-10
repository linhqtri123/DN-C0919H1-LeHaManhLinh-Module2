package com.example.casestudy.controller;

import com.example.casestudy.model.FuramaDichVu;
import com.example.casestudy.model.FuramaHopDong;
import com.example.casestudy.service.DichVuService;
import com.example.casestudy.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;


@Controller
public class FuramaController {
    @Autowired
    DichVuService dichVuService;

    @Autowired
    HopDongService hopDongService;

    @GetMapping("/home")
    public ModelAndView homePage(@RequestParam(value = "fromPrice", required = false )String fromPrice,
                                 @RequestParam(value = "toPrice", required = false)String toPrice){
        ModelAndView modelAndView = new ModelAndView("furama/home");
        if(fromPrice == null || toPrice == null){
            modelAndView.addObject("listdichvu",dichVuService.getAllDichVu());
        }else {
            modelAndView.addObject("listdichvu",dichVuService.findAllByChiPhiThueBetween(fromPrice, toPrice));
        }
        return modelAndView;
    }

    @GetMapping("/view-detail/{id}")
    public ModelAndView viewDetail(@PathVariable Long id){
        FuramaDichVu furamaDichVu = dichVuService.getDichVu(id).orElse(null);
        if(furamaDichVu != null) {
            return new ModelAndView("/furama/detail", "dichvu",furamaDichVu);
        }else{
            return new ModelAndView("/error");
        }
    }

    @GetMapping("/booking/{id}")
    public ModelAndView viewBookingForm(@PathVariable Long id){
        return new ModelAndView("/furama/booking","dichvu",dichVuService.getDichVu(id));
    }

    @PostMapping("/booking")
    public ModelAndView saveBooking(@RequestParam(value = "id") Long id, @RequestParam(value = "ngaybatdau")Date ngaybatdau
            , @RequestParam(value = "ngayketthuc") Date ngayketthuc, HttpServletRequest request, HttpServletResponse response){
        FuramaHopDong furamaHopDong = new FuramaHopDong();
        furamaHopDong.setIdDichVu(id);
        furamaHopDong.setNgayLamHopDong(ngaybatdau);
        furamaHopDong.setNgayKetThuc(ngayketthuc);
        furamaHopDong.setIdKhachHang((long) 1);
        furamaHopDong.setIdNhanVien((long) 1);
        hopDongService.saveHopDong(furamaHopDong);
        Iterable<FuramaHopDong> listFuramaHopDong = hopDongService.findAllByIdKhachHang((long)1);
        for(FuramaHopDong hopDong : listFuramaHopDong){
            String cookieValue = hopDong.getId() + "_" + hopDong.getIdDichVu() + "_" + hopDong.getNgayLamHopDong() + "_" +
                    hopDong.getNgayKetThuc();
            Cookie cookie = new Cookie("hopdong"+id,cookieValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/history");
            response.addCookie(cookie);
        }
        ModelAndView modelAndView = new ModelAndView("furama/bookingSuccess");
        return modelAndView;
    }
}
