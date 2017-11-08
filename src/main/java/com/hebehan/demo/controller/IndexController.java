package com.hebehan.demo.controller;

import com.hebehan.demo.exception.PersonException;
import com.hebehan.demo.jparepository.PersonRepository;
import com.hebehan.demo.model.Person;
import com.hebehan.demo.model.Result;
import com.hebehan.demo.utils.ResultUtil;
import com.hebehan.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("user","hahhaah");
        return "index";
    }

    @PostMapping("/save")
    @ResponseBody
    public Result savePerson(Person person){
        return ResultUtil.success(personRepository.save(person));
    }

    @GetMapping("/getall")
    @ResponseBody
    public Result getAll(Model model){
        System.out.println("getall 执行中");
        model.addAttribute("list",personRepository.findAll());
        return ResultUtil.success(personRepository.findAll());
    }

    @GetMapping("/savetwo")
    public void saveTwoTest(){
        personService.saveTwo();
    }

    @GetMapping("/getage/{id}")
    public void getAge(@PathVariable(value = "id") long id)throws PersonException{
        personService.getAge(id);
    }

    @GetMapping("/personlist")
    public String togetList(Model model){
        System.out.println("method in getList!");
        model.addAttribute("persons",personRepository.findAll());
        return "personlist";
    }

    @GetMapping("/saveperson")
    public String tosavePerson(){
        return "saveperson";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



    @PostMapping("/loginverify")
    public String loginverify(@RequestParam("id") long id,Model model){
        Person person = personRepository.findOne(id);
        System.out.println(person==null?"person is null":"person is not null");
        if (person != null){
            model.addAttribute("result",person);
        }
        return "loginresult";
    }
}
