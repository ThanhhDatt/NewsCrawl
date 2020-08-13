package sqa.demo.newscrawler.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sqa.demo.newscrawler.Model.NewsEntity;
import sqa.demo.newscrawler.Repository.RepositoryInter.NewsRepository;
import sqa.demo.newscrawler.Service.ServiceInter.NewsService;

import java.util.Collection;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional
    public Collection<String> showAllTitle() {
        return newsRepository.showAllTitle();
    }

    @Override
    @Transactional
    public Collection<NewsEntity> mostRecentNews() {
        return newsRepository.mostRecentNews();
    }

    @Override
    @Transactional
    public Collection<NewsEntity> mostReadNews() {
        return newsRepository.mostReadNews();
    }

    @Override
    @Transactional
    public Collection<NewsEntity> showNewsByCategory(String category) {
        return newsRepository.showNewsByCategory(category);
    }

    @Override
    @Transactional
    public void deleteAllNews() {
        newsRepository.deleteAllNews();
    }

    @Override
    @Transactional
    public void deleteNewsByID(Integer ID) {
        newsRepository.deleteNewsByID(ID);
    }

    @Override
    @Transactional
    public void initNews(Collection<NewsEntity> news) {
        newsRepository.initNews(news);
    }

    @Override
    @Transactional
    public void update(Collection<NewsEntity> news) {
        newsRepository.update(news);
    }
}
