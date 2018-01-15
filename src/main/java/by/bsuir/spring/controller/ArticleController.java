package by.bsuir.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import by.bsuir.spring.dao.IArticleDao;
import by.bsuir.spring.model.Article;

@RestController
public class ArticleController {

    @Autowired
    private IArticleDao articleDao;

    @RequestMapping(value = "/articles", method = RequestMethod.GET, produces = "application/xml")
    public List<Article> article(@RequestParam(name = "sort") boolean sort) {
        if (sort) {
            return articleDao.readAllByOrderByCategoryAsc();
        } else {
            return articleDao.findAllSpringArticles();
        }
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Article> findByArticleById(@PathVariable int id) {
        Article article = articleDao.findOne(id);
        if (article != null) {
            return ResponseEntity.ok().body(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public void addArticle(@RequestBody Article article) {
        articleDao.save(article);
    }
}
