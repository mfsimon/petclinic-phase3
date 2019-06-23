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

From the repositories package:
- `FakeDatabase`
- `BasicRepository`
- `CrudRepository`

From the model package:
- `Modifiable`

Leave all other classes.

The relationships between objects is managed in the models.  Most of the changes happen there:

* Change the type of the id field in each of your models to use a `Long`.
* Modify your models to use the proper JPA annotations.
* Use the resources listed in the `HELP.md` file as a guide.
* Implement a One-To-Many relationship between `Owner` and `Pet`.
* Implement a One-To-Many relationship between `Pet` and `Visit`.
* Implement a Many-To-Many relationship between `Visit` and `Vet`.
* Use the UML design as a guide.

The repositories need to be modified as well:

* Remove ALL the methods from each of your repositories.  You'll only have the class headers remaining.
* Change the classes to interfaces.
* Have each repository extend CrudRepository.
* Be sure to set the proper generic type for the CrudRepository.
* CrudRepository<Owner, Long> is an example.  Owner is the class you'll be accessing in the database and Long is the type of the id field.

The applications.properties file has been updated:

* Check the settings in the properties file.  There are several JPA and Hibernate settings added.  Google them to see what they do.

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
* Select `Inner Builder` and `Single Field` then select OK.
* Add a public static method called builder() just above the new inner class.  The return type for the Owner class would be OwnerBuilder.
* Use the new builder in your driver to create some new objects.

###### Bonus Activity 2 (easy) 
* Switch the database to use your MySQL instance.
* In the properties file, comment out the H2 settings.
* In the properties file, uncomment the MySQL settings.
* In the build file (pom.xml), uncomment the dependency for the MySQL driver library (mysql-connector-java).

###### Bonus Activity 2 (hard)
* This assumes you have the H2 database working.
* Implement integration tests for the `OwnerController`, `PetController`, `VisitController` and `VetController` classes.
* Uncomment each of the tests in the `OwnerController` and make sure they run.  Once they do, use them as a pattern to implement tests for the other 3 classes.
* The port for the tests is set to 9090.  Check the application.properties file in the test -> resources folder for more test settings.

#### Notes
* Dependencies have already been added for you in the pom.xml file for this phase.  You shouldn't have to modify or add anything to your build file (pom.xml), but feel free to as needed.
* We are NOT creating a front end for this application.  The `PetClinicDriver` acts as the front end (or view) for this application. Feel free to add to the driver as needed.
* In this phase, don't worry about handling errors.