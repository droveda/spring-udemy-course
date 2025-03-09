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
