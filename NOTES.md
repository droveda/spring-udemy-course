# Some notes from the course

## CDI (Context and Dependency Injection)

* Java EE Dependency Injection Standard (JSR-330)
* Spring Supports most annotations
    * @Inject (@Autowired)
    * @Named (@Component & @Qualifier)
    * @Singleton (Defines a scope of Singleton)

## IOC (Inversion of Control) - IOC Container

* The control of creating a dependency is delegated to Spring, instead of creating it  
  on the same class that needs the dependency
* IoC is implemented and the act of connecting objects with other objects or injecting objects into objects is done by the
  container rather than by the object themselves.
* This helps on having a loosely coupled code
* Instead of
  ```
    @RestController
    public class WelcomeController {
      private WelcomeService service = new WelcomeService();
    }
  ```
* We use this way
  ```
    @Service
    public class WelcomeService {
    }
  
    @RestController
    public class WelcomeController {
      @Autowired
      private WelcomeService service;
    }
  ```

### Application Context - 99 percent of the scenarios

* Bean Factory ++
    * Spring's AOP features
    * i18n capabilities
    * WebApplicationContext for web applications etc

### Bean Factory

* Basic management of the beans
* Wiring of the dependencies

### Component Annotations

* @Component - Generic Component
* @Repository - encapsulation storage, retrieval and search behaviour typically from a relational database
* @Service - Business Service Facade
* @Controller - Controller in MVC pattern

## Spring Boot

* Gloals
    * Enable building production ready applications quickly
    * Provide common non-functional features
        * embedded servers
        * metrics
        * health checks
        * externalized configuration
* What spring boot is not
    * Zero code generation
    * Neither am application server nor a web server
* Features
    * Quickly create spring applications
    * Embedded Servers - Tomcat, Jetty or Undertow
    * Quick Start Projects
        * Web
        * JPA
    * Production-=ready features
        * metrics and health checks
        * externalized configuration


### Difference Between Spring Framework VS Spring MVC vs Spring Boot
* Spring Framework
  * Most important feature of Spring Framework is Dependency Injection. At the code of all Spring Modules is Dependency Injection or IOC Inversion of Control
  * Resolves Duplication / Plumbing code
  * Providing good integration with other Frameworks
* Spring MVC
  * Provides decoupled way of developing web applications. With simple like Dispatcher Servlet, ModelAndView and View Resolver, it makes it easy to develop web applications.
* Spring Boot
  * One of the main advantages of Spring-boot is auto configuration. With SB we can quickly run a WebApplication with minimum effort and configuration.
  * Usage of starters
  * Monitoring feratures - actuator
  * Logging
  * etc...


### Spring AOP (Aspect Oriented Programming)
* Used to intercept any call to the beans
* spring-aop and aspectj


## Simple WebApp
* mvn tomcat7:run
