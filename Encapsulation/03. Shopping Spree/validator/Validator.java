package validator;

import shoppingspree.product.Product;

public class Validator {

    public static void validateSide(String parameterName, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", parameterName));
        }
    }

    public static void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public static void validateAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public static void validateValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public static void haveEnoughMoney(String personName, double moneyAmount, Product productName, double price) {
        if (moneyAmount - price < 0) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", personName, productName));
        }
    }
    /*public static void hasNothingBought(int size) throws IllegalArgumentException {
        if (size == 0){
            throw new IllegalArgumentException("Nothing bought");
        }
    }*/
}
