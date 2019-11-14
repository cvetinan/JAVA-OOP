package wildfarm.animals;

import wildfarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",this.animalType,
                this.animalName, this.breed, decimalFormat.format(this.animalWeight),
                this.livingRegion, this.foodEaten);
    }
}
