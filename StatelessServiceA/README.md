# Getting Started

This is a sample spring microservice which shows:

- Expose a restful layer  (HATEAOS , HAL style) on top of a repo
- READ environment variables ( which is populated by Kubernetes)
    - variables are coming from configmap and secrets 
    
# Install

- First ensure you have MiniKube and kubectl running
- In your terminal

    ```console
    foo@bar:~$ make k8s-all-create    
    ```
    - refere to makefile for more details

- Running inside a local docker
     ```console
     foo@bar:~$ make run-local 
     foo@bar:~$ curl localhost:8080/env 
      ```
- Retrieve service endpoint (Kubernetes cluster)
    ```console
    foo@bar:~$ make k8s-service-url   
    ``` 
- Navigate data api  (HATEAOS)
     ```console
     foo@bar:~$ curl <ENDPOINT HERE>/api 
     ```
- Show loaded variables from k8s (will show null if running locally) 
     ```console
     foo@bar:~$ curl <ENDPOINT HERE>/env 
     ```

### Guides used:

* [https://spring.io/guides/gs/accessing-data-rest/]()

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#production-ready)


The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

