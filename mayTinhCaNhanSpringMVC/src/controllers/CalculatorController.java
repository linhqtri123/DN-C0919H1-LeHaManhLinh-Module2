package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculatorService;

@Controller
public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService ();

    @GetMapping
    public String app() {
        return "index";
    }

    @PostMapping
    public String app(@RequestParam(name = "numberA") double numberA,
                      @RequestParam(name = "numberB") double numberB,
                      @RequestParam(name = "choice") String choice,
                      Model model) {
        model.addAttribute ( "result",calculatorService.showResult ( choice,numberA,numberB ) );
        return "index";
    }
}
