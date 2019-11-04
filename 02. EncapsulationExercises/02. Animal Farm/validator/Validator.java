package validator;

public class Validator {

    public static void validateSide(String parameterName, double value){
        if (value <= 0){
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", parameterName));
        }
    }

    public static void validateName(String name){
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }
    public static void validateAge(int age){
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
}
