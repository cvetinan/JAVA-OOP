package pizzacalories.toppings;

import static pizzacalories.validator.DataValidation.validateTopping;
import static pizzacalories.validator.DataValidation.validateToppingWeight;

public class Topping {
    private final static double BASE_CALORIES_INDEX = 2.0;
    private final static double MEAT = 1.2;
    private final static double VEGGIES = 0.8;
    private final static double CHEESE = 1.1;
    private final static double SAUCE = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories(){
        double toppingCalories = getToppingCalories(getToppingType());
        return (BASE_CALORIES_INDEX * this.weight) * toppingCalories;
    }

    private double getToppingCalories(String toppingType) {
        double toppingCalories = 0.0;
        switch (toppingType.toLowerCase()){
            case "meat":
                toppingCalories = MEAT;
                break;
            case "veggies":
                toppingCalories = VEGGIES;
                break;
            case "cheese":
                toppingCalories = CHEESE;
                break;
            case "sauce":
                toppingCalories = SAUCE;
                break;
        }
        return toppingCalories;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        validateTopping(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        validateToppingWeight(weight, this.toppingType);
        this.weight = weight;
    }
}
