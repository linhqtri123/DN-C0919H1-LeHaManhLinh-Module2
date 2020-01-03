package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String get(){
        return"convert";
    }

    @PostMapping("/calculator")
    public String convert(@RequestParam float rate, @RequestParam float usd, Model model){
        float vnd = rate*usd;
        model.addAttribute("rate",rate);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "converted";
    }
}
