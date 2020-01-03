package com.example.casestudy.controller;

import com.example.casestudy.model.FuramaDichVu;
import com.example.casestudy.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    DichVuService dichVuService;

    @GetMapping("/home")
    public ModelAndView homePage(){
        return new ModelAndView("furama/home","listdichvu",dichVuService.getAllDichVu());
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
}
