// ONLY FOR TASK ANIMALS

import animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        String command = reader.readLine();
        while (!command.equals("Beast!")) {
            String type = command;
            String[] parameters = reader.readLine().split("\\s+");
            String name = parameters[0];
            int age = Integer.parseInt(parameters[1]);
            String gender = parameters[2];

            switch (command) {
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    animals.add(cat);
                    break;
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    animals.add(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    animals.add(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    animals.add(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    animals.add(tomcat);
                    break;
            }
            command = reader.readLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}

