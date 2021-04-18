package com.tobiasekman;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String stageName;

    public Artist() {

    }

    public Artist(String firstName, String lastName, int age, String stageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.stageName = stageName;
    }

    public Artist(int id, String firstName, String lastName, int age, String stageName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.stageName = stageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "]" +
                " [First name: " + getFirstName() + "]" +
                " [Last name: " + getLastName() + "]" +
                " [Age: " + getAge() + "]" +
                " [Stage name: " + getStageName() + "]";
    }
}
