package by.bsuir.spring.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import by.bsuir.spring.model.Article;

public interface IArticleDao extends JpaRepository<Article, Integer> {
    List<Article> readAllByOrderByCategoryAsc();
    @Cacheable("articleCache")
    @Query("select a from Article a where a.category = 'Spring'")
    List<Article> findAllSpringArticles();
}
