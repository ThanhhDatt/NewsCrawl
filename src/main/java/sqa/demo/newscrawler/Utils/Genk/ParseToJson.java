package sqa.demo.newscrawler.Utils.Genk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ParseToJson {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static String parseNews(ArrayList<GenkNews> news){
        String content = gson.toJson(news);
        return content;
    }
}
