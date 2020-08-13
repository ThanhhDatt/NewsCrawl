package sqa.demo.newscrawler.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sqa.demo.newscrawler.Model.NewsEntity;
import sqa.demo.newscrawler.Utils.Genk.GenkCrawler;

import java.util.ArrayList;

@Controller
public class NewsController {
    @RequestMapping(value = {"/", "/home"})
    public String home(){
        return "home.html";
    }

    @GetMapping("/genk")
    public String Genk(){
        return null;
    }
}
