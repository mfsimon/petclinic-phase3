package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class PetControllerTest implements ApplicationContextAware {

    private static ApplicationContext context;
    private static PetController controller;

    private static Pet pet1;
    private static Pet pet2;
    private static Pet pet3;
    private static Pet pet4;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        controller = (PetController) context.getBean("petController");
    }

    @Before
    public void setup() {

        // TODO create test objects here
    }

    @Test
    public void add() {
    }

    @Test
    public void modify() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }
}