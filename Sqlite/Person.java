package com.example.aaaaaaaaaaaa;

public class Person {

    private String ID;
    private String Name;
    private String Age;
    private String Woman;
    private String Color;

    public Person(String ID, String name, String age, String woman, String color) {
        this.ID = ID;
        Name = name;
        Age = age;
        Woman = woman;
        Color = color;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getWoman() {
        return Woman;
    }

    public void setWoman(String woman) {
        Woman = woman;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
