package course.qa.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.qa.simple.dao.ArticleRepository;
import course.qa.simple.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class SimpleApiApplicationTests {
    @MockBean
    private ArticleRepository mockArticleRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void givenArticles_whenGetArticles_thenStatus200JsonArray() throws Exception {
        // setup
        given(mockArticleRepository.findAll()).willReturn(SAMPLE_ARTICLES);

        // execute
        mockMvc.perform(get("/api/articles").accept(APPLICATION_JSON))
                .andExpect(status().isOk()) // verify
                .andExpect(content().contentType(APPLICATION_JSON))
                .andDo(result -> log.info(result.getResponse().getContentAsString()))
                .andExpect(jsonPath("$.length()").value(SAMPLE_ARTICLES.size()))
                .andExpect(jsonPath("$[0].title").value(SAMPLE_ARTICLES.get(0).getTitle()))
                .andExpect(jsonPath("$[1].title").value(SAMPLE_ARTICLES.get(1).getTitle()))
                .andExpect(jsonPath("$[2].title").value(SAMPLE_ARTICLES.get(2).getTitle()));

        then(mockArticleRepository).should(times(1)).findAll();
        then(mockArticleRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void givenNewArticle_whenPostArticle_thenStatus201JsonObject() throws Exception {
        // setup
        given(mockArticleRepository.insert(any(Article.class))).willReturn(RESULT_ARTICLE);

        // execute
        mockMvc.perform(post("/api/articles")
                        .contentType(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(NEW_ARTICLE))
                        .accept(APPLICATION_JSON))
                .andExpect(status().isCreated()) // verify
                .andExpect(header().string("location",
                        containsString("/api/articles/" + RESULT_ARTICLE.getId())))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andDo(result -> log.info(result.getResponse().getContentAsString()))
                .andExpect(jsonPath("$.id").value(RESULT_ARTICLE.getId()))
                .andExpect(jsonPath("$.title").value(RESULT_ARTICLE.getTitle()))
                .andExpect(jsonPath("$.content").value(RESULT_ARTICLE.getContent()));

        then(mockArticleRepository).should(times(1)).insert(any(Article.class));
        then(mockArticleRepository).shouldHaveNoMoreInteractions();
    }

    private static final Article NEW_ARTICLE =
            new Article(null, "New Article", "New article content ...");
    private static final Article RESULT_ARTICLE =
            new Article("620547983857936bb34b9a3a", "New Article", "New article content ...");


    private static final List<Article> SAMPLE_ARTICLES = List.of(
            new Article("620547983857936bb34b9a3d", "Itroduction to Spring", "Spring is a major Web API development platform ..."),
            new Article("620547be3857936bb34b9a3e", "Itroduction to Hibernate", "Hibernate enables ORM persistence ..."),
            new Article("620547f73857936bb34b9a3f", "Lombok", "Pros and cons of Lombok ...")
    );
}
