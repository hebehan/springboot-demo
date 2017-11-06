package com.hebehan.demo.controller;

import com.hebehan.demo.jparepository.PersonRepository;
import com.hebehan.demo.model.Person;
import com.hebehan.demo.model.Result;
import com.hebehan.demo.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result savePerson(Person person){
        return ResultUtil.success(personRepository.save(person));
    }

    @GetMapping("/getall")
    @ResponseBody
    public Result getAll(){
        return ResultUtil.success(personRepository.findAll());
    }
}
