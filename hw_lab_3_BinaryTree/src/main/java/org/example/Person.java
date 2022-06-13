package org.example;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String surname;
    private String passport;
    private int age;

    public Person(){

    }

    public Person(Person person){
        this.surname = person.surname;
        this.passport = person.passport;
        this.age = person.age;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{ surname='" + surname + '\'' +
                ", passport='" + passport + '\'' +
                ", age=" + age + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return passport.equals(person.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public int compareTo(Person o) {
        return this.getSurname().compareTo(o.getSurname());
    }
}
