package com.example.petclinic;

import com.example.petclinic.controller.OwnerController;
import com.example.petclinic.controller.PetController;
import com.example.petclinic.controller.VetController;
import com.example.petclinic.controller.VisitController;
import com.example.petclinic.model.*;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PetClinicDriver implements ExitCodeGenerator {

    private static ConfigurableApplicationContext context;

    private static OwnerController ownerController;
    private static PetController petController;
    private static VisitController visitController;
    private static VetController vetController;

    public static void main(String[] args) {

        // We'll need a reference to the Spring IoC container (it's context).
        context = SpringApplication.run(PetClinicDriver.class, args);

        testApp();

        // part of exit code implementation
//        System.exit(SpringApplication.exit(context));
    }

    private static void testApp() {

        // We need references to each of the controllers in the context.
        // We use the context to retrieve managed beans by name.
        // The name of the bean is the type of bean (it's name) in camelcase, with the first letter lowercase (by default).
        ownerController = (OwnerController) context.getBean("ownerController");
        petController = (PetController) context.getBean("petController");
        visitController = (VisitController) context.getBean("visitController");
        vetController = (VetController) context.getBean("vetController");


        // ***** Owner *****

        // create our owners
        Owner owner1 = Owner.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner2 = Owner.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner3 = Owner.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner4 = Owner.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        // save owners to database
        ownerController.add(owner1);
        ownerController.add(owner2);
        ownerController.add(owner3);
        ownerController.add(owner4);

        // get all owners from database and display them
        display(ownerController.getAll());

        // ***** Pet *****

        // create some pets and add them to an existing owner
        Pet pet1 = Pet.builder().withName("Godzilla").withBirthDate(new Date()).withPetType(PetType.LIZARD).build();
        Pet pet2 = Pet.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withPetType(PetType.DOG).build();

        owner4.addPet(pet1);
        owner4.addPet(pet2);

        // display the owner info again
        display(ownerController.getAll());

        Pet pet3 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).build();
        Pet pet4 = Pet.builder().withName("Stompy").withBirthDate(new Date()).withPetType(PetType.ELEPHANT).build();

        petController.add(pet1);
        petController.add(pet2);
        petController.add(pet3);
        petController.add(pet4);

        display(petController.getAll());

        // ***** Visit *****
        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("description").build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("description").build();

        visit1.addPet(pet1);
        visit2.addPet(pet2);

        visitController.add(visit1);
        visitController.add(visit2);

        display(visitController.getAll());

        // ***** Vet *****
        List<Speciality> specialities = new ArrayList<Speciality>() {{
            add(Speciality.DENTISTRY);
            add(Speciality.RADIOLOGY);
        }};

        List<Visit> visits = new ArrayList<Visit>() {{
            add(visit1);
            add(visit2);
        }};

        Vet vet1 = Vet.builder().withName("Veterinarian").withSpecialities(specialities).build();
        // vet1 = new Vet("Veterinarian", specialities, visits);
        visit1.addVet(vet1);
        visit2.addVet(vet1);

        vetController.add(vet1);
        vetController.add(vet1);

        visitController.modify(visit1);
        visitController.modify(visit2);

        display(vetController.getAll());

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

    @Override
    public int getExitCode() {
        return 42;
    }
}
