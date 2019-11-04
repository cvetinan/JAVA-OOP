package pizzacalories.validator;

import pizzacalories.dough.DoughModifiers;
import pizzacalories.dough.Type;
import pizzacalories.toppings.ToppingsModifiers;

public class DataValidation {

    public static void validateDoughType(String type) {
        if (!Type.isMember(type)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DOUGH_TYPE.toString());
        }
    }

    public static void validateBackingTechnique (String type) {
        if (!DoughModifiers.isMember(type)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DOUGH_TYPE.toString());
        }
    }
    public static void validateDoughWeigh(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DOUGH_WEIGHT.toString());
        }
    }

    public static void validateTopping(String type){
        if (!ToppingsModifiers.isMember(type)){
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_TOPPING_NAME.toString(), type));
        }
    }

    public static void validateToppingWeight(double weight, String type){
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_TOPPING_WEIGHT.toString(), type));
        }
    }

    public static void validatePizzaName(String name){
        if (name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException(ErrorMessages.INVALID_PIZZA_NAME.toString());
        }
    }
    public static void ensureCapacity(int amount){
        if (amount < 0 || amount > 10){
            throw new IllegalArgumentException(ErrorMessages.INVALID_TOPPING_AMOUNT.toString());
        }
    }
}





