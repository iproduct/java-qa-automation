package course.qa.simple.web;

import course.qa.simple.dao.ArticleRepository;
import course.qa.simple.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private static final List<Article> SAMPLE_ARTICLES = List.of(
          new Article("1", "Itroduction to Spring", "Spring is a major Web API development platform ..."),
          new Article("2", "Itroduction to Hibernate", "Hibernate enables ORM persistence ..."),
          new Article("3", "Lombok", "Pros and cons of Lombok ...")
    );

    @Autowired
    private ArticleRepository articleRepo;

    @GetMapping
    public List<Article> getArticles() {
        return articleRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article created = articleRepo.insert(article);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}")
                        .buildAndExpand(created.getId()).toUri())
                    .body(created);
    }



}
