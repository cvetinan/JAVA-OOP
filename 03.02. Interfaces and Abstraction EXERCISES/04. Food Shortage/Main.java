/*import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;*/

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        HashSet<Person> buyers = new HashSet<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        while (numberOfPeople-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens.length){
                case 4:
                    Person citizen = new Citizen(
                            tokens[0],
                            Integer.parseInt(tokens[1]),
                            tokens[2],
                            tokens[3]);
                    buyers.add(citizen);
                    break;
                case 3:
                    Person rebel = new Rebel(
                            tokens[0],
                            Integer.parseInt(tokens[1]),
                            tokens[2]);
                    buyers.add(rebel);
                    break;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String name = command;
            for (Person buyer : buyers) {
                if (buyer.getName().equals(name)){
                    buyer.buyFood();
                }
            }
            command = scanner.nextLine();
        }
        int sum = 0;
        for (Person buyer : buyers) {
            sum += buyer.getFood();
        }
        System.out.println(sum);*/
    }
}
