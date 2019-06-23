package com.example.petclinic.controller;

import com.example.petclinic.model.Pet;
import com.example.petclinic.model.Vet;
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
public class VetControllerTest implements ApplicationContextAware {

    private static ApplicationContext context;
    private static VetController controller;

    private static Vet vet1;
    private static Vet vet2;
    private static Vet vet3;
    private static Vet vet4;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        controller = (VetController) context.getBean("vetController");
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