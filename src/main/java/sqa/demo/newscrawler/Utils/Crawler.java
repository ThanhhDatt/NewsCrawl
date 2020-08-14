package sqa.demo.newscrawler.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sqa.demo.newscrawler.Model.NewsEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Crawler {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    public static ArrayList<NewsEntity> DantriCrawler() throws IOException {
        ArrayList<NewsEntity> newsList = new ArrayList<>();
        String link = "https://dantri.com.vn/";
        Document document = Jsoup.connect(link).timeout(5000).get();
        Elements news = document.select("h3[class=news-item__title]");
//        Element time = document.selectFirst("span[class=dt-news__time]");
        for(Element e : news){
            NewsEntity item = new NewsEntity();
            item.setTitle(e.children().attr("title"));
            String url = link + e.getAllElements().attr("href");
            item.setUrl(url);
//            item.setTime(time.text());
            item.setPublisher("dantri.com.vn");
            newsList.add(item);
        }
        for(int i=0; i<newsList.size(); i++){
            Document document1 = Jsoup.connect(newsList.get(i).getUrl()).timeout(5000).get();
            Element opening = document1.selectFirst("div[class=dt-news__sapo]");
            Elements content = document1.select("div[class=dt-news__content]");
            String openingContent = opening.select("h2").text();
            newsList.get(i).setOpening(openingContent);
            String contentPage = "";
            for(Element e : content){
                contentPage += e.select("p").text();
                contentPage+="\n";
            }
            newsList.get(i).setContent(contentPage);
        }
        return newsList;
    }

    public static ArrayList<NewsEntity> GenkCrawler() throws IOException {
        ArrayList<NewsEntity> newsList = new ArrayList<>();
        String link = "https://genk.vn/";
        Document document = Jsoup.connect(link).timeout(5000).get();
        Elements titles = document.select("h4[class=knswli-title]");
        for(Element e : titles){
            NewsEntity item = new NewsEntity();
            item.setTitle(e.getAllElements().attr("title"));
            String url = link + e.getAllElements().attr("href");
            item.setUrl(url);
            item.setPublisher("genk.vn");
            newsList.add(item);
        }
        for(int i=0; i<newsList.size(); i++){
            Document document1 = Jsoup.connect(newsList.get(i).getUrl()).timeout(5000).get();
            Element opening = document1.selectFirst("div[class=fr w640]");
            Elements content = document1.select("div[class=knc-content]");
            String openingContent = opening.select("h2[class=knc-sapo]").text();
            newsList.get(i).setOpening(openingContent);
            String contentInPage = "";
            for(Element e : content){
                contentInPage += e.select("p").text();
                contentInPage+="\n";
            }
            newsList.get(i).setContent(contentInPage);
        }
        return newsList;
    }
}
