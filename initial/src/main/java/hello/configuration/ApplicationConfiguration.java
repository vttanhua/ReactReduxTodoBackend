package hello.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.xml.soap.SAAJResult;

/***
 * Access properties set in application properties
 */
@Configuration
@ConfigurationProperties(prefix = "rest")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    public String getBaseURL(){
        return env.getProperty("rest.baseurl");
    }


}
