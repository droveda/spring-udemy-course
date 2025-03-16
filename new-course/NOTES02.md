# Understanding Spring Boot vs Spring MVC vc Spring

* Spring Framework
  * Dependency INjection
  * @Component, @Autowired, ComponentScan, etc...
  * Just Dependency Injection is NOT sufficient (You need other frameworks to build apps)
    * Spring Modules and Spring Projects: Extend Spring Eco System
      * Provide good integration with other frameworks (Hibernate/JPA, JUnit & Mockito for Unit Testing)
* Spring MVC (Spring Module): Simplify bulding web apps and REST API
  * Bulding web applications with struts was very complex
  * @Controller, @ResrController, @RequestMapping(/courses)
* Spring Boot (Spring Project): Build PRODUCTION-READ apps QUICKLY
  * Starter projects
  * Auto Configuration
  * Enable non functional requirements
    * Actuator
    * Embedded Server
    * Logging and Error Handling
    * Profiles and ConfigurationProperties


## Peek into History - Web Application Development
1. All CODE in Views (JSPs, ...)
   1. view loging
   2. flow logic
   3. queries to databases
   4. Disavantages
      1. view complex
      2. Zero separation of concenrs
      3. difficul to maintain
2. Model, View, Controller (MVC)
   1. Advantage: Simpler to maintain
   2. Concern: 
3. Front Controller
   1. All the requests go through just one Controller, and then forward it to another controller and after the view
   2. Common features can be implemented in the Front Controller
4. Spring MVC Front Controller - Dispatcher Servlet
   1. A: Receives HTTP request
   2. B: Process HTTP Request
      1. B1: Indentifies correct Controller method
         1. based on request URL
      2. B2: Executes Controller method
         1. Returns Model and View Name
      3. B3: Identifies correct View
         1. Using View Resolver
      4. B4: Executes View
   3. C: Returns HTTP Response


## Request vs Model vs Session


Spring Boot 3.2.x and greater    
``` 
<dependency>
     <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
</dependency>
jakarta.servlet.jsp.jstl replaces glassfish-jstl
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
```



Spring Boot 3.1.X and lower  
```
<dependency>
     <groupId>org.eclipse.jetty</groupId>
     <artifactId>glassfish-jstl</artifactId>
</dependency>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```


```

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

```

### REST API ociumentation - Seagger and Open API
* 2011 - Swagger Specification and Swagger Tools were introduced
* 2016 - Open API Specification created based on Swagger Spec.
  * Seagger Tools (ex: Swagger UI) continue to exist
* **OpenAPI Specification**: Standard, language-agnostic interface
  * Discover and understand REST API
  * Earlier called Swagger Specification
* **Swagger UI**: Visualize and interact with your REST API
* ```springdoc-openapi``` java library helps to automate the generation of API documentation for spring boot projects. 

```
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	<version>2.7.0</version>
</dependency>
```

http://localhost:8080/swagger-ui/index.html  


### Content Negotiation
* Same Resource - Same URI
  * however Different Representations are possible
    * Example: Different Content Type - XML or JSON
    * Example: Different Language - English or Dutch or
* How can a consumer tell the REST API Provider what they want?
  * Content Negotiation
* Example: Accept header (MIME types - application/xml, application/json)
* Example: Accept-Language header (en, nl, fr, etc...)

```
   <dependency>
      <groupId>com.fasterxml.jackson.dataformat</groupId>
      <artifactId>jackson-dataformat-xml</artifactId>
   </dependency>
```

### Internationalization - i18n
* Typically HTTP Request Header - **Accept-Language** is used
* Accept-Language - en, nl, fr


### Versioning Rest Apis 
1. URI versioning -> /v1/person, /v2/person - Twitter
2. Request Param -> ?version=v1 - Amazon
3. Custom headers versioning - Microsoft
   1. SAME-URL headers=[X-API-VERSION=1]
   2. SAME-URL headers=[X-API-VERSION=2]
4. Media Type Versioning - Github
   1. SAME-URL produces=application/vnd.company.app-v1+json
   2. SAME-URL produces=application/vnd.company.app-v2+json


* Factors to consider
  * URI Pollution
  * Misuse of HTTP Headers
  * Caching
  * Can we execute the request on the browser?
  * API documentation
  * Summary: No perfect Solution


## HATEOAS
Hypermedia as the Engine of Application State (HATEOAS)  

## Customizing REST API Responses - Filtering and more
1. Customize field names in response
   * @JsonProperty
2. Return only selected fields
   1. Filtering
   2. Example: Filter out passwords
   3. Two types
      1. **Static filtering**: Same filtering for a bean across different REST API
         1. @JsonIgnoreProperties (this is defined in the class level), @JsonIgnore (this is declared in the property)
      2. **Dynamic filtering**: Customize filtering for a bean for specific REST API
         1. @JsonFilter with FilterProvider



## Spring boot Actuator
* Spring boot start actuator: Starter to add Spring boot actuator to your application
  * spring-boot-starter-actuator
* Provides a number of endpoints
  * beans - complete list of spring beans in your app
  * health - Application health information
  * metrics - Application metrics
  * mappings - Details around Request Mappings
  * and a lot more...


## Mysql With docker
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle  

#### Mysql Commands
mysqlsh  
\connect social-media-user@localhost:3306  
\sql  
use social-media-database  
select * from user_details;  
select * from post;  
\quit  


```
<!-- Use this for Spring Boot 3.1 and higher -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency> 

<!-- Use this if you are using Spring Boot 3.0 or lower
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency> 
-->

don't forget to comment the h2 driver
```

```
application.properties

#spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/social-media-database
spring.datasource.username=social-media-user
spring.datasource.password=dummypassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```


```
Use mysql-connector-j instead of mysql-connector-java if you are using Spring Boot 3.1 or greater.
Remember: groupId is a little different (com.mysql instead of mysql)

<!-- Use this for Spring Boot 3.1 and higher -->
<dependency>
	<groupId>com.mysql</groupId>
	<artifactId>mysql-connector-j</artifactId>
</dependency> 
 
<!-- Use this if you are using Spring Boot 3.0 or lower
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	</dependency> 
-->

don't forget to comment the h2 driver
```


## Spring Security
* Filter Chains
  * All requests should be authenticated
  * If a request is not authenticated, a web page is shown with a login form (but we do not want it for rest apis, we want basic auth)
  * CSRF -> POST, PUT