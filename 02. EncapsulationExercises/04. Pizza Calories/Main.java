package pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Pizza pizza;
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            createPizza();
            createDough();
            addToppings();

            System.out.println(pizza.getName() + " " + pizza.getOverallCalories());

        } catch (IllegalArgumentException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void addToppings() throws IOException {
        String command = reader.readLine();
        while (command.equals("END")){
            String[] toppingData = command.split("\\s+");
            Topping topping = new Topping(toppingData[0], Double.parseDouble(toppingData[1]));
            pizza.addTopping(topping);
            command = reader.readLine();
        }
    }

    private static void createDough() throws IOException {
        String[] doughData = reader.readLine().split("\\s+");
        Dough dough = new Dough(doughData[0], doughData[1], Double.parseDouble(doughData[2]));
        pizza.setDough(dough);
    }

    private static void createPizza() throws IOException {
        String[] pizzaData = reader.readLine().split("\\s+");
        pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
    }
}
