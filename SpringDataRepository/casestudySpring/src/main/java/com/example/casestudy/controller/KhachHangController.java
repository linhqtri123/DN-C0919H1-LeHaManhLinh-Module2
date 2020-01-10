package com.example.casestudy.controller;

import com.example.casestudy.model.FuramaKhachHang;
import com.example.casestudy.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/getRegister")
    public ModelAndView getTrangDangKy(){
        return new ModelAndView("customer/register","khachhang", new FuramaKhachHang());
    }

    @PostMapping("/register")
    public ModelAndView saveKhachHang(@Valid @ModelAttribute("khachhang")FuramaKhachHang furamaKhachHang, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("customer/register");
            return modelAndView;
        }else {
            furamaKhachHang.setIdLoaiKhach((long) 1);
            khachHangService.saveKhachHang(furamaKhachHang);
            ModelAndView modelAndView = new ModelAndView("customer/register");
            modelAndView.addObject("message","New Customer Successfully !!!");
            return modelAndView;
        }

    }
}
