# PetClinic Phase 3

#### Overview
In this phase of the project, we convert the code from phase 2 to use a real database.
We're going to use an in memory database to start with (H2), then switch to MySQL once your code is working with H2. 

[PetClinic Reference Application](http://petclinic.cognizantacademy.com)

#### What You Are Given

* Code for the `OwnerController` and `PetController`
* Code for the `OwnerService` and `PetService`
* Code for the `OwnerRepository` and `PetRepository`
* Models for `Owner`, `Pet` and `PetType`
* Modified driver class that works with the new models.

#### What You Need To Complete
Complete the following steps to add a real database.  

* Delete the following classes from your code completely:
- `FakeDatabase`
- `Modifiable`
- `CrudRepository`

* If you don't have them complete, continue to implement controllers, services and repositories for each of the models (`Pet`, `Visit`, `Vet`).
* Modify your models to use JPA.  Use the existing models and the data model we developed as a guide.
* Change the type of the id field in each of your models to use a `Long`.
* Modify your repositories - change the classes to interfaces and have them extend CrudRepository.  Be sure to set the proper generic type for the CrudRepository.  Use the existing repositories as a guide.
* Copy the properties from this application.properties file to yours.  There are several JPA and Hibernate settings in them.

###### Patterns Used

* MVC
* 3-Tier application
* Polymorphism (inheritance)
* Designing to interfaces
* Spring Data JPA

###### Frameworks Used
* Spring
* Spring Boot
* Spring Data JPA
* Hibernate

###### Spring Annotations Used
* @SpringBootApplication
* @Controller
* @Service
* @Entity
* @Table
* @Id
* @GeneratedValue
* @OneToMany
* @ManyToOne
* @JoinColumn


###### Bonus Activity 1 (easy)
* Add an inner builder class to each of your models.
* Use an IntelliJ plugin to accomplish this.
* Goto Preferences -> Plugins -> Marketplace and search for Builder Generator.
* Install the plugin and restart IntelliJ.
* Generate a builder by navigating to the class you want to add the builder to and navigate to Code -> Generate.
* Select Builder.
* Select Inner Builder then select OK.
* Add a public static method called builder() just above the new inner class.
* Use the Owner and Pet classes as a model to complete.
* Use the new builder in your driver to create some new objects.
* Use the existing driver code in this code example as a template.

###### Bonus Activity 2 (easy) 
* Switch the database to use your MySQL instance.
* In the properties file, comment out the H2 settings.
* In the properties file, uncomment the MySQL settings.
* In the build file (pom.xml), uncomment the dependency for the driver library (mysql-connector-java).

###### Bonus Activity 2 (hard)
* Implement integration tests for the `PetController`, `VisitController` and `VetController` classes.
* You'll have to have complete code for the visit and vet sequences.
* Use the code in `OwnerControllerIntegrationTests` as a template.

#### Notes
* Dependencies have already been added for you in the pom.xml file for this phase.  You shouldn't have to modify or add anything to your build file (pom.xml), but feel free to as needed.
* We are NOT creating a front end for this application.  The `PetClinicDriver` acts as the front end (or view) for this application. Feel free to add to the driver as needed.
* In this phase, don't worry about handling errors.