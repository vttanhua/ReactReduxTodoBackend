package hello.repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import hello.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.data.domain.Example;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findAll(Example example);
    //List<AffiliateEntity> findAll(Example example);
    Optional<User> findById(Long id);
}
