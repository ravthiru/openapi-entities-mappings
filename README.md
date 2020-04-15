# Mapping Open API generated ( REST Entities ) to Persistence entities

What is it?
-----------

The `openapi-entities-mappings`, provides REST end-point for 
managing fictitious Petstore. This app is to demonstate how to 
generate API Model object from API Spec. And also use Mapstruct 
to map JPA entities to API Model.


System Requirements
-------------------

All you need to build this project 

* Java 11 (Java SDK 1.11).
*  Maven 3.3.8 or later.
*  Docker and Docker-Compose

Build and Run the app
----------------------

1. Open a terminal and navigate to the home directory of this app.

2. Build application
   ```
    mvn clean install
    ```
  @generate-resources phase maven genrates API Model using openapi-generator-maven-plugin
  and during @compile phase mapstuct generate mapping files using mapstruct-processor
  
   
2. Build docker image and run the application 

   ```
   docker-compose up --build

   ```
3. Check App is up and running
   
   ```
   docker ps
   ```   
   
4. Create Pet using 
   
   ```
     POST http://localhost:8080/pets 
     {
       "name": "prince",
       "tag": "dog"
      }
   
   ```
5. Get Pet using
 
   ```
   GET http://localhost:8080/pets/1
   
   ```
