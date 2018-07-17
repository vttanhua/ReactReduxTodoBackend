package hello.repository;

import hello.entity.Article;
import hello.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findAll(Example example);
    //List<AffiliateEntity> findAll(Example example);
    Optional<Article> findById(Long id);
}
