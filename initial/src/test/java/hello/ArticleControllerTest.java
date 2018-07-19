package hello;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import hello.configuration.ApplicationConfiguration;
import hello.entity.Article;
import hello.controller.ArticleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleControllerTest {

    @Autowired
    ApplicationConfiguration applicationConfiguration;

    private String baseUrl = null;

    @PostConstruct
   public void ArticleControllerTestInit(){
       this.baseUrl = applicationConfiguration.getBaseURL();
   }
/*
    @Test
    public void phase1_createArticle(){
        log.info("Phase 1: create article.");
        RestTemplate restTemplate = new RestTemplate();
        Article testArticle = new Article("Test title!");
        String url = this.baseUrl+"api/article";
        log.info("Url is: {}", url);
        URI createdArticleURI = restTemplate.postForLocation(url, testArticle, Article.class);
    }

    @Test
    public void phase2_updateArticle(){
        log.info("Phase 2: update article.");
        RestTemplate restTemplate = new RestTemplate();
        Article a = new Article("Updated title");
        a.setId(1L);
        String url = this.baseUrl+"api/article/1";
        restTemplate.put(url, a);
    }

    @Test
    public void phase3_createArticle(){
        log.info("Phase 3: create article.");
        RestTemplate restTemplate = new RestTemplate();
        Article testArticle = new Article("Test title!");
        String url = this.baseUrl+"api/article";
        log.info("Url is: {}", url);
        URI createdArticleURI = restTemplate.postForLocation(url, testArticle, Article.class);
        log.info("Url for created resource is: {}", createdArticleURI);
   }

    @Test
    public void phase4_listArticles(){
        log.info("Phase 4: list articles.");
        RestTemplate restTemplate = new RestTemplate();
        String url = this.baseUrl+"api/article";
        List<Article> articles = restTemplate.getForObject(url,List.class);
        for (Article a:articles
             ) {
            log.info("Article {}",a.toString());

        }
    }

    @Test
    public void phase5_getArticle(){
        log.info("Phase 5: get articles.");
        String url = this.baseUrl+"api/article/1";
        RestTemplate restTemplate = new RestTemplate();
        Article a = restTemplate.getForObject(url, Article.class);
        log.info("Artice is {}",a);
    }

    @Test
    public void phase6_deleteArticle(){
        log.info("Phase 6: delete article.");
        String url = this.baseUrl+"api/article/1";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }
*/


    @Test
    public void phase7_getNonExistingArticle(){
        log.info("Phase 7: get non existing article.");
        String url = this.baseUrl+"api/article/1";
    }
}
