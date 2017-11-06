package com.hebehan.demo;


import com.hebehan.demo.model.Person;
import com.hebehan.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    PersonService personService;

    @Test
    public  void testGetOne(){
        Person person = personService.getOne(1);
        System.out.println(person.toString());
    }
}
