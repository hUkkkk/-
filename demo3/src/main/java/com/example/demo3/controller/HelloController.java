package com.example.demo3.controller;

import com.example.demo3.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *测试Controller
 *@RestController 实现Rest服务的常用注解，相当于在@Controller的基础上，自动为将所有的请求方法追加@ResponseBody
 *实现以
 */
@Controller
public class HelloController {

    /**
     * 该请求默认以rest方式返回hello gradle
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        Person single = new Person("hyj",21);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("dlp",21);
        Person p2 = new Person("tq",21);
        Person p3 = new Person("mk",21);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }

}