# Full Stack Architecture - FrontEnd

## Javascript
ECMASCRIPT is the standard  
JavaScript is implementation  


* Install Node.js and NPM (It will install both)
  * check the installation
  * node --version
  * node -v
  * npm -v
  * npm --versiobn


## npm
Package management for JavaScript  
Similar to MavenGrade in Java World  
* ```npm init``` (this will create a node project)
* ```package.json``` file is similar to pom.xml file
* ```npm install jquery```
* ```node_modules``` Downloaded dependencies (temp)
* ```npm install``` will download and install the dependencies


### Creating a React Project
https://create-react-app.dev/docs/getting-started/  

* React: One of the most popular JavaScript libraries to build SPA (Single Page Applications)
  * Alternatives: Angular, VueJS
* Create React App
  * NPM - Package manager - Install, delete, and update JS packages
  * NPX - Package Executer - Execute JS packages directly, without installing
    * npx -v
* Creating our first React Project
  * cd 01-front-end
    * ```npx create-react-app@latest todo-app``` (this will create my react project)
* After creating the project
  * cd todo-app
    * ```npm start```
      * This will run the app in DEV mode and you can access it on http://localhoet:3000
    * ```npm run build```
      * Build a production deployable unit
        * Minified
        * Optimized for performance
    * ```npm test```
      * Run unit tests
    * ```npm install --save react-router-dom```
      * Add a dependency to your project

### React Folder Structure
* package.json -> dependencies
* node_modules -> Folder where all the dependencies are downloaded to
* publicindexhtml -> Contains root dev
* src/index.js -> initializes React App. Loads app component
* src/App.js -> Code for App Component
  * src/App.cdd -> Styling for App component
  * src/App.test/js -> unit tests for App component


### Understanding React Components
* First component typically loaded in React Apps: **App** Component
* Parts of a Component
  * View (JSX or JavaScript)
  * Logic (JavaScript)
  * Styling (CSS)
  * State (Internal Data Store)
  * Props (Pass Data)
* (Remember) React component names must always start with a **Capital** letter


### Understanding State in React
* State: Built-in React Object used to contain data or information about the component
* (REMEMBER) In earlier versions of React. ONLY Class components can have state
  * AND implementing state was very complex!
* **Hooks were introduced in React 16.8**
  * Hooks are very easy to use
  * **useState** hook allows adding state to Function Components
    * **useState** returns two things
      * 1: Current State
      * 2: A fucntion to update state
  * Each instance of component has it's own state
  * How to share state between components?
    * Move state "upwards" (to a parent component)


### Exploring React Props
* You can pass "props" (short for properties) object to a React Component
* Used for things that remain a constant during lifetime of a component
  * Example increment value of a specifc component
  

### React Developer Tools - Chrome Extension
very useful tool to see the react components and state and for debugging  


## Routing in React
* npm install react-router-dom

```
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from 'react-router-dom';

export default function TodoApp() {
    return (
        <div className="TodoApp">

            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route path="/welcome" element={<WelcomoeComponent />} />
                </Routes>
            </BrowserRouter>
        </div>
    )
}


const navigate = useNavigate()
navigate('/welcome')


<p>
    Your todos - <Link to='/todos'>Go Here</Link>
</p>


```

## Adding bootstrap
* npm install bootstrap
* index.js add
  * import 'bootstrap/dist/css/bootstrap.min.css'


## Sharing React State with multiple components using AuthContext

Example -> AuthContext.js file  
```
import { createContext, useState } from "react";

export const AuthContext = createContext();


//Share the created context with other components

export default function AuthProvider({ children }) {

    //Put some state in the context
    const [number, setNumver] = useState(10)

    return (
        <AuthContext.Provider value={{ number }}>
           {children}
        </AuthContext.Provider>
    );
}
```

## Calling Rest APIs
//axios  
npm install axios  

* Enabling CORS on spring-boot app
```
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("http://localhost:3000");

        }
    };
}
```

## Install the following libraries
* npm install formik
* npm install moment


## Working With JWT

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
</dependency>
```

POST http://localhost:8080/authenticate  
body: {"username": "Mike", "password": "dummy"}  
you will get the token as response 
add header "Authorization": "Bearer {the-token}"  

```
classes see:
src/main/java/com/droveda/myrestapi/config/JwtSecurityConfig.java
src/main/java/com/droveda/myrestapi/controller/JwtAuthenticationController.java
src/main/java/com/droveda/myrestapi/service/JwtTokenService.java
```