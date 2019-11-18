package wildfarm.animals;

public abstract class Animal implements AnimalInt{
    String animalType;
    String animalName;
    Double animalWeight;
    Integer foodEaten = 0;

    protected Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten + this.getFoodEaten();
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }
}
