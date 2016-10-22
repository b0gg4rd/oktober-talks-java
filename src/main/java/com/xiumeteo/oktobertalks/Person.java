package com.xiumeteo.oktobertalks;

import java.util.Arrays;
import java.util.List;

public class Person {

    public static final List<Person> somePeople = Arrays.asList(
            new Person( "Hillary", 10, "Mexico", Arrays.asList()), //
            new Person( "Donald", 20, "Mexico", Arrays.asList("Nearsoft", "SAT")),
            new Person( "El Peje", 10, "Guatemala", Arrays.asList("Google", "SAT")),
            new Person( "Margarita Zavala", 30, "Guatemala", Arrays.asList()),
            new Person( "Enrique Peña", 30, "Argentina", Arrays.asList("Nearsoft")),
            new Person( "La Gaviota", 25, "Argentina", Arrays.asList("Google", "Facebook"))
    );

    private String name;
    private int age;
    private String country;
    private List<String> jobs;

    public List<String> getJobs() {
        return jobs;
    }

    public Person(String name, int age, String country, List<String> jobs) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }
}
