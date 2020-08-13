package sqa.demo.newscrawler.Utils.Dantri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ParseToJson {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static String parseNews(ArrayList<DantriNews> news){
        String content = gson.toJson(news);
        System.out.println("All news in page: ");
        System.out.println(news.toString());
        return content;
    }
}
