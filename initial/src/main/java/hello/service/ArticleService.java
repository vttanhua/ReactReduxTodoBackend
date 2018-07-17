package hello.service;

import hello.entity.Article;
import hello.repository.ArticleRepository;
import hello.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class ArticleService {

    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article findById(Long id){
        return this.articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(format("Article not found with id %s", id)));
    }

    public Article createOrUpdate(Article article){
        return this.articleRepository.save(article);
    }

    public List<Article> findAll(){
        return this.articleRepository.findAll();
    }

    public Article getByExample(Example<Article> article){
        return this.articleRepository.findOne(article).orElseThrow(() -> new IllegalArgumentException(format("Article not found with Example %s", article)));
    }

    public boolean isExists(Article article){
        boolean isExisting = false;
        try {
            Article a = this.findById(article.getId());
            if(a != null)
                isExisting = true;
            ///TODO maybe checking with title etc
            return isExisting;
        }catch(IllegalArgumentException ie){
            //just cathc the thrown error and do nothing
        }
        return isExisting;

    }

    public void delete(Long id){
        this.articleRepository.deleteById(id);
    }

    public void deleteAll(){
        this.articleRepository.deleteAll();
    }





}
