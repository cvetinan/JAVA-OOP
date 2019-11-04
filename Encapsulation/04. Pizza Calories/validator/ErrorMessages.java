package pizzacalories.validator;

public enum ErrorMessages {
    INVALID_DOUGH_TYPE(0, "Invalid type of dough."),
    INVALID_DOUGH_WEIGHT(1, "Dough weight should be in the range [1..200]."),
    INVALID_TOPPING_NAME(2, "Cannot place %s on top of your pizza."),
    INVALID_TOPPING_WEIGHT(3, "%s weight should be in the range [1..50]."),
    INVALID_PIZZA_NAME(4, "Pizza name should be between 1 and 15 symbols."),
    INVALID_TOPPING_AMOUNT(5, "Number of toppings should be in range [0..10].");

    private final int code;
    private final String description;

    private ErrorMessages(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

