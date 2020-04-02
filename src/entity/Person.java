package entity;

import java.util.Objects;

public class Person {

    private String name;
    private String lastName;
    private int age;
    private String questionOne;
    private String questionTwo;

    public Person(String name, String lastName, int age, String questionOne, String questionTwo) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, lastName, age);
    }

    @Override
    public String toString() {
        return "entity.Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", questionOne='" + questionOne + '\'' +
                ", questionTwo='" + questionTwo + '\'' +
                '}';
    }
}
