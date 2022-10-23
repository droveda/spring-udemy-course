# Some notes from the course

## CDI (Context and Dependency Injection)

* Java EE Dependency Injection Standard (JSR-330)
* Spring Supports most annotations
    * @Inject (@Autowired)
    * @Named (@Component & @Qualifier)
    * @Singleton (Defines a scope of Singleton)
* Dependency for Java EE CDI
 ``` 
        <dependency>
            <groupId>javax.inject</groupId>
            <artifactId>javax.inject</artifactId>
            <version>1</version>
        </dependency>
  ```

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

### Application Context - 99 percent of the scenarios (it provides more features than the Bean Factory)

* Bean Factory ++
    * Spring's AOP features
    * i18n capabilities
    * WebApplicationContext for web applications etc

### Bean Factory (it is good for IOT devices because it uses less memory and CPU than Application Context)

* Basic management of the beans
* Wiring of the dependencies

### Component Annotations (Stereotypes)

* @Component - Generic Component
* @Repository - encapsulation storage, retrieval and search behaviour typically from a relational database
* @Service - Business Service Facade
* @Controller - Controller in MVC pattern

### Bean Scope

Default - singleton  
* singleton - One instance per Spring Context
* prototype - New bean whenever requested
  * @Scope("prototype")
  * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  * @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) (ver exemplo JDBCConnection.java)
* request - One bean per HTTP request
* session - One bean per HTTP session

### Component Scan
@ComponentScan - By default it will search for beans in the same package and subpackages in where the class with @SpringBootApplication annotation is
* @ComponentScan("com.droveda.componentscan") - example if you want to scan for beans in another directory

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
    * Neither an application server nor a web server
* Features
    * Quickly create spring applications
    * Embedded Servers - Tomcat, Jetty or Undertow
    * Quick Start Projects
        * Web
        * JPA
    * Production-ready features
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
