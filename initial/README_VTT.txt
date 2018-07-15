*****************************
*	      General  		    *
*						    *
*****************************

Sample is from:
https://spring.io/guides/gs/rest-service/


good generator for spring projects:
http://start.spring.io/



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