package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class OwnerControllerIntegrationTests implements ApplicationContextAware {

    private static ApplicationContext context;
    private static OwnerController controller;

    private static Owner owner1;
    private static Owner owner2;
    private static Owner owner3;
    private static Owner owner4;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        controller = (OwnerController) context.getBean("ownerController");
    }

    @Before
    public void setup() {

        owner1 = Owner.builder().withId(1L).withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner2 = Owner.builder().withId(2L).withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner3 = Owner.builder().withId(3L).withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner4 = Owner.builder().withId(4L).withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

    }

    @Test
    public void saveAndFindOwner() {

        // exercise
        controller.saveOwner(owner1);
        Owner actual = controller.getOwner(1L);

        // assert
        assertEquals(owner1, actual);

    }

    @Test
    public void saveAndModify() {

        // exercise
        controller.saveOwner(owner1);
        Owner actual = controller.getOwner(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        String expectedName = "Homer";
        owner1.setName(expectedName);
        controller.saveOwner(owner1);
        actual = controller.getOwner(1L);

        // assert
        assertEquals(owner1, actual);

        String actualName = owner1.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void saveAndDeleteOwner() {

        // exercise
        controller.saveOwner(owner1);
        Owner actual = controller.getOwner(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        controller.deleteOwner(owner1);
        actual = controller.getOwner(1L);

        // assert
        assertNull(actual);



    }

    @Test
    public void findAllOwners() {

        // exercise
        controller.saveOwner(owner1);
        controller.saveOwner(owner2);
        controller.saveOwner(owner3);
        controller.saveOwner(owner4);

        int actual = controller.getAllOwners().size();

        // assert
        assertEquals(4, actual);
    }


}