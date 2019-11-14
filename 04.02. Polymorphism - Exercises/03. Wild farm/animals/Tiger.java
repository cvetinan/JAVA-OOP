package wildfarm.animals;

import wildfarm.food.Food;

public class Tiger extends Feline {
    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            this.setFoodEaten(food.getQuantity());
        } else {
            System.out.println(String.format("%ss are not eating that type of food!",
                    this.getClass().getSimpleName()));
            this.setFoodEaten(0);
        }
    }
}
