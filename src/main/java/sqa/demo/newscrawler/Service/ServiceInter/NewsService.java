package sqa.demo.newscrawler.Service.ServiceInter;

import sqa.demo.newscrawler.Model.NewsEntity;

import java.util.Collection;

public interface NewsService {
    Collection<String> showAllTitle();
    Collection<NewsEntity> mostRecentNews();
    Collection<NewsEntity> mostReadNews();
    Collection<NewsEntity> showNewsByCategory(String category);
    void deleteAllNews();
    void deleteNewsByID(Integer ID);
    void initNews(Collection<NewsEntity> news);
    void update(Collection<NewsEntity> news);
}
