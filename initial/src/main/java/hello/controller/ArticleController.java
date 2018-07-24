package hello.controller;


import hello.entity.Article;
import hello.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class ArticleController {

    ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @RequestMapping(value="/article", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> listAllArticles(){
        log.info("Listing all articles.");
        List<Article> articles = articleService.findAll();
        if(articles.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getArticle(@PathVariable("id") long id){
        log.info("Getting article with id: {}", id);
        Article article = null;
        try {
            article = articleService.findById(id);///TODO existence check enough?
        }catch(IllegalArgumentException iae) {
            log.error("Article with id {} not found. ", id);
            return new ResponseEntity(new Exception("Article with id " + id + " not found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

    @RequestMapping(value="/article", method = RequestMethod.POST)
    public ResponseEntity<?> createArticle(@RequestBody Article article, UriComponentsBuilder ucBuilder){
        log.info("Creating article: {}", article);
        if(!(article.getId()==null) && articleService.isExists(article)) {///TODO should id just be set to null
            log.error("Unable to create article {} already exists", article);
            return new ResponseEntity(new Exception("Unable to create article " + article + " already exists"), HttpStatus.CONFLICT);
        }
        Article newArticle = articleService.createOrUpdate(article);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/api/article/{id}").buildAndExpand(article.getId()).toUri());
        return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateArticle(@PathVariable("id") long id, @RequestBody Article article){
        log.info("Updating Article with {}",id);
        Article currentArticle = null;
        try {
            currentArticle = articleService.findById(id);
        }catch( IllegalArgumentException iae){
            log.error("Article with id {} not found",id);
            return new ResponseEntity(new Exception("Article with id "+id + " not found!"), HttpStatus.NOT_FOUND);
        }
        currentArticle.copy(article);
        this.articleService.createOrUpdate(currentArticle);
        return new ResponseEntity<Article>(currentArticle, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> optionsArticle(@PathVariable("id") long id){
        log.warn("Options request for article id: "+id+"****************************************");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccessControlAllowOrigin("*");
        httpHeaders.set("testHeader","testValue");
        return new ResponseEntity<String>(httpHeaders, HttpStatus.OK);

    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Article> deleteAllUsers(@PathVariable("id") long id){
        log.info("Deleting article with id {}", id);
        Article article = null;
        try {
            article = articleService.findById(id);
        }catch(IllegalArgumentException iae){
            return new ResponseEntity(new Exception("Could not delete. Article with id "+id+" doesn't exist."), HttpStatus.NOT_FOUND);
        }
        articleService.delete(id);
        return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);///TODO Could return deleted id
    }

    @RequestMapping(value = "/article", method = RequestMethod.DELETE )
    public ResponseEntity<Article> deleteAllUsers(){
        log.info("Deleting all articles");
        articleService.deleteAll();
        return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);///TODO Could return deleted ids
    }
}
