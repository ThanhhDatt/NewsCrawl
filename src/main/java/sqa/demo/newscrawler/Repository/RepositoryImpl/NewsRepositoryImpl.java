package sqa.demo.newscrawler.Repository.RepositoryImpl;

import org.springframework.stereotype.Repository;
import sqa.demo.newscrawler.Model.NewsEntity;
import sqa.demo.newscrawler.Repository.RepositoryInter.NewsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<String> showAllTitle() {
        Query query = this.em.createNativeQuery("SELECT title FROM newsmodel");
        return query.getResultList();
    }

    @Override
    public Collection<NewsEntity> mostRecentNews() {
        Query query = this.em.createNativeQuery("SELECT * FROM newsmodel WHERE time " +
                "IN (SELECT MAX(time) FROM newsmodel) LIMIT 10");
        return query.getResultList();
    }

    @Override
    public Collection<NewsEntity> mostReadNews() {
        return null;
    }

    @Override
    public Collection<NewsEntity> showNewsByCategory(String category) {
        Query query = this.em.createNativeQuery("SELECT * FROM newsmodel WHERE category = " + category);
        return query.getResultList();
    }

    @Override
    public void deleteAllNews() {
        Query query = this.em.createNativeQuery("DELETE FROM newsmodel");
        query.executeUpdate();
    }

    @Override
    public void deleteNewsByID(Integer ID) {
        Query query = this.em.createNativeQuery("DELETE FROM newsmodel WHERE ID = " + ID);
        query.executeUpdate();
    }

    @Override
    public void initNews(Collection<NewsEntity> news) {
        for(NewsEntity tmp : news){
            Query query = this.em.createNativeQuery("INSERT INTO newsmodel(ID, publisher, title, url, opening, content, time, category) " +
                    "VALUES (?,?,?,?,?,?,?,?)");
            query.setParameter(2, tmp.getPublisher());
            query.setParameter(3, tmp.getTitle());
            query.setParameter(4, tmp.getUrl());
            query.setParameter(5, tmp.getOpening());
            query.setParameter(6, tmp.getContent());
            query.setParameter(7, tmp.getTime());
            query.setParameter(8, tmp.getCategory());
            query.executeUpdate();
        }
    }

    @Override
    public void update(Collection<NewsEntity> news) {

    }
}
