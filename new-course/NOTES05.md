# Spring Security

## Authentication and Authorization
* Authentication, what do you remember + what you possess
  * userid/password  
  * biometrics
* Ahtorinzation (do they have the right access)
  * User ABC can read data and update data
  * User XYZ can only read data

Principles of secure systems  
* Trust Nothibng
* Assign Least Privilegies
* Have complete Mediation
  * Medieval Fort's
* Have Defense in Depth
  * Multiple levels of security
* Have Economy of Mechanism
* Ensure Openness of Design

Spring Security can be difficult to get started  
* Filter Chain
* Authentication Managers
* Authentication providers
* ...

BUT is provides a very flexible security system!  
* By default, everything is protected!
* A chain of filters ensure proper authentication and authorization

Request -> Dispatcher Servltet -> Controller(s)  
Reques -> Spring Security -> Dispather Servlet -> Controller(s)  
* Spring security intercepts all requests
* Follows following security principle
  * Have complete mediation


### Default Spring Security Configuration
* Everything is autehticated
  * You can customize it further
* **Form authentication** is enabled (with default form and logout features)
* **Basic authentication** is enabled
* **Test user** is created
  * Credentials printed in log (Username is user)
* **CSRF protection** is enabled
* **CORS request** are denied
* **Z-Frame-Options** is set to 0 (Frames are disabled)
* And a lot of others...

### Form Based Authentication
* Used by most web applications
* Uses a Session Cookie JSESSIONID
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

How can you protect from CSRF?  
* Syncronizer token pattern
  * A token created for each request
  * To make an update (POST, PUT, ...) you need a CSRF token from the previous request
    * To make a request you need to inform the CSRF token in the header - X-CSRF-TOKEN
* SameSite cookie (Set-Cookie: SameSite=Strict)
  * application.properties
    * server.servlet.session.cookie.same-site=strict
* NOTE: If your REST API is stateless CSRF token is not applicable

org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration  
the class above is the default config applied by default  

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
  * Local Configuration
    * @CrossOrigin - Allow from all origins
    * @CrossOrigin(origins = "http://localhost:3000")


### Storing User Credentials
* In Memory
* Database
* LDAP - Lightweight Directory Access Protocol
  * Open protocol for directory services and authentication