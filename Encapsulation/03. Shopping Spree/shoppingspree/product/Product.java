package shoppingspree.product;

import static validator.Validator.validateName;
import static validator.Validator.validateValue;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setCost(double cost) {
        validateValue(cost);
        this.cost = cost;
    }
}
