package com.example.recycle_view;


public class Person {

    private String name;
    private String surname;
    private String prefrence; // wheater he takes bus or plane

    public Person(String name, String surname, String prefrence) {
        this.name = name;
        this.surname = surname;
        this.prefrence = prefrence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPrefrence() {
        return prefrence;
    }

    public void setPrefrence(String prefrence) {
        this.prefrence = prefrence;
    }
}
