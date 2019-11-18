package wildfarm.animals;

import wildfarm.food.Food;

public class Mouse extends Mammal {
    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(food.getQuantity());
        } else {//mouse in plural
            System.out.println("Mice are not eating that type of food!");

            this.setFoodEaten(0);
        }
    }
}
