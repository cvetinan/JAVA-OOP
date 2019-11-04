package pizzacalories.pizza;

import pizzacalories.dough.Dough;
import pizzacalories.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

import static pizzacalories.validator.DataValidation.ensureCapacity;
import static pizzacalories.validator.DataValidation.validatePizzaName;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        setName(name);
        setToppings(numberOfToppings);
    }

    public void setToppings(int numberOfToppings) {
        ensureCapacity(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double toppingsCalories = toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        double doughCalories = dough.calculateCalories();
        return toppingsCalories + doughCalories;
    }
    private void setName(String name) {
        validatePizzaName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getOverallCalories());
    }
}
