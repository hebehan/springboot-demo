package com.hebehan.demo.restful;


import com.hebehan.demo.jparepository.PersonRepository;
import com.hebehan.demo.model.Person;
import com.hebehan.demo.model.Result;
import com.hebehan.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonRestful {


    @Autowired
    PersonRepository personRepository;

    @GetMapping("/getall")
    public Result getall(){
        return ResultUtil.success(personRepository.findAll());
    }

    @PostMapping("/save")
    public Result savePerson(Person person){
        return ResultUtil.success(personRepository.save(person));
    }
}
