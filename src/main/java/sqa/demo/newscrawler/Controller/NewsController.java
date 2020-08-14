package sqa.demo.newscrawler.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sqa.demo.newscrawler.Model.NewsEntity;
import sqa.demo.newscrawler.Service.ServiceInter.NewsService;
import sqa.demo.newscrawler.Utils.Crawler;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class NewsController {
    public final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(){
        return "home.html";
    }

    @RequestMapping("/genk")
    public String Genk(Model model) throws IOException {
        ArrayList<NewsEntity> genk = Crawler.GenkCrawler();
        model.addAttribute("genk", genk);
        return "genk";
    }

    @RequestMapping("/dantri")
    public String Dantri(Model model) throws IOException {
        ArrayList<NewsEntity> dantri = Crawler.DantriCrawler();
        model.addAttribute("dantri", dantri);
        return "dantri";
    }
}
