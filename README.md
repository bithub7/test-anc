# test-anc

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 4](https://maven.apache.org)


## Running the application locally

In order to run this application on your local machine, you just need to execute the "main" method in the `com.linkshortener.LinkShortenerApplication` class from your IDE. 

## Postman use

In order to use the application in postman you need:

* Run application in 
* Add header for simple authorization. For example: 
```shell
Authorization : Basic dXNlcjpyb290
```
* Make a POST request for localhost with any link. For example:
```shell
POST : localhost:8080/api/v1/?url=https://docs.google.com/document/d/12ENUq_DSzDJSdZO_HCcrL6XYMDCO7E8fD40ULTtVrQA/edit
```
* After that, the service will return you an abbreviated representation of the link you passed. You need to make a GET request for this link. For example:
```shell
GET : localhost:8080/ln85w1
```
* After that, the service will redirect you to the link that you shortened. 