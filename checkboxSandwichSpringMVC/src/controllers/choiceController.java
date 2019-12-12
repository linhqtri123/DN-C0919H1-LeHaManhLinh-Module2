package controllers;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class choiceController {
    @GetMapping
    public String app() {
        return "index";
    }

    @PostMapping("/choice")
    public String app(@RequestParam(name = "choice") String[] condiment, Model model) {
        model.addAttribute ( "result", Arrays.toString ( condiment ) );
        return "index";
    }

}
