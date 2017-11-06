package com.hebehan.demo.service;

import com.hebehan.demo.exception.PersonException;
import com.hebehan.demo.jparepository.PersonRepository;
import com.hebehan.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    /**
     * 加入事务可以让插入错误的操作全部回滚
     */
    @Transactional
    public void saveTwo(){
        Person person = new Person();
        person.setAge(18);
        person.setName("lisi");
        personRepository.save(person);

        Person person1 = new Person();
        person1.setAge(18);
        person1.setName(null);
        personRepository.save(person1);
    }

    public void getAge(long id) throws PersonException{
        Person person = personRepository.getOne(id);
        if (person == null)
            throw new PersonException(100,"person is null");
        int age = person.getAge();
        if (age <= 13)
            throw new PersonException(101,"person is too small");
        if (age > 13)
            throw new PersonException(102,"person is ok");
    }

    public Person getOne(long id){
        return personRepository.getOne(id);
    }


}
