package com.example.demo3.model;

public class Person {
    private String name;
    private Integer age;
    public Person()  {
        super();
    }
    public Person(String name,Integer age) {
        super();
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public Integer getAge() {
        return age;
    }

    public Integer setAge(Integer age) {
        return age;
    }
}
