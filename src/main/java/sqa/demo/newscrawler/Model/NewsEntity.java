package sqa.demo.newscrawler.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EntityScan(basePackages = {"NewsCrawler.Model"})
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news")
    private Integer ID;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "url")
    private String Url;

    @Column(name = "opening")
    private String opening;

    @Column(name = "content")
    private String content;

    @Column(name = "time")
    private String time;

    @Column(name = "category")
    private String category;

    public NewsEntity() {
    }

    public NewsEntity(Integer ID, String title, String publisher, String url, String opening, String content, String time, String category) {
        this.ID = ID;
        this.title = title;
        this.publisher = publisher;
        this.Url = url;
        this.opening = opening;
        this.content = content;
        this.category = category;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
