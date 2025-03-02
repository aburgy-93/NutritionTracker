package edu.matc.entity;

public class Calculator {
    private int age;
    private String gender;
    private int heightFeet;
    private int heightInches;
    private double weight;
    private String activity;
    private String goal;

    public Calculator() {}

    public Calculator(int age, String gender, int heightFeet, int heightInches, double weight, String activity, String goal) {
        this.age = age;
        this.gender = gender;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weight = weight;
        this.activity = activity;
        this.goal = goal;
    }

    public String calculateMacros() {

    }
}
