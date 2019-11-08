package animalfarm;

import static validator.Validator.validateAge;
import static validator.Validator.validateName;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age){
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay(){
        double result = 0;
        if (this.getAge() >= 12){
            result = 0.75;
        } else if (this.getAge() >= 6){
            result = 1.00;
        } else {
            result = 2.00;
        }
        return result;
    }

    private void setName(String name){
        validateName(name);
        this.name = name;
    }

    private void setAge(int age){
        validateAge(age);
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(), getAge(), productPerDay());
    }
}
