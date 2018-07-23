package hello;

import hello.configuration.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedHeaders("*").exposedHeaders("Location");
            }
        };
    }
}
