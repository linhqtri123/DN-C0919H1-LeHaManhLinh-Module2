package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.SimpleDictionaryService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleDictionaryController {
    Map<String,String> dic = SimpleDictionaryService.getAllValue();

    @GetMapping("/dictionary")
    public String dictionay() {
        return "enterEnglishDictionary";
    }

    @PostMapping("/dictionary")
    public String getResult(@RequestParam String search, Model model) {
        String result;
        result = dic.get(search);
        if (result != null) {
            model.addAttribute("search", search);
            model.addAttribute("result", result);
        } else {
            return "notFound";
        }
        return "dictionary";
    }
}
