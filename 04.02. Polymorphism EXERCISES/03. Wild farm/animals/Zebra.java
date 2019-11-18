package wildfarm.animals;

import wildfarm.food.Food;

public class Zebra extends Mammal {
    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(food.getQuantity());
        } else {
            System.out.println(String.format("%ss are not eating that type of food!",
                    this.getClass().getSimpleName()));
            this.setFoodEaten(0);
        }
    }
}
