## Docker
docker build -f docker/Dockerfile -t droveda/myrestapi:v01 .  
docker build -f docker/Dockerfile2 -t droveda/myrestapi:v02 .  


### Spring boot maven plugin
* mvn spring-boot:repackage (create jar or war)
* mvn spring-boot:run (Run application)
* mvn spring-boot:start (Non-blocking. Use it to run integration tests)
* mvn spring-boot:stop (Stop apps started with start command)
* mvn spring-boot:build-image (Build a container image)

```
mvn spring-boot:build-image
```