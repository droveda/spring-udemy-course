# Spring Security

* Security Principles
* Authentication
* Authorization
* Spring Security Fundamentals
* Spring Security Filter Chain
* Form Authentication
* Basic Authentication
* JWT Authentication
* CSRF, CORS,...
* OAuth

## Authentication and Authorization
* Authentication, what do you remember + what you possess
  * userid/password  
  * biometrics
* Authorization (do they have the right access)
  * User ABC can read data and update data
  * User XYZ can only read data

Principles of secure systems  
* Trust Nothing
* Assign Least Privilegies
* Have complete Mediation
  * Medieval Fort's
* Have Defense in Depth
  * Multiple levels of security
* Have Economy of Mechanism
* Ensure Openness of Design

Spring Security can be difficult to get started  
* Filter Chain (Spring Security Filter Chain)
* Authentication Managers
* Authentication providers
* ...

BUT is provides a very flexible security system!  
* By default, everything is protected!
* A chain of filters ensure proper authentication and authorization

String Security Filter Chain:  
* ...
* CsrfFilter
* LogoutFilter
* DefaultLoginPageGeneratingFilter
* BasicAuthenticationFilter
* ExceptionTranslationFilter
* AuthorizationFilter

Request -> Dispatcher Servltet -> Controller(s)  
Request -> Spring Security -> Dispather Servlet -> Controller(s)  
* Spring security intercepts all requests
* Follows following security principle
  * Have complete mediation


### Default Spring Security Configuration
* Everything is authenticated
  * You can customize it further
* **Form authentication** is enabled (with default form and logout features)
* **Basic authentication** is enabled
* **Test user** is created
  * Credentials printed in log (Username is user)
* **CSRF protection** is enabled
* **CORS request** are denied
* **Z-Frame-Options** is set to 0 (Frames are disabled)
* And a lot of others...

### How does Spring Security Work?
* Spring Security executes a series of filters
  * Filter provide these features:
    * **Authentication**: Is it a valid user (Ex: BasicAuthenticationFilter)
    * **Authorization**: Does the user have right access? (Ex: AuthorizationFilter)
    * Other Features:
      * Cross-Origin Resource Sharing (CORS) - CorsFilter
        * Should you allow AJAX calls from other domains?
      * Cross Site Request Forgery (CSRF) - CsrFilter
        * A malicious website making use of previous authentication on your website
        * Default: CSRF protection enabled for update requests - POST, PUT, etc...
      * Login Page, Logout Page
        * LogoutFilter, DefaultLoginPageGeneratinFilter, DefaultLogoutPageGeneratingFilter
      * Translating exceptions into proper Http Responses (ExceptionTranslationFilter)
  * **Order of filters** is important (typical order shown below)
   1. Basic Check Filters - CORS, CSRF, ...
   2. Authentication Filters
   3. Authorization Filters 

### Form Based Authentication
* Used by most web applications
* Uses a Session Cookie JSESSIONID
* Spring Security Enables Form Based Authentication by default
* It is enabled by default
  * Provides a default Login Page
  * Provides a default Logout Page
* Provides a /logout URL

### Basic Authentication
* Most basic option for Securing REST API
  * But has many flaws
  * NOT recommended for production use
* Base 64 encoded username and password is sent as request header
  * Authorization: Basic base64(username:password)
* Unsecure
* does not contain authorization data
* does not expiry

### Cross-Site Request Forgery (CSRF)
1. You are logged-in to your bank website
   1. A cookie Cookie-A is saved in your web browser
2. You go to a malicious website without logging out
3. Malicious website executes a bank transfer without your knowledge using Cookie-A

```
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

@RestController
public class SpringSecurityController {

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
```

How can you protect from CSRF?  
* **Syncronizer token pattern**
  * A token created for each request
  * To make an update (POST, PUT, ...) you need a CSRF token from the **previous request**
    * To make a request you need to inform the CSRF token in the header 
      * Header Name = **X-CSRF-TOKEN**
  * NOTE: CSRF might not be applicable if there is no session involved, if your REST API is stateless
* SameSite cookie (Set-Cookie: SameSite=Strict)
  * application.properties
    * server.servlet.session.cookie.same-site=strict
* NOTE: If your REST API is stateless CSRF token is not applicable

```org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration```    
the class above is the default config applied it can be found if you search for SpringBootWebSecurityConfiguration using shift+shift hotkey in Intellij.  
It is inside -> **org.springframework.book:spring-boot-autoconfigure:3.4.4** for instance.  

### CORS
```
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("http://localhost:3000");
        }
    };
}
```
* Browsers do NOT allow AJAX calls to resources outside current origin
* Cross-Origin Resource Sharing (CORS): Specification that allows you to configure which cross-domain requests are allowed
  * Global configuration
    * Configure addCorsMappings callback method in WebMvcConfigurer
    * It will configure for all the Controllers
  * Local Configuration
    * Can have different settings for each Controller
    * @CrossOrigin - Allow from all origins
    * @CrossOrigin(origins = "http://localhost:3000")


### Storing User Credentials
* In Memory
* Database
* LDAP - Lightweight Directory Access Protocol
  * Open protocol for directory services and authentication


### Working with spring-security and database
* org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl  
* org/springframework/security/core/userdetails/jdbc/users.ddl

```
@Bean
public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
}


@Bean
public UserDetailsService userDetailsService(DataSource dataSource) {

    var user = User.withUsername("in28minutes")
            .password("{noop}dummy")
            .roles("USER").build();

    var admin = User.withUsername("admin")
            .password("{noop}dummy")
            .roles("ADMIN").build();


    var jdbcManager = new JdbcUserDetailsManager(dataSource);

    jdbcManager.createUser(user);
    jdbcManager.createUser(admin);

    return jdbcManager;
}
```



### Storing Passwords
NOTE: Difference between encoding, hashing and Encryption   

#### Encoding
* Transform data - one form to another
  * Does NOT use a key or password
  * Is reversible
  * Typically NOT used for securing data
  * Usecases: Compression, Streaming
  * Example: Base64, Wav, MP3

#### Hashing 
* One-wat process
* NOT reversible
* validate integrity of data, store passwords
* Hashes like SHA-256 are no longer secure
* Modern systems can perform billions of hash calculations a second
  * AND systems improve with time!
* Recommended: Use adaptive one way functions with Work factor of 1 second
  * It should take at least 1 second to verify a password on your system
  * Examples: bcrypt, scrypt, argon2, ...
* PasswordEncoder - interface for performing one way transformation of a password
  * (REMEMBER) Confusingly Named!
  * BCryptPasswordEncoder

#### Encryption
* Encoding data using a key or password
* Is reversible, you need key or password to decrypt
* Example: RSA

### Getting Started With JWT
* Open industry standard for representing claims securely between two parties
* Can Contain User Details and Autorizations
* Structure:
  * header
    * type JWT
    * Hashing Algo
  * Payload
    * iss
    * sub
    * aud
    * exp
    * iat
    * custom claims
  * Signature
    * Includes a secret

Symmetric Encryption  
Asymmetric Key Encryption  

1. Create a JWT
   1. Needs Encoding
      1. user credentials
      2. user data (payload)
      3. RSA key pair
2. Send JWT as part of request header
   1. Authorization Header
   2. Bearer Token
3. JWT is verified
   1. Needs Decoding
   2. RSA key pair (Public Key)


### JWT Authentication using Spring boot's Oauth2 Resource Server
1. Generate Key Pair
   1. Will use java.security.KeyPairGenerator
   2. You can use openssl as well
2. Create RSA Key object using Key Pair
   1. com.ninbus.jose.jwk.RSAKey
3. Create JWKSource (JSON Web Key source)
   1. Create JWKSet (a new JSON Web Key Set) with the RSA Key
   2. Create JWKSource using JWKSet
4. Use RSA Public Key for Decoding
   1. NimbusJwtDecoder.withPublicKey(rsaKey().toRSAPublicKey()).build()
5. Use JWKSource for Encoding
   1. return new NimbusJwtEncoder(jwkSource());


see file: ```com.droveda.springsecuritylab.config.JwtSecurityConfiguration```    

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```


### Understanding Spring Security Authentication
* Authentication is done as part of the Spring Security Filter Chain!
* **1 AuthenticationManager** - Responsible for authentication
  * Can interact with multiple authentication providers
  * SecurityContextHolder
    * SecurityContext
      * Authentication
      * 1. Principal -> (Details about the user)
      * 2. Credentials -> (Username and password)
      * 3. Authorities -> (What roles the principal has)
* **2 Authentication Provider** - Perform specific authentication type
  * JWTAuthenticationProvider - JWT Authentication
* **3 UserDetailsService** - Core interface to load user data
* How is authentication result stored?
  * SecurityContextHolder -> SecurityContext -> Authentication -> GrantedAuthority
    * Authentication - (After authentication) Holds user (Principal) details
    * GrantedAuthority - An authority granted to principal (roles, scopes, ...)


### Spring Security Authorization
1. Global Security: authorizeHttpRequests
   1. .requestMatchers("/users").hasRole("USER")
      1. hasRole, hasAuthority, hasAnyAuthority, isAuthenticated
2. Method Security (@EnableMethodSecurity)
   1. **@Pre** and **@Post** Annotations
      1. @PreAuthorize("hasRole('USER') and #username == authentication.name")
      2. @PostAuthorize("returnObject.username == 'in29minutes'")
   2. JSR-250 annotations
      1. @EnableMethodSecurity(jsr250Enabled=true)
      2. @RolesAllowed({"ADMIN","USER"})
   3. @Secured annotation
      1. @EnableMethodSecurity(securedEnabled=true)
      2. @Secured({"ROLE_ADMIN","ROLE_USER"})


### Oauth
* Resource owner (You - person owing the google drive files)
* Client application (Todo management application)
* Resource Server (Google Drive)
* Authorization Server (Google oauth server)

```
##Google API console
##http://localhost:8080/login/oauth2/code/google
 
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_SECRET

Dependencies: 
Spring Web
Oauth Client
```