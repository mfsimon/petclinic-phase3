package com.example.petclinic;

import com.example.petclinic.controller.OwnerController;
import com.example.petclinic.controller.PetController;
import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;

/*
Entry Point
 */
@SpringBootApplication
public class PetClinicDriver {

    private static ConfigurableApplicationContext context;

    private static OwnerController ownerController;
    private static PetController petController;

    public static void main(String[] args) {

        // We'll need a reference to the Spring IoC container (it's context).
        context = SpringApplication.run(PetClinicDriver.class, args);

        testApp();

    }

    private static void testApp() {

        // Need a reference to the OwnerController to run our tests.
        // We use the context to retrieve managed beans by name.
        // The name of the bean is the type of bean (it's name) in camelcase, with the first letter lowercase (by default).
        ownerController = (OwnerController) context.getBean("ownerController");
        petController = (PetController) context.getBean("petController");

        // Owner testing - use of builder pattern
        // Builder pattern forces the use of aggregation pattern over composition pattern in Java
        Owner owner1 = Owner.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner2 = Owner.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner3 = Owner.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner4 = Owner.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        ownerController.saveOwner(owner1);
        ownerController.saveOwner(owner2);
        ownerController.saveOwner(owner3);
        ownerController.saveOwner(owner4);

        List<Owner> owners = ownerController.getAllOwners();

        display(owners);

        // Pets for Homer
        Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).withOwner(owner1).build();
        Pet pet2 = Pet.builder().withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).withOwner(owner1).build();
        Pet pet3 = Pet.builder().withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).withOwner(owner1).build();
        Pet pet4 = Pet.builder().withName("Plopper").withBirthDate(new Date()).withPetType(PetType.PIG).withOwner(owner1).build();

        // Pets for Marge
        Pet pet5 = Pet.builder().withName("Greyhound").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner2).build();

        // Pets for Bart
        Pet pet6 = Pet.builder().withName("Laddie").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner3).build();
        Pet pet7 = Pet.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner3).build();
        Pet pet8 = Pet.builder().withName("Stampy").withBirthDate(new Date()).withPetType(PetType.ELEPHANT).withOwner(owner3).build();
        Pet pet9 = Pet.builder().withName("Duncan").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwner(owner3).build();


        // Pets for Lisa
        Pet pet10 = Pet.builder().withName("Nibbles").withBirthDate(new Date()).withPetType(PetType.HAMPSTER).withOwner(owner4).build();
        Pet pet11 = Pet.builder().withName("Chirpy Boy").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwner(owner4).build();
        Pet pet12 = Pet.builder().withName("Bart Junior").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwner(owner4).build();
        Pet pet13 = Pet.builder().withName("Snowball IV").withBirthDate(new Date()).withPetType(PetType.CAT).withOwner(owner4).build();
        Pet pet14 = Pet.builder().withName("Princess").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwner(owner4).build();

        petController.savePet(pet1);
        petController.savePet(pet2);
        petController.savePet(pet3);
        petController.savePet(pet4);
        petController.savePet(pet5);
        petController.savePet(pet6);
        petController.savePet(pet7);
        petController.savePet(pet8);
        petController.savePet(pet9);
        petController.savePet(pet10);
        petController.savePet(pet11);
        petController.savePet(pet12);
        petController.savePet(pet13);
        petController.savePet(pet14);

        List<Pet> pets = petController.getAllPets();

        System.out.println("\n***** PETS *****");
        display(pets);

        System.out.println("\n ***** OWNERS *****");
        display(owners);

        System.out.println("\nPets for Lisa\n");
        display(petController.getAllPetsForOwner(owner4));

        // TODO add other tests here


    }

    private static void display(Object obj) {

        if (obj instanceof List) {

            List<?> list = (List) obj;
            for (Object o : list) {
                System.out.println("\t" + o);
            }

        } else {

            System.out.println(obj);

        }

        System.out.println();
    }
}
