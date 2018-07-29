*****************************
*	      General  		    *
*						    *
*****************************

Sample is from:
https://spring.io/guides/gs/rest-service/


good generator for spring projects:
http://start.spring.io/

spring-boot applicaatio intelliJ:ssä
add as maven project in project context menu
file ->settigns ->imports ... automatic import of dep when pom changed.

Using different profiles
Rename prop files like application-{profile}.properties
use commands to specify profile:
mvn clean package -Dspring.profiles.active=test
mvn spring-boot:run -Dspring.profiles.active=production


maven pakettien etsintätyökalu:
https://mvnrepository.com/artifact/org.springframework.security/spring-security-web/5.0.6.RELEASE

spring luokat
https://www.javatips.net/api/spring-framework-master/spring-webflux/src/main/java/org/springframework/web/reactive/config/WebFluxConfigurer.java

*****************************
*	      TODO  		    *
*						    *
*****************************
-lombok
*swagger
authentication?
-jpa
-structure
*logging
transaction tag

*****************************
*	      SIGN-UP           *
*          LOGIN   		    *
*   	   USAGE		    *
*****************************
Excellent tutorial:
https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

Setting custom login url

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/your/login/url"));
    }

sign-up:
POST http://localhost:8090/api/user/sign-up HTTP/1.1
User-Agent: Fiddler
Host: localhost:8090
content-type: application/json
Content-Length: 59

{
    "userName": "admin2",
    "password": "password"
}

login:
POST http://localhost:8090/login HTTP/1.1
User-Agent: Fiddler
Host: localhost:8090
content-type: application/json
Content-Length: 59

{
    "username": "admin2",
    "password": "password"
}

GET http://localhost:8090/api/article/ HTTP/1.1
User-Agent: Fiddler
Host: localhost:8090
content-type: application/json
Content-Length: 59
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjIiLCJleHAiOjE1MzM2NDI4MTB9.np_-pAD2yCIl_tv7vpgELdKkAncDmbWlbbUWW2ITGJzXoq8bkYXJhfWXn6Ti9QKLoIPZQ3ggYIHD9h-QCquV1g


*****************************
*	      CORS   		    *
*						    *
*****************************
vanha tapa tällä sain toimimaan
https://spring.io/guides/gs/rest-service-cors/
tämä ei kaipaa kummepia dependencyjä!
tarvitaan myös lupa lukea http headereita
sample löytyy täältä:
https://www.concretepage.com/spring-4/spring-4-rest-cors-integration-using-crossorigin-annotation-xml-filter-example
tarvitaan myös expose headers, jotta voi käsitellä luodun objektin location headerissa tulevaa id:tä
https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS#Access-Control-Expose-Headers
deletelle tarvitaan options metodin määrittely joka palauttaa AccessControlAllowOrigin headerin:
https://stackoverflow.com/questions/29954037/why-is-an-options-request-sent-and-can-i-disable-it

ehkä crossorigin annotaatiolla tämä homma hoituisi suoraan!


uusi tapa olisi
https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-cors
mutta en saanut toimimaan
*****************************
*	   REST service         *
*						    *
*****************************
https://spring.io/guides/gs/rest-service/

Samples for error handling and using ResponseEntity
http://websystique.com/spring-boot/spring-boot-rest-api-example/

good article reference (swagger client, security)
http://www.baeldung.com/rest-with-spring-series/


calling article service:
content-type: application/json
{"id":1,"title":"Eka artikkeli","createdAt":"2018-07-16T18:40:17.449+0000","modifiedAt":"2018-07-16T18:40:17.449+0000"}
*****************************
*	    JPA+Hiberbnate      *
*		Spring JPA		    *
*****************************
http://hibernate.org/
https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html
https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/

spring+hibernate+jpa+postgresql conffauksesta sample täältä:
https://www.callicoder.com/spring-boot-jpa-hibernate-postgresql-restful-crud-api-example/

Possibility to save entity history(and search from there)
http://docs.jboss.org/hibernate/orm/5.3/quickstart/html_single/#tutorial_envers

https://docs.spring.io/spring-data/jpa/docs/1.5.0.RC1/reference/html/jpa.repositories.html
*****************************
*	      Swagger  		    *
*						    *
*****************************
swagger ja applicationin security ei toimi samaan aikaan
jos haluaa katsoa swaggeria niin
public WebMvcConfigurer corsConfigurer() pitää kommentoida pois

Swagger home: https://swagger.io/
Good concrete sample:
http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
Then swagger documentation is available at url:
http://localhost:8080/your-app-root/swagger-ui.html
http://localhost:8080/swagger-ui.html
http://localhost:8080/swagger-ui.html#!/greeting45controller/greetingUsingGET

other urls
http://localhost:8080//v2/api-docs
Mapped "{[/swagger-resources/configuration/security]}"
Mapped "{[/swagger-resources/configuration/ui]}"
Mapped "{[/swagger-resources]}"


Swagger client creation:
http://www.baeldung.com/spring-boot-rest-client-swagger-codegen
*****************************
*	      Logging  		    *
*						    *
*****************************
Added logging according to SLF4J:
https://www.slf4j.org/docs.html

Implementation is apache commons logging:
http://commons.apache.org/proper/commons-logging/guide.html

it can use logback style configuration:
https://logback.qos.ch/manual/configuration.html
See implementations for setting level and file logging

lombock project used to get logger by annotation

*****************************
*	      Git tags 		    *
*						    *
*****************************
initial_tutorial_implemented


*****************************
*	  Other libs     	    *
*		and tools		    *
*****************************
https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
import java.util.concurrent.TimeUnit;
 TimeUnit.SECONDS.sleep(1);

 https://github.com/junit-team/junit4/wiki/matchers-and-assertthat
 https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html
 https://examples.javacodegeeks.com/core-java/junit/junit-assertthat-example/

 -configuration and profiles setup
 http://www.baeldung.com/configuration-properties-in-spring-boot
 http://www.springboottutorial.com/spring-boot-profiles


 *****************************
 *	       Tips        	    *
 *		        		    *
 *****************************

 6.3. Client Error
 In case of a client error, custom exceptions are defined and mapped to the appropriate error
 codes. Simply throwing these exceptions from any of the layers of the web tier will ensure
 Spring maps the corresponding status code on the HTTP response.
 @ResponseStatus( value = HttpStatus.BAD_REQUEST )
 public class BadRequestException extends RuntimeException{
 //
 }
 @ResponseStatus( value = HttpStatus.NOT_FOUND )
 public class ResourceNotFoundException extends RuntimeException{
 //
 }