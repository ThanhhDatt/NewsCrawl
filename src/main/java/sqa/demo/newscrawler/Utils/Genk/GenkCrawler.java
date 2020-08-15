package sqa.demo.newscrawler.Utils.Genk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sqa.demo.newscrawler.Model.NewsEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GenkCrawler{
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

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
            item.setPublisher("Genk");
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
            System.out.println(contentInPage);
            newsList.get(i).setContent(contentInPage);
        }
        return newsList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<NewsEntity> genk = GenkCrawler();
        for(NewsEntity news : genk){
            System.out.println("Title: " + news.getTitle());
        }
    }
}
