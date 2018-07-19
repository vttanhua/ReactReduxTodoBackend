package hello;

import hello.configuration.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class Application {

    @Autowired
    private ApplicationConfiguration cmdbProperties;
    @PostConstruct
    public void init() {

        log.info(cmdbProperties.toString());
    }
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
