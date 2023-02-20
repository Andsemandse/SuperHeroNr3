package com.example.superhero3.Model;
public class Superhero {
    private String heroName;
    private String Name;
    private String power;
    private int age;
    private double strength;

    public Superhero(String heroName, String Name, String power, int age, double strength)
    {
        this.heroName = heroName;
        this.Name = Name;
        this.power = power;
        this.age = age;
        this.strength = strength;
    }

    public String getHeroName(){
        return heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getPower(){
        return power;
    }

    public void setPower(String power){
        this.power = power;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getStrength()
    {
        return strength;
    }

    public void setStrength(double strength)
    {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Hero name: " + heroName + "\n" +
                "Name: " + Name + "\n" +
                "Power: " + power + "\n" +
                "Age: " + age + "\n" +
                "Strength: " + strength + "\n";
    }
}
