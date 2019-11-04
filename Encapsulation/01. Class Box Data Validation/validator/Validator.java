package validator;

public class Validator {

    public static void validateSide(String parameterName, double value){
        if (value <= 0){
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", parameterName));
        }
    }
}
