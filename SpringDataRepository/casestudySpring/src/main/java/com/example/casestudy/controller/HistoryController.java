package com.example.casestudy.controller;

import com.example.casestudy.model.FuramaHopDong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryController {

    @GetMapping("/history")
    public ModelAndView getHistoryPage(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("furama/history");
        Cookie[] cookies = request.getCookies();
        List<FuramaHopDong> listHopDong = new ArrayList<>();
        for(int i= 0; i < cookies.length;i++){
            if(cookies[i].getName().contains("hopdong")){
                FuramaHopDong hopDong = new FuramaHopDong();
                String[] cookieValue = cookies[i].getValue().split("\\_");
                hopDong.setId(Long.parseLong(cookieValue[0]));
                hopDong.setIdDichVu(Long.parseLong(cookieValue[1]));
                hopDong.setNgayLamHopDong(Date.valueOf(cookieValue[2]));
                hopDong.setNgayKetThuc(Date.valueOf(cookieValue[3]));
                listHopDong.add(hopDong);
            }
        }
        modelAndView.addObject("historyHopDong",listHopDong);
        return modelAndView;
    }
}
