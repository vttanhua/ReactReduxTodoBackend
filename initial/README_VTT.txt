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


*****************************
*	      TODO  		    *
*						    *
*****************************
lombok
*swagger
authentication?
jpa
structure
*logging


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