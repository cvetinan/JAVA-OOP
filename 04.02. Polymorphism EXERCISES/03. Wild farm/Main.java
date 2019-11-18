package wildfarm;

import wildfarm.animals.*;
import wildfarm.food.Food;
import wildfarm.food.Meat;
import wildfarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal animal = null;
        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            Double weight = Double.parseDouble(tokens[2]);
            String livingRegion = tokens[3];
            switch (type){
                case "Cat":
                    String breed = tokens[4];
                    animal = new Cat(type,name,weight, livingRegion,breed);
                    break;
                case "Tiger":
                    animal = new Tiger(type,name,weight,livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(type,name,weight,livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(type,name,weight,livingRegion);
                    break;
            }
            animals.add(animal);

            String[] foodTokens = scanner.nextLine().split("\\s+");
            if (foodTokens[0].equals("End")){
                break;
            }
            Food food = null;
            switch (foodTokens[0]){
                case "Meat":
                    food = new Meat(Integer.parseInt(foodTokens[1]));
                    break;
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodTokens[1]));
                    break;
                default:
                    System.out.println(type + "are not eating that type of food!");
                    input = scanner.nextLine();
                    continue;
            }

            animals.get(animals.size() - 1).makeSound();
            assert animal != null;
            animal.eat(food);

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }
}
