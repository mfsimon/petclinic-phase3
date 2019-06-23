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
public class OwnerControllerTest implements ApplicationContextAware {

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

        // assumes you have the builder pattern implemented correctly in your Owner class
        // we can't count on the auto-generation of ids for tests - we have to hard code them to be sure we're referencing the same object each time
        /*
        owner1 = Owner.builder().withId(1L).withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner2 = Owner.builder().withId(2L).withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner3 = Owner.builder().withId(3L).withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner4 = Owner.builder().withId(4L).withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        */
    }

    @Test
    public void add() {

        /*
        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);
        */

    }

    @Test
    public void modify() {

        /*
        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        String expectedName = "Homer";
        owner1.setName(expectedName);
        controller.add(owner1);
        actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        String actualName = owner1.getName();

        assertEquals(expectedName, actualName);
        */
    }

    @Test
    public void delete() {

        /*
        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        controller.delete(owner1);
        actual = controller.get(1L);

        // assert
        assertNull(actual);
        */


    }

    @Test
    public void getAll() {

        /*
        // exercise
        controller.add(owner1);
        controller.add(owner2);
        controller.add(owner3);
        controller.add(owner4);

        int actual = controller.getAll().size();

        // assert
        assertEquals(4, actual);
        */
    }

}
