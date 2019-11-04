package pizzacalories;

import pizzacalories.dough.Dough;
import pizzacalories.pizza.Pizza;
import pizzacalories.toppings.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaType = reader.readLine().split("\\s+");
        String pizzaName = pizzaType[1];
        int toppingsAmount = Integer.parseInt(pizzaType[2]);

        String[] doughParameters = reader.readLine().split("\\s+");
        String doughType = doughParameters[1];
        String bakingTechnique = doughParameters[2];
        double doughWeight = Double.parseDouble(doughParameters[3]);


        try {
            Pizza pizza = new Pizza(pizzaName, toppingsAmount);
            Dough dough = new Dough(doughType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
            String command = reader.readLine();
            while (!command.equals("END")) {
                String[] toppingParameters = command.split("\\s+");
                String name = toppingParameters[1];
                double weight = Double.parseDouble(toppingParameters[2]);
                Topping topping = new Topping(name, weight);
                pizza.addTopping(topping);
                command = reader.readLine();
            }
            System.out.println(pizza.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
