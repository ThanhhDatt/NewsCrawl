package sqa.demo.newscrawler.Utils.Dantri;

public class DantriNews {
    private String title;
    private String url;
    private String opening;
    private String content;
    private String time;
    private String category;

    public DantriNews() {
    }

    public DantriNews(String title, String url, String opening, String content, String time, String category) {
        this.title = title;
        this.url = url;
        this.opening = opening;
        this.content = content;
        this.time = time;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
