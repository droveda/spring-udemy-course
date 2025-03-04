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