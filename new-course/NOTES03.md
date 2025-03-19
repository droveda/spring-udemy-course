# Learning Spring AOP with Spring-boot

* What is AOP
  * A layered approach is typcally used to build applications
    * web layer
    * business layer
    * Data layer
* Each layer has differente responsibilites
  * howerver there are a few common aspacts that apply yo all layers
    * Security
    * Performance
    * Logging
  * There common aspects are called Cross Cutting Concerns
  * Aspect Oriented Programming can be used to implement Cross Cutting Concerns
* Two Popular AOP Framnworks
  * Spring AOP
    * Not a complete AOP Solutions BUT very popular
    * Only works with Spring Beans
    * Example: Intercept method calls to Spring Beans
  * AspectJ
    * Complete AOP solution BUT rarely used
    * Example: Intercept any method call on any Java Class
    * Example: Intercept change of values in a field

see project **aop-demo**  
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```


### AOP Terminology
* Compile Time
  * **Advice** - What code to execute
    * Example: Logging, Authentication
  * **Pointcut** - Expression that identifies method calls to be intercepted
    * Example: execution(* com.droveda.aop_demo.service.*.*.*(..))
  * **Aspect** - A combination of
    * 1. Advice - what to do AND
    * 2. Pointcut - when to intercept a method call
  * **Weaver** - Weaver is the framework that implememnts AOP
    * AspectJ or Spring AOP
* Runtime
  * **Join Point** - When pointcut is true, the advice is executed. A specific execution instance of an advice is called a Join Point.

### AOP Important Annotations
* @Before - Do something before a method is called
* @After - Do something after a method is executed irrespective of whether:
  * 1. Method executes successfully OR
  * 2. Method throws an exception
* @AfterReturning - Do something ONLY when a method executes successfully
* @AfterThrowing - Do something ONLY when a method throws an exception


## Docker
docker build -f docker/Dockerfile -t droveda/myrestapi:v01 .  
docker build -f docker/Dockerfile2 -t droveda/myrestapi:v02 .  